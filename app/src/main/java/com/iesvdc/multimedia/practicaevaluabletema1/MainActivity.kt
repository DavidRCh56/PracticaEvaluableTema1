package com.iesvdc.multimedia.practicaevaluabletema1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar botones
        findViewById<Button>(R.id.btnCall).setOnClickListener {
            val intent = Intent(this, CallActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnUrl).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ejemplo.com"))
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnAlarm).setOnClickListener {
            // Lógica para crear alarma
        }

        findViewById<Button>(R.id.btnOther).setOnClickListener {
            // Lógica para otra intención
        }
    }
}