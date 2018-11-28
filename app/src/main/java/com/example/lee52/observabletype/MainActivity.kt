package com.example.lee52.observabletype

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import com.example.lee52.observabletype.observableType.BasicObservable
import com.example.lee52.observabletype.operator.FlatMapOperator
import com.example.lee52.observabletype.operator.MapOperator

class MainActivity : AppCompatActivity() {

    private val actionButton: Button by lazy {
        findViewById<Button>(R.id.button_for_action)
    }

    private val loader: ProgressBar by lazy {
        findViewById<ProgressBar>(R.id.loader)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionButton.setOnClickListener {
//            BasicObservable().doSomeWork()

//            MapOperator().doSomeWork({
//                actionButton.visibility = View.GONE
//                loader.visibility = View.VISIBLE
//            }, {
//                actionButton.visibility = View.VISIBLE
//                loader.visibility = View.GONE
//            })

            FlatMapOperator().getFlattenedUsers({
                actionButton.visibility = View.GONE
                loader.visibility = View.VISIBLE
            }, {
                actionButton.visibility = View.VISIBLE
                loader.visibility = View.GONE
            })
        }
    }
}
