package com.example.myhouse.model.realm

import com.example.myhouse.model.rest.rest_entites.DoorDTO
import io.realm.Realm
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.Dispatchers

object RealmManager {

    private val backgroundThreadRealm : Realm = Realm.getInstance(Realm.getDefaultConfiguration())

    suspend fun insertDoor(door: DoorDTO) {
        backgroundThreadRealm.executeTransactionAwait(Dispatchers.IO) { realmTransaction ->
            val newDoor = DoorRealm(
                name = door.name,
                room = door.room,
                id = door.id,
                favorites = door.favorites,
                snapshot = door.snapshot,
            )
            realmTransaction.copyToRealm(newDoor)
        }
        backgroundThreadRealm.close()
    }

    suspend fun retrieveDoors(): List<DoorRealm> {
        val doors = mutableListOf<DoorRealm>()
        backgroundThreadRealm.executeTransactionAwait(Dispatchers.IO) { realmTransaction ->
            doors.addAll(realmTransaction
                .where(DoorRealm::class.java)
                .findAll())
        }
        backgroundThreadRealm.close()
        return doors
    }
}