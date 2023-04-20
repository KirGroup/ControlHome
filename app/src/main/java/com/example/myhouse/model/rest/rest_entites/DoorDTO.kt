package com.example.myhouse.model.rest.rest_entites

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class DoorsDataDTO(
    val data: List<DoorDTO>
)

@Parcelize
data class DoorDTO(
    val name: String,
    val room: String? = null,
    val id: Long,
    val favorites: Boolean,
    val snapshot: String? = null
) : Parcelable