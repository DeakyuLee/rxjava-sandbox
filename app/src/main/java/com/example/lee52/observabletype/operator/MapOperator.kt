package com.example.lee52.observabletype.operator

import android.util.Log
import com.example.lee52.observabletype.model.SimpleUser
import com.example.lee52.observabletype.model.User
import com.example.lee52.observabletype.network.NetworkManager
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MapOperator {
    private val className = "MapOperator"

    private fun getObservable() = NetworkManager.userService.getUsers()

    private fun getObserver(showLoader: () -> Unit, hideLoader: () -> Unit) = object : Observer<List<SimpleUser>> {
        override fun onComplete() {
            hideLoader()
        }

        override fun onSubscribe(d: Disposable) {
            showLoader()
        }

        override fun onNext(t: List<SimpleUser>) {
            t.forEach {
                Log.d(className, "$it")
            }
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
        }
    }

    fun doSomeWork(showLoader: () -> Unit, hideLoader: () -> Unit) {
        getObservable()
                .map {
                    it.map {
                        SimpleUser(it.id, it.avatar_url, it.type)
                    }
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver(showLoader, hideLoader))
    }
}