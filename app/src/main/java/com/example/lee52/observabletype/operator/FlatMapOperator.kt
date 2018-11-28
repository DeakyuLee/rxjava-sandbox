package com.example.lee52.observabletype.operator

import android.util.Log
import com.example.lee52.observabletype.model.User
import com.example.lee52.observabletype.network.NetworkManager
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FlatMapOperator {
    val className = "FlatMapOperator"

    private fun getObservable() = NetworkManager.userService.getUsers()

    private fun getObserver(showLoader: () -> Unit, hideLoader: () -> Unit) = object : Observer<User> {
        override fun onComplete() {
            hideLoader()
        }

        override fun onSubscribe(d: Disposable) {
            showLoader()
        }

        override fun onNext(t: User) {
            Log.d(className, "$t")
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
        }
    }

    fun getFlattenedUsers(showLoader: () -> Unit, hideLoader: () -> Unit) {
        getObservable()
                .flatMap { // return user one by one, each as individual observable
                    Observable.fromIterable(it)
                }
                .filter {
                    it.id % 2 == 0
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver(showLoader, hideLoader))
    }
}