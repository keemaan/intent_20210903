package com.example.intent_20210903

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_message.*

class ViewMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_message)

        val receivedMessage = intent.getStringExtra("inputMessage")
        val num = intent.getIntExtra("number",0)

        messageTxt.text = receivedMessage
        numberTxt.text = num.toString()
    }
}