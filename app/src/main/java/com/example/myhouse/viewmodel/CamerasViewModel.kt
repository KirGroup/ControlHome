package com.example.myhouse.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myhouse.model.AppStateCameras
import com.example.myhouse.model.realm.RealmManager
import com.example.myhouse.model.repository.Repository
import com.example.myhouse.model.repository.RepositoryImpl
import com.example.myhouse.model.rest.RemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CamerasViewModel(
    private val liveDataObserverCameras: MutableLiveData<AppStateCameras> = MutableLiveData(),
    private val repository: Repository = RepositoryImpl(RemoteDataSource, RealmManager)
) : ViewModel(), LifecycleObserver {

    fun getLiveData() = liveDataObserverCameras

    @OptIn(DelicateCoroutinesApi::class)
    fun getCamerasFromServer() {
        liveDataObserverCameras.value = AppStateCameras.Loading
        GlobalScope.launch(Dispatchers.IO) {
            liveDataObserverCameras
                .postValue(AppStateCameras.Success(repository.getCamerasFromServer()))
        }
    }
}