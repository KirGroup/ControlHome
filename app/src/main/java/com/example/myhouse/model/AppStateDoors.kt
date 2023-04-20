package com.example.myhouse.model

import com.example.myhouse.model.rest.rest_entites.DoorDTO

sealed class AppStateDoors {
    data class Success(val doorsData: List<DoorDTO>) : AppStateDoors()
    data class Error(val error: Throwable) : AppStateDoors()
    object Loading : AppStateDoors()
}