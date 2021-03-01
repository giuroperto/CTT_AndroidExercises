package com.ctt.moodyme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoodActivity : AppCompatActivity() {

    private lateinit var txtHappy: TextView
    private lateinit var txtAngry: TextView
    private lateinit var txtDisgusted: TextView
    private lateinit var txtSad: TextView
    private lateinit var txtFearful: TextView
    private lateinit var txtMeh: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood)

        txtHappy = findViewById(R.id.txtJoy)
        txtAngry = findViewById(R.id.txtAnger)
        txtDisgusted = findViewById(R.id.txtDisgust)
        txtSad = findViewById(R.id.txtSadness)
        txtFearful = findViewById(R.id.txtFear)
        txtMeh = findViewById(R.id.txtMeh)

        txtHappy.setOnClickListener{

        }

        txtAngry.setOnClickListener{

        }

        txtDisgusted.setOnClickListener{

        }

        txtSad.setOnClickListener{

        }

        txtFearful.setOnClickListener{

        }

        txtMeh.setOnClickListener{

        }
    }



}