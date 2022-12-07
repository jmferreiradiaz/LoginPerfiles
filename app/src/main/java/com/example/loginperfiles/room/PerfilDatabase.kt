package com.example.loginperfiles.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(PerfilEntity::class), version = 1)
abstract class PerfilDatabase: RoomDatabase() {
    abstract fun perfilDao(): PerfilDao
}