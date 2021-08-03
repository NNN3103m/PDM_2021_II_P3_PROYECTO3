package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3

import kotlinx.android.synthetic.main.activity_contact.*



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)


        ctcBtnSend.setOnClickListener {
        }

    }
}