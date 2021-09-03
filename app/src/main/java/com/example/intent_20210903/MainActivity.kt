package com.example.intent_20210903

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendMessageBtn.setOnClickListener {
            val inputContent = messageEdt.text.toString()
            val myIntent = Intent(this,ViewMessageActivity::class.java)
            myIntent.putExtra("inputMessage", inputContent)
            startActivity(myIntent)

        }

        moveToOtherBtn.setOnClickListener {
        val myIntent = Intent(this,OtherActivity::class.java)
            startActivity(myIntent)
        }
    }
}