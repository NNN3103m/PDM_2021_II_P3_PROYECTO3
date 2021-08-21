package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities

class CreditcardDataCollection : ArrayList<AddressDataCollectionItem>()

data class CreditcardDataCollectionItem(
    val creditcardNumber:Int,
    val customerDni:Int,
    val cvv:Int,
    val expiration_date:String="",
    val nametag:String =""
)