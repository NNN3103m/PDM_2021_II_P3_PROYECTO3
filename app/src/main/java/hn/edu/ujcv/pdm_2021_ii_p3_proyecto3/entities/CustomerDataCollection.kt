package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities

import android.widget.EditText
import java.math.BigInteger
import kotlin.collections.ArrayList

class CustomerDataCollection : ArrayList<CustomerDataCollection>()

data class CustomerDataCollectionItem(
    val id: Long?,
    val dni: EditText,
    val mobile: EditText,
    val nombre: EditText,
    val email: EditText,
    val password: EditText
)