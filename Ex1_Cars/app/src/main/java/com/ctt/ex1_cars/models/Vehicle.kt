package com.ctt.ex1_cars.models

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

abstract class Vehicle(var picture: Uri? = null, var owner: String, var brand: String, var model: String, var colour: String, var year: Int, var licencePlate: String, var price: Double) {
    abstract var type: String
}

@Parcelize
class Car(var carPicture: Uri?,
          var carOwner: String,
          var carBrand: String,
          var carModel: String,
          var carColour: String,
          var carYear: Int,
          var carLicensePlate: String,
          var carPrice: Double
          ) : Vehicle(picture = carPicture, owner = carOwner, brand = carBrand, model = carModel, colour =  carColour, year = carYear, licencePlate = carLicensePlate, price = carPrice), Parcelable {
    override var type: String = "Car"
}
