package com.example.loginperfiles.room

import android.app.Application
import androidx.room.Room

class LoginPerfilesApp: Application() {
    companion object {
        lateinit var database: PerfilDatabase
    }
    override fun onCreate() {
        super.onCreate()
        LoginPerfilesApp.database =  Room.databaseBuilder(this, PerfilDatabase::class.java, "perfiles-db").build()
    }

}