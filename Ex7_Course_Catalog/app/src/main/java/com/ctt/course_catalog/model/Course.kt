package com.ctt.course_catalog.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Course(var name: String, var desc: String) : Parcelable
