package com.shinta.astroapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Star(
    val name: String,
    val description: String,
    val pict: Int
) : Parcelable
