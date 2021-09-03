package com.example.intent_20210903

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)

        okBtn.setOnClickListener {
            val inputNickname = nicknameEdt.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("newNickname",inputNickname)

//      if okBtn click
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}