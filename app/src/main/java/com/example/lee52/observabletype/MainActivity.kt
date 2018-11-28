package com.example.lee52.observabletype

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import com.example.lee52.observabletype.observableType.BasicObservable
import com.example.lee52.observabletype.operator.FlatMapOperator
import com.example.lee52.observabletype.operator.MapOperator
import com.example.lee52.observabletype.subject.AsyncSubjectExample
import com.example.lee52.observabletype.subject.BehaviorSubjectExample
import com.example.lee52.observabletype.subject.PublishSubjectExample
import com.example.lee52.observabletype.subject.ReplaySubjectExample

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val buttonMapOperator: Button by lazy {
        findViewById<Button>(R.id.button_operator_map)
    }

    private val buttonFlatMapOperator: Button by lazy {
        findViewById<Button>(R.id.button_operator_flatmap)
    }

    private val buttonPublishSubject: Button by lazy {
        findViewById<Button>(R.id.button_subject_publish)
    }

    private val buttonReplaySubject: Button by lazy {
        findViewById<Button>(R.id.button_subject_replay)
    }

    private val buttonBehaviorSubject: Button by lazy {
        findViewById<Button>(R.id.button_subject_behavior)
    }

    private val buttonAsyncSubject: Button by lazy {
        findViewById<Button>(R.id.button_subject_async)
    }

    private val loader: ProgressBar by lazy {
        findViewById<ProgressBar>(R.id.loader)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerClickListeners()
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.button_operator_map -> {
                MapOperator().doSomeWork(showLoader, hideLoader)
            }
            R.id.button_operator_flatmap -> {
                FlatMapOperator().getFlattenedUsers(showLoader, hideLoader)
            }
            R.id.button_subject_publish -> {
                PublishSubjectExample().doSomeWork()
            }
            R.id.button_subject_replay -> {
                ReplaySubjectExample().doSomeWork()
            }
            R.id.button_subject_behavior -> {
                BehaviorSubjectExample().doSomeWork()
            }
            R.id.button_subject_async -> {
                AsyncSubjectExample().doSomeWork()
            }
        }
    }

    private val showLoader = {
        loader.visibility = View.VISIBLE
    }

    private val hideLoader = {
        loader.visibility = View.GONE
    }

    private fun registerClickListeners() {
        buttonMapOperator.setOnClickListener(this)
        buttonFlatMapOperator.setOnClickListener(this)
        buttonPublishSubject.setOnClickListener(this)
        buttonReplaySubject.setOnClickListener(this)
        buttonBehaviorSubject.setOnClickListener(this)
        buttonAsyncSubject.setOnClickListener(this)
    }
}
