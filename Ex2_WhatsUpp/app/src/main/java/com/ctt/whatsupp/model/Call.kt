package com.ctt.whatsupp.model

import android.graphics.Bitmap

data class Call (var picture: Bitmap? = null, var name: String, var time: String, var incoming: Boolean)
