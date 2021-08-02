package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //        BtnHandlers
        btnlogin.setOnClickListener{
            valempty()
            validateCreds()
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }
        btnregister.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}

fun valempty(){
//    val usermail = txt_userEmail.text.toString().lowercase(Locale.getDefault())
//    val user_mail = txt_userEmail.text.toString().trim().lowercase(Locale.getDefault())
//    if (user_mail.length == 0){
//        Toast.makeText(this,"Debe ingresar una letra.", Toast.LENGTH_SHORT).show()
}

fun validateCreds(){


//    if (usermail.text = "" || userpassword = ""){
//        intent
//        start activity
//    } else {
//        Toast.makeText(, "Credenciales equivocadas, intenta nuevamente", Toast.LENGTH_SHORT).show()
//    }
}