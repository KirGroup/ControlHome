package com.example.myhouse.model.entites

data class Camera(
    val name: String,
    val snapshot: String,
    val room: String? = null,
    val id: Long,
    val favorites: Boolean,
    val rec: Boolean
)

fun getCameras() = listOf(
    Camera(
        "Camera 1",
        "https://serverspace.ru/wp-content/uploads/2019/06/backup-i-snapshot.png",
        "a",
        1,
        favorites = true,
        rec = false
    ),
    Camera("Camera 2", "Earth", "a", 1, favorites = false, rec = true),
    Camera(
        "Camera 3",
        "https://catherineasquithgallery.com/uploads/posts/2021-02/1612768484_140-p-fon-golubogo-morya-184.jpg",
        "a",
        1,
        favorites = true,
        rec = false
    ),
    Camera("Camera 4", "Earth", "a", 1, favorites = false, rec = true)
)
