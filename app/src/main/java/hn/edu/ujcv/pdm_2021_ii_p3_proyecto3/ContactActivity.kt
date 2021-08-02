package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3

import kotlinx.android.synthetic.main.activity_contact.*



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        button_contact.setOnClickListener {
            valempty()
        }


    }
    fun valempty(){
//        val userName = txt_new_name.text.toString()
//        val userPassword = txt_new_password.text.toString()
//        val userMail = txt_new_email.text.toString()
//        val userDir = txt_new_direction.text.toString()
//        val userPhone = txt_new_phone_number.text.toString()

        when{
            txt_new_nombre.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar su Nombre", Toast.LENGTH_SHORT).show()
            txt_new_correo.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar su Email", Toast.LENGTH_SHORT).show()
            txt_new_mensaje.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar su Mensaje", Toast.LENGTH_SHORT).show()

            else -> {
                val intent = Intent(this, LoginActivity::class.java)
                Toast.makeText(this,"envio", Toast.LENGTH_LONG).show()
                startActivity(intent)
            }
        }
    }
}