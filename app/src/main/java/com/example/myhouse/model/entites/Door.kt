package com.example.myhouse.model.entites

data class Door(
    val name: String,
    val room: String? = null,
    val id: Long,
    val favorites: Boolean,
    val snapshot: String? = null
)

fun getDoors() = listOf(
    Door("Door1", "Earth", 1, true, "2"),
    Door("Door2", "Earth", 1, true, "2"),
    Door("Door3", "Earth", 1, true, "2"),
    Door("Door4", "Earth", 1, true, "2"),
)
