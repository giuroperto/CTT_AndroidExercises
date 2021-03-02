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
import com.ctt.pet4jokes.model.Pet

class PetActivity : AppCompatActivity() {

    private lateinit var imgDog : ImageView
    private lateinit var txtDesc : TextView
    private lateinit var binding : ActivityPetBinding
    private lateinit var dog : Pet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPetBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        dog = intent.extras?.get("DOG") as Pet

        imgDog = findViewById(R.id.imgDog)
        txtDesc = findViewById(R.id.txtPetDesc)

        if (dog.picture != null) {
            Glide.with(this)
                .load(dog.picture)
                .centerCrop()
                .into(imgDog)
        } else {
            imgDog.setImageResource(R.mipmap.ic_main_dog2)
        }


        txtDesc.text ="Hi, I'm ${dog.name}! They say that when you are feeling down, you should play with a dog... it makes it a whole better. As I cannot run and chase a ball here, what we could do is: you pet me and as a reward, if I enjoy it, I will tell you a joke. What are you waiting for? Ain't I a good boy?"

        var count = 0
        var rand = (Math.random() * (11)).toInt()

        imgDog.setOnClickListener() {
            if (count == rand) {
                redirect(dog)
            } else {
                count += 1
            }
        }
    }


    fun redirect(dog: Pet) {

        val dogKey = "DOG"

        val targertActivity = Intent(this, JokeActivity::class.java)
        targertActivity.putExtra(dogKey, dog)

        startActivity(targertActivity)
    }
}

// TODO: 28/02/2021 integrate pet pictures with API
//https://thedogapi.com/