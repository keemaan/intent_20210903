package com.example.intent_20210903

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE_NICKNAME = 1004

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callBtn.setOnClickListener {
//  문법상 에러가 없어도 앱이 죽음.
//  권한 획득해야 정상 동작.
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent( Intent.ACTION_CALL, myUri )
            startActivity(myIntent)
        }

//        전화걸기(DIAL) Intent 활용예시
        dialBtn.setOnClickListener {
            val inputPhoneNum = phoneNumEdt.text.toString()
//            어디에 전화를 걸지 알려주는 정보(Uri)로 가공
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent( Intent.ACTION_DIAL, myUri )
            startActivity(myIntent)
        }


        editNicknameBtn.setOnClickListener {
            val myIntent = Intent(this,EditNicknameActivity::class.java)
            startActivityForResult(myIntent, REQUEST_CODE_NICKNAME)
        }

        sendMessageBtn.setOnClickListener {
            val inputContent = messageEdt.text.toString()
            val myIntent = Intent(this,ViewMessageActivity::class.java)
            myIntent.putExtra("inputMessage", inputContent)
            myIntent.putExtra("number",2021)
            startActivity(myIntent)
        }

        moveToOtherBtn.setOnClickListener {
        val myIntent = Intent(this,OtherActivity::class.java)
            startActivity(myIntent)
        }
    }
//    startActivityForResult를 통해서 이동한 화면에서 메인화면으로 복귀하면 아래 실행(함수)
//    완료 또는 취소를 누르건 무조건 실행되는 함수, 두 상황을 구별하자.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Toast.makeText(this,"결과를 가지고 돌아옴",Toast.LENGTH_SHORT).show()

//      1. requestCode : int -> startActivityForResutl에 넣어준 숫자값이 뭐였는가
//      => 어디를 다녀온 것인지 알려주는 역할
//      => 이번에 다녀온게, 닉네임을 받으러 다녀온건지? 상황에 맞는 코드.

        if (requestCode == REQUEST_CODE_NICKNAME) {

//      2.resultcode : int ->     돌아올 때 RESULT_OK를 갖고 왔는지, 취소값으로 갖고 왔는지
//      확인을 누른게 맞는지 구별의 근거자료
            if (resultCode== RESULT_OK) {
//      넥네임-> OK까지 한 상황, 받아온 닉네임 값을 텍스트뷰에 반영
//      data변수에 ->resultIntent가 담겨있는 상황 -> 갖고 있는 STring 하나를 꺼내라고 하자
                val newNicknamek = data?.getStringExtra("newNickname")
                nicknameTxt.text = newNicknamek
            }
        }


    }
}