package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3

import android.telecom.Call
import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.entities.AddressDataCollectionItem
import okhttp3.ResponseBody
import retrofit2.http.*


interface AddressService {
    @GET("addresses")
    fun listAddressess(): Call<List<AddressDataCollectionItem>>

    @GET("addresses/id/{id}")
    fun getAddressById(@Path("id") id: Long): Call<AddressDataCollectionItem>
    @Headers("Content-Type: application/json")

    @GET("addresses/streetName/{streetName}")
    fun getAddressByStreetName(@Path("streetName") streetNameAddress: String): Call<AddressDataCollectionItem>
    @Headers("Content-Type: application/json")

    @GET("addresses/city/{city}")
    fun getAddressByCity(@Path("streetName") cityAddress: String): Call<AddressDataCollectionItem>
    @Headers("Content-Type: application/json")

    @POST("addresses/addAddress")
    fun addCustomer(@Body addressData: AddressDataCollectionItem): Call<AddressDataCollectionItem>
    @Headers("Content-Type: application/json")

    @PUT("addresses")
    fun updateCustomer(@Body addressData: AddressDataCollectionItem): Call<AddressDataCollectionItem>

    @DELETE("addresses/delete/{id}")
    fun deleteCustomer(@Path("id") idAdress: Long): Call<ResponseBody>
}