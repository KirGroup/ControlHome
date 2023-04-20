package com.example.myhouse.model.realm

import android.os.Parcelable
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import kotlinx.android.parcel.Parcelize

@Parcelize
open class DoorRealm(
    @Required
    var name: String? = "",
    var room: String? = null,
    @PrimaryKey
    var id: Long? = 0,
    var favorites: Boolean? = true,
    var snapshot: String? = null
) : RealmObject(), Parcelable

open class DoorsDataRealm(
    var data: RealmList<DoorRealm>? = null
) : RealmObject()