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
        }
        btnregister.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    fun valempty(){
        val usermail = txt_userEmail.text.toString()
        val userpassword = txt_userEmail.text.toString()
        if (usermail.length == 0 || userpassword.length == 0){
            Toast.makeText(this,"Debe ingresar un correo y una clave.", Toast.LENGTH_SHORT).show()
        }
    }

    fun validateCreds(){
        var usermail = txt_userEmail.text.toString()
        var userpassword = txt_userEmail.text.toString()
        if (usermail == "admin" || userpassword == "admin"){
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this,"Credenciales inválidas. Intenta nuevamente.", Toast.LENGTH_SHORT).show()
        }
    }
}

