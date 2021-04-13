package com.ctt.cep_addresssearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var btnSearch: Button
//    private lateinit var txtResult: TextView
    private lateinit var rvAddress: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        txtResult = findViewById(R.id.txtResult)
        btnSearch = findViewById(R.id.btnSearch)
        rvAddress = findViewById(R.id.rvAddresses)

        rvAddress.layoutManager = LinearLayoutManager(this)

        val state = "RJ"
        val city = "rio de janeiro"
        val address = "atlantica"
        val fullAddress = "$state/$city/$address"

        btnSearch.setOnClickListener {
            val retrofitClient = RetrofitConfig("https://viacep.com.br/ws/")
            val service = retrofitClient.create(AddressService::class.java)
//            val call : Call<List<Address>> = service?.fetchAddress(fullAddress = fullAddress) as Call<List<Address>>
            val call : Call<List<Address>> = service?.fetchAddress(state = state, street = address, city = city) as Call<List<Address>>
            Log.d("TRACKER", "https://viacep.com.br/ws/$fullAddress/json/")

            call.enqueue(
                object : Callback<List<Address>> {
                    override fun onResponse(
                        call: Call<List<Address>>,
                        response: Response<List<Address>>
                    ) {
//                        Log.d("TRACKER", "inside response")
//                        Log.d("TRACKER", response.body().toString())
//                        Log.d("TRACKER", response.isSuccessful.toString())

                        if (response.isSuccessful && response.body() != null) {
//                            Log.d("TRACKER", "inside success")

                            response.body()?.let {
                                val adapter = AddressAdapter(it.toList())

                                rvAddress.adapter = adapter
//                                Log.d("API RESPONSE", it.toString())
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<Address>>, t: Throwable) {
                        Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                    }

                }
            )

        }
    }

    fun RetrofitConfig(path: String) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(path)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
