package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities

class AddressDataCollection: ArrayList<AddressDataCollectionItem>()

data class AddressDataCollectionItem(
    val description:String="",
    val addressId:Long = 0,
    val country:String="",
    val department:String="",
    val city:String="",
    val postalCode:Int=0,
    val streetName:String="",
    val houseNumber:Int,
    val customerDni:String=""
)