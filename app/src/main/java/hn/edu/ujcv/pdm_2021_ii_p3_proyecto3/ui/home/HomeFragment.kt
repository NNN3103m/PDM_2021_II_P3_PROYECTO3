package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.content.Intent
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.databinding.FragmentHomeBinding
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.restaurants.RestaurantActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        binding.imageFFood.setOnClickListener{
            if (container != null) {
                val intent = Intent(container.context, RestaurantActivity::class.java)
                startActivity(intent)
            }
//            val intent = Intent(RestaurantActivity::class.java)
//            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}