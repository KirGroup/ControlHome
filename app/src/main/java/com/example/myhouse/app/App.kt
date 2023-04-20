package com.example.myhouse.app

import android.app.Application
import com.example.myhouse.R
import io.realm.Realm
import io.realm.RealmConfiguration

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initRealm()
    }

    private fun initRealm() {
        Realm.init(this)
        val realmName: String = getString(R.string.myHouseDB)
        val config = RealmConfiguration.Builder()
            .name(realmName)
            .build()
        Realm.setDefaultConfiguration(config)
    }
}