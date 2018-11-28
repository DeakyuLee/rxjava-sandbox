package com.example.lee52.observabletype.observableType

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class BasicObservable {

    private val className = "BasicObservable"

    private fun getObservable() = Observable.just("Cricket", "Foorball")

    private fun getObserver() = object : Observer<String> {
        override fun onComplete() {
            Log.d(className, "onComplete")
        }

        override fun onSubscribe(d: Disposable) {}

        override fun onNext(t: String) {
            Log.d(className, t)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
        }
    }

    fun doSomeWork() {
        getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver())
    }
}