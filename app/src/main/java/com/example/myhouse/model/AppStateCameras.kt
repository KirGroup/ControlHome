package com.example.myhouse.model

import com.example.myhouse.model.rest.rest_entites.CameraDTO

sealed class AppStateCameras {
    data class Success(val camerasData: List<CameraDTO>) : AppStateCameras()
    data class Error(val error: Throwable) : AppStateCameras()
    object Loading : AppStateCameras()
}