package com.hanseltritama.rxbus

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_child.*
import kotlinx.android.synthetic.main.content_child.*

class ChildActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        buttonChild.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                // Publisher
                RxBus.publish(RxBusEvent.MessageEvent(editTextChild.text.toString()))

                finish()
            }
        })
    }

}
