package com.example.lee52.observabletype.subject

import android.util.Log
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.AsyncSubject

class AsyncSubjectExample {

    private val className = "AsyncSubjectEx"

    private fun getFirstObserver() = object : Observer<Int> {
        override fun onComplete() {
            Log.d("$className 1", "onComplete")
        }

        override fun onSubscribe(d: Disposable) {
            Log.d("$className 1", "onSubscribe")
        }

        override fun onNext(t: Int) {
            Log.d("$className 1", "$t")
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
        }
    }

    private fun getSecondObserver() = object : Observer<Int> {
        override fun onComplete() {
            Log.d("$className 2", "onComplete")
        }

        override fun onSubscribe(d: Disposable) {
            Log.d("$className 2", "onSubscribe")
        }

        override fun onNext(t: Int) {
            Log.d("$className 2", "$t")
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
        }
    }

    fun doSomeWork() {
        val source = AsyncSubject.create<Int>()

        source.subscribe(getFirstObserver())

        source.onNext(1)
        source.onNext(2)
        source.onNext(3)

        source.subscribe(getSecondObserver())

        source.onNext(4)
        source.onComplete()
    }

}