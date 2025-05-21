package com.example.ryeclerviewexchangerate.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Hero(
    val country: String,
    val buy: Double,
    val sell: Double,
    val flag: Int

): Parcelable
