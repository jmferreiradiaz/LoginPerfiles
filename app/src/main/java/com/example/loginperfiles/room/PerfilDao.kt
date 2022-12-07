package com.example.loginperfiles.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PerfilDao {
    @Query("SELECT * FROM perfiles WHERE usuario LIKE :usuario")
    suspend fun getPerfilByUsuario(usuario:String): PerfilEntity

    @Insert
    suspend fun addPerfil(perfilEntity : PerfilEntity):Long

    @Update
    suspend fun updatePerfil(perfil: PerfilEntity)

    @Query("DELETE FROM perfiles")
    suspend fun deletePerfil()
}