package com.example.loginperfiles.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Entity(tableName = "perfiles")
data class PerfilEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0,
    var usuario:String = "usuario",
    var contrasena:String = "password",
    //var foto: ByteArray? = null
)
