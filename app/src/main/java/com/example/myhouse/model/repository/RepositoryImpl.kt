package com.example.myhouse.model.repository

import com.example.myhouse.model.entites.Camera
import com.example.myhouse.model.entites.Door
import com.example.myhouse.model.entites.getCameras
import com.example.myhouse.model.entites.getDoors
import com.example.myhouse.model.realm.RealmManager
import com.example.myhouse.model.rest.RemoteDataSource
import com.example.myhouse.model.rest.rest_entites.CameraDTO
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import io.realm.Realm

class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val realmManager: RealmManager
) : Repository {

    val backgroundThreadRealm: Realm = Realm.getInstance(Realm.getDefaultConfiguration())

    override fun getCamerasFromLocalStorage(): List<Camera> = getCameras()
    override suspend fun getDoorsFromLocalStorage(): List<Door> = getDoors()

    override fun getDoorsFromServer(): List<DoorDTO> {
        val dto = remoteDataSource.api.getDoorsSource().execute().body()
        return dto?.data!!
    }

    override fun getCamerasFromServer(): List<CameraDTO> {
        val dto = remoteDataSource.api.getCamerasSource().execute().body()
        return dto?.data?.cameras!!
    }
}