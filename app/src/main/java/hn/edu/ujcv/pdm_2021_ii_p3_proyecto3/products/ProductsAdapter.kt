package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.R


class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    private val products = arrayOf(
        "Comercio 1",
        "Comercio 2",
        "Comercio 3",
        "Comercio 4",
        "Comercio 5"
    )

    private val products_details = arrayOf(
        "Apertura: 8:00 AM | Cierre: 9:00 PM",
        "Apertura: 8:00 AM | Cierre: 9:00 PM",
        "Apertura: 8:00 AM | Cierre: 9:00 PM",
        "Apertura: 8:00 AM | Cierre: 9:00 PM",
        "Apertura: 8:00 AM | Cierre: 9:00 PM"

    )
    private val products_images = intArrayOf(
        R.drawable.restaurant,
        R.drawable.restaurant,
        R.drawable.restaurant,
        R.drawable.restaurant,
        R.drawable.restaurant
    )
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout,viewGroup, false)
        return ViewHolder(v)
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var productsImage: ImageView
        var productsName: TextView
        var productsDetail: TextView
        init {
            productsImage = itemView.findViewById(R.id.restaurant_image)
            productsName = itemView.findViewById(R.id.restaurant_name)
            productsDetail = itemView.findViewById(R.id.restaurant_detail)

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v,"Click en el item $position",
                    Snackbar.LENGTH_LONG).setAction("Action",null).show()
            }
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.productsName.text = products[position]
        viewHolder.productsDetail.text = products_details[position]
        viewHolder.productsImage.setImageResource(products_images[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }
}
