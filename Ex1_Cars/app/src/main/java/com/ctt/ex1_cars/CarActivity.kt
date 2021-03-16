package com.ctt.ex1_cars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ctt.ex1_cars.databinding.ActivityCarsBinding
import com.ctt.ex1_cars.models.Car
import kotlinx.android.synthetic.main.activity_cars.*

class CarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCarsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val car = intent.extras?.get("CAR") as Car

        val priceAdjusted = java.text.NumberFormat.getIntegerInstance().format(car.carPrice)

        binding.txtCarDetails.text = "Owner: ${car.carOwner.capitalize()}, \nBrand: ${car.carBrand}, \nModel: ${car.carModel.capitalize()}, " +
                "\nColour: ${car.carColour.capitalize()}, \nYear: ${car.year}, \nLicense Plate: ${car.licencePlate.toUpperCase()}, \n\nR$ ${priceAdjusted}"

        if (car.carPicture != null) {
            binding.imgCar.setImageURI(car.carPicture)
        } else {
            binding.imgCar.setImageResource(R.drawable.ic_car)
        }

    }
}