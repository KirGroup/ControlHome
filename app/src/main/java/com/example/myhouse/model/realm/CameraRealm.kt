package com.example.myhouse.model.realm

import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

class CameraRealm(
    @Required
    var name: String? = "",
    var snapshot: String? = "",
    var room: String? = null,
    @PrimaryKey
    var id: Long? = 0,
    var favorites: Boolean? = true,
    var rec: Boolean? = true,
)