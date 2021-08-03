package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.databinding.ActivityMainMenuBinding
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.restaurants.RestaurantActivity
import kotlinx.android.synthetic.main.activity_main_menu.*
import kotlinx.android.synthetic.main.fragment_home.*

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
}