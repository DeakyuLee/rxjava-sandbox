package com.example.lee52.observabletype.subject

import android.util.Log
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.ReplaySubject

/**
 * Replay Subject
 *
 * It emits all the items of the source Observable, regardless of when the subscriber subscribes
 *
 * Here, if a student entered late into the classroom, he wants to listen from the beginning.
 * So, here we will use Replay to achieve this.
 * */
class ReplaySubjectExample {

    private val className = "ReplaySubjectExample"

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
        val source = ReplaySubject.create<Int>()

        source.subscribe(getFirstObserver())
        source.onNext(1)
        source.onNext(2)
        source.onNext(3)
        source.onNext(4)
        source.onComplete()
        source.subscribe(getSecondObserver())
    }

}