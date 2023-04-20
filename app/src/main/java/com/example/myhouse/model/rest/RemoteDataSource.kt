package com.example.myhouse.model.rest

import API_BASE
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteDataSource {
    val api: MyHouseAPI by lazy {
        val adapter = Retrofit.Builder()
            .baseUrl(API_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        adapter.create(MyHouseAPI::class.java)
    }
}