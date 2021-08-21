package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.CreditcardDataCollectionItem
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.RestApiError
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreditCardFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit_card_form)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Tarjetas"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

//    Add cc method
    fun addCreditcard(creditcardData: CreditcardDataCollectionItem, onResult: (CreditcardDataCollectionItem?) -> Unit){
        val retrofit = RestEngine.buildService().create(CreditcardService::class.java)
        var result: Call<CreditcardDataCollectionItem> = retrofit.addCreditcard(creditcardData)

        result.enqueue(object : Callback<CreditcardDataCollectionItem> {
            override fun onResponse(
                call: Call<CreditcardDataCollectionItem>,
                response: Response<CreditcardDataCollectionItem>
            ) {
                if (response.isSuccessful) {
                    val addedCreditcard = response.body()!!
                    onResult(addedCreditcard)
                }
                else if (response.code() == 500) {
                    val errorResponse = Gson().fromJson(response.errorBody()!!.string()!!, RestApiError::class.java)

                    Toast.makeText(this@CreditCardFormActivity,errorResponse.errorDetails, Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(this@CreditCardFormActivity, "Fallo al traer el item", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<CreditcardDataCollectionItem>, t: Throwable) {
                onResult(null)
            }
        })
    }

//    Post Creditcard
    private fun callServicePostCreditcard(){
    val creditcardInfo = CreditcardDataCollectionItem(

         creditcardNumber = findViewById(R.id.txt_new_id),
         customerDni = findViewById(R.id.txt_new_id),
         cvv = findViewById(R.id.txt_new_id),
         expiration_date = findViewById(R.id.txt_new_id),
         nametag = findViewById(R.id.txt_new_id),
        )
////  ^^ Agregar controllers text de captura de datos

        addCreditcard(creditcardInfo){ if (it?.creditcardNumber != null){
            Toast.makeText(this@CreditCardFormActivity, "OK"+it?.creditcardNumber, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this@CreditCardFormActivity, "Error",Toast.LENGTH_LONG).show()
         }
    }


    }
}