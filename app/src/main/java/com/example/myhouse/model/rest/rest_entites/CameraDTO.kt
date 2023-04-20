package com.example.myhouse.model.rest.rest_entites

data class CamerasDataDTO(
    val data: Data
)

data class Data(
    val room: List<String>,
    val cameras: List<CameraDTO>
)

data class CameraDTO(
    val name: String,
    val snapshot: String,
    val room: String? = null,
    val id: Long,
    val favorites: Boolean,
    val rec: Boolean
)
