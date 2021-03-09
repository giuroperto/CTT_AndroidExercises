package com.ctt.followthebitcoins.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Coin(val acronym: String, val name: String) : Parcelable