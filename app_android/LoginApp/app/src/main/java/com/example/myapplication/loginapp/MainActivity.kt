package com.example.myapplication.loginapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailInput = findViewById<EditText>(R.id.editEmail)
        val senhaInput = findViewById<EditText>(R.id.editSenha)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val email = emailInput.text.toString()
            val senha = senhaInput.text.toString()

            // Chamada em outra thread (para não travar a tela)
            thread {
                val resposta = HttpHelper.login(email, senha)

                runOnUiThread {
                    Toast.makeText(this, resposta, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}