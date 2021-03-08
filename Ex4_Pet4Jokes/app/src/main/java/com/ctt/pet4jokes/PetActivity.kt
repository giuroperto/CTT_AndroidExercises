package com.ctt.pet4jokes

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ctt.pet4jokes.databinding.ActivityPetBinding
import com.ctt.pet4jokes.model.DogPicture
import com.ctt.pet4jokes.model.Joke
import com.ctt.pet4jokes.model.Pet
import com.ctt.pet4jokes.services.DogPicturesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PetActivity : AppCompatActivity() {

    private lateinit var imgDog : ImageView
    private lateinit var txtDesc : TextView
    private lateinit var binding : ActivityPetBinding
    private lateinit var dog : Pet
    private lateinit var dogImg : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPetBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        dog = intent.extras?.get("DOG") as Pet
        dogImg = intent.extras?.get("DOGIMG") as String

        imgDog = findViewById(R.id.imgDog)
        txtDesc = findViewById(R.id.txtPetDesc)

        txtDesc.text ="Hi, I'm ${dog.name}! They say that when you are feeling down, you should play with a dog... it makes it a whole better. As I cannot run and chase a ball here, what we could do is: you pet me and as a reward, if I enjoy it, I will tell you a joke. What are you waiting for? Ain't I a good boy?"

        var count = 0
        var rand = (Math.random() * (11)).toInt()

        imgDog.setOnClickListener() {
            if (count == rand) {
                redirect(dog, dogImg)
            } else {
                count += 1
            }
        }
    }

    fun redirect(dog: Pet, dogPicture: String) {

        val dogKey = "DOG"
        val dogImgKey = "DOGIMG"

        val targetActivity = Intent(this, JokeActivity::class.java)
        targetActivity.putExtra(dogKey, dog)
        targetActivity.putExtra(dogImgKey, dogPicture)

        startActivity(targetActivity)
    }

//    fun getDogImage() {
//        val retrofitClient = Network.RetrofitConfig("https://dog.ceo/api/")
//        val service = retrofitClient.create(DogPicturesService::class.java)
//        val call = service.getDogPicture()
//
//        call.enqueue(
//            object : Callback<DogPicture> {
//                override fun onResponse(call: Call<DogPicture>, response: Response<DogPicture>) {
//                    val dogImgResponse = response.body()?.pictureURL
//
//                    dogImg = dogImgResponse ?: "https://images.dog.ceo/breeds/akita/An_Akita_Inu_resting.jpg"
//
//                    dogImgResponse?.let{
//                        if (it.isNotEmpty()) {
//                            Glide.with(parent)
//                                .load(it)
//                                .centerCrop()
//                                .into(imgDog)
//                        } else {
//                            imgDog.setImageResource(R.mipmap.ic_main_dog2)
//                        }
//                    }
//                }
//
//                override fun onFailure(call: Call<DogPicture>, t: Throwable) {
//                    imgDog.setImageResource(R.mipmap.ic_main_dog2)
//                }
//
//            }
//        )
//    }
}
