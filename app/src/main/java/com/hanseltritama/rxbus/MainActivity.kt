package com.hanseltritama.rxbus

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Tell Lint to ignore the specified warnings this annotated element.
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Subscriber
        RxBus.listen(RxBusEvent.MessageEvent::class.java)
            .subscribe{
                editTextParent.setText(it.message)
            }

        buttonParent.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                intent = Intent(this@MainActivity, ChildActivity::class.java)
                startActivity(intent)
            }
        })

    }
}
