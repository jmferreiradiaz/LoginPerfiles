package com.example.loginperfiles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.loginperfiles.room.LoginPerfilesApp
import com.example.loginperfiles.room.PerfilEntity
import kotlinx.coroutines.runBlocking

class Register : AppCompatActivity() {

    lateinit var perfil : PerfilEntity
    lateinit var tvUsuario: TextView
    lateinit var tvPassword : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        tvUsuario = findViewById<TextView>(R.id.tvUsuario)
        tvPassword = findViewById<TextView>(R.id.tvPassword)

        btnRegister.setOnClickListener{
            addPerfil(
                PerfilEntity(
                    usuario = tvUsuario.text.toString(),
                    contrasena = tvPassword.text.toString()
            ))
            val intent = Intent(applicationContext, Register::class.java)
            startActivity(intent)
        }
    }

    fun addPerfil(perfil: PerfilEntity)= runBlocking {
        val id = LoginPerfilesApp.database.perfilDao().addPerfil(perfil)
    }

}