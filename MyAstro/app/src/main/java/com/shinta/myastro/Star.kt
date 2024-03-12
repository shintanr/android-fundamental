package com.shinta.myastro

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Star(
    val name: String,
    val description: String,
    val photo:Int
) : Parcelable
