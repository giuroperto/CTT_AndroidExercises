package com.ctt.ex1_cars

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.ctt.ex1_cars.models.Car

class MainActivity : AppCompatActivity() {

    private lateinit var btnSave : Button
    private lateinit var carOwner : EditText
    private lateinit var carBrand : Spinner
    private lateinit var carModel : EditText
    private lateinit var carColour : EditText
    private lateinit var carYear : EditText
    private lateinit var carLicensePlate : EditText
    private lateinit var carPrice : EditText
    private lateinit var carPicture : ImageView

    private var pic: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave = findViewById(R.id.btnSave)
        carOwner = findViewById(R.id.edtOwner)
        carBrand = findViewById(R.id.spnCarBrand)
        carModel = findViewById(R.id.edtModel)
        carColour = findViewById(R.id.edtColour)
        carYear = findViewById(R.id.edtYear)
        carLicensePlate = findViewById(R.id.edtLPlate)
        carPrice = findViewById(R.id.edtPrice)
        carPicture = findViewById(R.id.imgCar)

        btnSave.setOnClickListener{
            val inputOwner = carOwner.text.toString()
            val inputBrand = carBrand.selectedItem.toString()
            val inputModel = carModel.text.toString()
            val inputColour = carColour.text.toString()
            val inputYear = carYear.text.toString()
            val inputLicensePlate = carLicensePlate.text.toString()
            val inputPrice = carPrice.text.toString()

            if (inputOwner.isEmpty()) {
                carOwner.error = "Please, inform the car's owner"
            }

            if (inputBrand == "Car Brand") {
                val carBrandError = carBrand.selectedView as TextView
//                carBrand.selectedView.error = "Please, inform the car's brand"
            }

            if (inputModel.isEmpty()) {
                carModel.error = "Please, inform the car's model"
            }

            if (inputColour.isEmpty()) {
                carColour.error = "Please, inform the car's colour"
            }

            if (inputYear.isEmpty()) {
                carYear.error = "Please, inform the car's year"
            }

            if (inputLicensePlate.isEmpty()) {
                carLicensePlate.error = "Please, inform the car's year"
            }

            if (inputPrice.isEmpty()) {
                carPrice.error = "Please, inform the car's price"
            }

            if (inputOwner.isNotEmpty() &&
                inputBrand.isNotEmpty() &&
                inputModel.isNotEmpty() &&
                inputColour.isNotEmpty() &&
                inputYear.isNotEmpty() &&
                inputLicensePlate.isNotEmpty() &&
                    inputPrice.isNotEmpty()) {
                val car = Car(carBrand = inputBrand,
                    carOwner = inputOwner,
                    carModel = inputModel,
                    carColour = inputColour,
                    carYear = inputYear.toInt(),
                    carLicensePlate = inputLicensePlate,
                    carPrice = inputPrice.toDouble())
                showCar(car)
            }
        }
    }

    fun showCar(car: Car) {
        Toast.makeText(this, "Car info submitted!", Toast.LENGTH_SHORT).show()

        redirect(car)
    }

    fun redirect(car: Car) {
        val carKey ="CAR"

        val targetActivity = Intent(this, CarActivity::class.java)
        targetActivity.putExtra(carKey, car)

        startActivity(targetActivity)
    }

}

// colocar imagem de outro lugar, sem ser tirar foto