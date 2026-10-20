package com.example.app_idade_retangulo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Define o tempo de espera da Splash (ex: 3000 milissegundos = 3 segundos)
        val tempoDeEspera = 5000L

        Handler(Looper.getMainLooper()).postDelayed({
            // Cria a intenção de ir da SplashActivity para a LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            // Finaliza a Splash para que o usuário não volte para ela ao apertar o botão "Voltar"
            finish()
        }, tempoDeEspera)
    }
}