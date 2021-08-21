package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.databinding.ActivityMainMenuBinding
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.CustomerDataCollectionItem
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.restaurants.RestaurantActivity
import kotlinx.android.synthetic.main.activity_main_menu.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Inicio"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main_menu)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

//        ImageHandlers

        imageFFood.setOnClickListener{
            val intent = Intent(this, RestaurantActivity::class.java)
            startActivity(intent)
        }
        imageBakery.setOnClickListener{
            val intent = Intent(this, RestaurantActivity::class.java)
            startActivity(intent)
        }
        imageHome.setOnClickListener{
            val intent = Intent(this, RestaurantActivity::class.java)
            startActivity(intent)
        }
        imageTechnology.setOnClickListener{
            val intent = Intent(this, RestaurantActivity::class.java)
            startActivity(intent)
        }

        profileButton.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


// Services Call
//    Get Customers
    private fun callServiceGetCustomers(){
        val customerService: CustomerService = RestEngine.buildService().create(CustomerService::class.java)
        var result: Call<List<CustomerDataCollectionItem>> = customerService.listCustomers()

        result.enqueue(object : Callback<List<CustomerDataCollectionItem>> {
            override fun onFailure(call: Call<List<CustomerDataCollectionItem>>, t: Throwable) {
                Toast.makeText(this@MainMenuActivity, "Error", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<List<CustomerDataCollectionItem>>,
                response: Response<List<CustomerDataCollectionItem>>
            ) {
                Toast.makeText(this@MainMenuActivity, "Ok"+response.body()!!.get(0).nombre,Toast.LENGTH_LONG)
            }
        })
    }

//    Get Customer by Id

    private fun callServiceGetCustomer(){
        val customerService:CustomerService = RestEngine.buildService().create(CustomerService::class.java)
//        Hacer get de entry, aqui esta en hardcoded/quemado
        var result: Call<CustomerDataCollectionItem> = customerService.getCustomerById(1)

        result.enqueue(object : Callback<CustomerDataCollectionItem>{
            override fun onFailure(call: Call<CustomerDataCollectionItem>, t: Throwable) {
                Toast.makeText(this@MainMenuActivity, "Error", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<CustomerDataCollectionItem>,
                response: Response<CustomerDataCollectionItem>
            ) {
                Toast.makeText(this@MainMenuActivity, "OK"+response.body()!!.nombre,Toast.LENGTH_LONG).show()
            }
        })
    }

//    Post Customer
    private fun callServicePostCustomer(){
        val fecha = "2021-8-20"
    val customerInfo = CustomerDataCollectionItem(null,
        dni= 888888888888,
        mobile= 99999999,
        nombre= "dan",
        email="dan.mail@domain.com",
        password="dan.password"
        )

//        addCustomer(customerInfo){
//            if (it?)
//        }
    }
}