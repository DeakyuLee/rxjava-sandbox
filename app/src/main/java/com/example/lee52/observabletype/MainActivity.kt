package com.example.lee52.observabletype

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.lee52.observabletype.observableType.BasicObservable

class MainActivity : AppCompatActivity() {

    private val actionButton: Button by lazy {
        findViewById<Button>(R.id.button_for_action)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionButton.setOnClickListener {
            BasicObservable().doSomeWork()
        }
    }
}
