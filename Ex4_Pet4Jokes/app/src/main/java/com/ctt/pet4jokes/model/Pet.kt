package com.ctt.pet4jokes.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pet (val name: String, val picture: String) : Parcelable