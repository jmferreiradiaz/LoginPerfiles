package com.example.loginperfiles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.loginperfiles.room.LoginPerfilesApp
import com.example.loginperfiles.room.PerfilEntity
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    lateinit var perfil : PerfilEntity
    lateinit var tvUsuario: TextView
    lateinit var tvPassword : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        tvUsuario = findViewById<TextView>(R.id.tvUsuario)
        tvPassword = findViewById<TextView>(R.id.tvPassword)
        val tvError = findViewById<TextView>(R.id.tvError)

        btnRegister.setOnClickListener{
            val intent = Intent(applicationContext, Register::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener{
            getPerfilByUsuario()
            if (perfil.contrasena == tvPassword.text.toString()){
                val intent = Intent(applicationContext, Register::class.java)
                startActivity(intent)
            } else {
                tvError.text = "La contraseña no es correcta"
            }
        }


    }

    fun getPerfilByUsuario()= runBlocking {
        launch {
            perfil = LoginPerfilesApp.database.perfilDao().getPerfilByUsuario(tvUsuario.text.toString())
        }
    }
}