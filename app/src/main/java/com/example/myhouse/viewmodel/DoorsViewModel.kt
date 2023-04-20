package com.example.myhouse.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myhouse.model.AppStateDoors
import com.example.myhouse.model.realm.RealmManager
import com.example.myhouse.model.repository.Repository
import com.example.myhouse.model.repository.RepositoryImpl
import com.example.myhouse.model.rest.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DoorsViewModel(
    private val liveDataObserverDoors: MutableLiveData<AppStateDoors> = MutableLiveData(),
    private val repository: Repository = RepositoryImpl(RemoteDataSource, RealmManager),
) : ViewModel(), LifecycleObserver {

    fun getLiveData() = liveDataObserverDoors

    fun getDoorsFromServer() {
        liveDataObserverDoors.postValue(AppStateDoors.Loading)
        GlobalScope.launch(Dispatchers.IO) {
            liveDataObserverDoors.postValue(AppStateDoors.Success(repository.getDoorsFromServer()))
        }
    }
}