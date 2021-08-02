package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.restaurants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.R

class RestaurantAdapter : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {
    private val restaurants = arrayOf(
        "Comercio 1",
        "Comercio 2",
        "Comercio 3",
        "Comercio 4",
        "Comercio 5"
    )

    private val details = arrayOf(
        "",
        "",
        "",
        "",
        ""

    )
    private val images = intArrayOf(
        R.drawable.house,
        R.drawable.house,
        R.drawable.house,
        R.drawable.house,
        R.drawable.house
    )
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout,viewGroup, false)
        return ViewHolder(v)
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var restaurantImage: ImageView
        var restaurantName: TextView
        var restaurantDetail: TextView
        init {
            restaurantImage = itemView.findViewById(R.id.restaurant_image)
            restaurantName = itemView.findViewById(R.id.restaurant_name)
            restaurantDetail = itemView.findViewById(R.id.restaurant_detail)

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v,"Click en el item $position",
                    Snackbar.LENGTH_LONG).setAction("Action",null).show()
            }
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.restaurantName.text = restaurants[position]
        viewHolder.restaurantDetail.text = details[position]
        viewHolder.restaurantImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }
}