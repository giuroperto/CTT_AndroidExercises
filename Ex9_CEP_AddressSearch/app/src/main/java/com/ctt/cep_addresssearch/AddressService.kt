package com.ctt.cep_addresssearch

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressService {

    @GET("{searchState}/{searchCity}/{searchStreet}/json/")

    fun fetchAddress(
        @Path("searchState") state: String,
        @Path("searchStreet") street: String,
        @Path("searchCity") city: String
    ) : Call<List<Address>>

//    @GET("{searchFullAddress}/json/")
//    fun fetchAddress(
//        @Path("searchFullAddress") fullAddress: String
//    ) : Call<List<Address>>

}