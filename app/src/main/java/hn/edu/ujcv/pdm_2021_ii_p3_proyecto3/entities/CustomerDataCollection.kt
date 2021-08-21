package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities

class CustomerDataCollection : ArrayList<CustomerDataCollection>()

data class CustomerDataCollectionItem(
    val id: Long?,
    val dni:Long,
    val mobile:Int,
    val nombre:String,
    val email: String,
    val password:String
)