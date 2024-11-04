package com.iesvdc.multimedia.practicaevaluabletema1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.iesvdc.multimedia.practicaevaluabletema1.LlamadaActivity
import com.iesvdc.multimedia.practicaevaluabletema1.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val btnLlamada = findViewById<Button>(R.id.btnLlamada)
        val btnUrl = findViewById<Button>(R.id.btnUrl)
        val btnAlarma = findViewById<Button>(R.id.btnAlarma)
        val btnPersonalizado = findViewById<Button>(R.id.btnPersonalizado)

        btnLlamada.setOnClickListener {
            startActivity(Intent(this, LlamadaActivity::class.java))
        }

        btnUrl.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.miweb.com"))
            startActivity(intent)
        }

        btnAlarma.setOnClickListener {
            val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "Mi Alarma")
                putExtra(AlarmClock.EXTRA_HOUR, 0)
                putExtra(AlarmClock.EXTRA_MINUTES, 2)
            }
            startActivity(intent)
        }

        btnPersonalizado.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Texto de ejemplo")
            }
            startActivity(Intent.createChooser(intent, "Enviar texto"))
        }
    }
}
