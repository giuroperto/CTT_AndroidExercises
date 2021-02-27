package com.ctt.ex1_cars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ctt.ex1_cars.databinding.ActivityCarsBinding
import com.ctt.ex1_cars.models.Car

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

    }
}

//"%,d".format(input)

//import android.util.Log
//import android.widget.TextView
//import com.ctt.first_project_mobile.model.Usuario
//import kotlinx.android.synthetic.main.activity_main.*
//
//
//
//        Log.e("FOTO", usuario.foto.toString())
//
//        imgUsuario.setImageBitmap(usuario.foto)
//
////    evitar processamento desnecessario -> verificacao
//
//        if (usuario.foto != null) {
//            imgUsuario.setImageBitmap(usuario.foto)
//        } else {
//            imgUsuario.setImageResource(R.drawable.ic_eevee)
//        }
////        usuario.foto?.let{
////    //    it = tudo que eu falei antes do .let
////    //    imgUsuario.setImageBitmap(usuario.foto)
////            imgUsuario.setImageBitmap(it)
////        }
//    }
//}
