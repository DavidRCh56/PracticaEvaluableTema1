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

        val enlace = "https://pudding.cool/2021/04/music-bubble/?_hsenc=p2ANqtz-9alhO5RmWjhUJm7GydzzEAshTE-eoCfYfRYFVsI_MfKO5oHU0_nR-6syloGKaGIL4sUiNDkzaAEm25fs7JiL-I9-DLIw&_hsmi=132279266&utm_campaign=ideou-campaign-newsletter-2020-09-01&utm_content=132279264&utm_medium=email&utm_source=hs_email"
        val btnLlamada = findViewById<Button>(R.id.btnLlamada)
        val btnUrl = findViewById<Button>(R.id.btnUrl)
        val btnAlarma = findViewById<Button>(R.id.btnAlarma)
        val btnPersonalizado = findViewById<Button>(R.id.btnPersonalizado)

        btnLlamada.setOnClickListener {
            startActivity(Intent(this, LlamadaActivity::class.java))
        }

        btnUrl.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(enlace))
            startActivity(intent)
        }

        btnAlarma.setOnClickListener {
            val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "Mi Alarma")
                putExtra(AlarmClock.EXTRA_HOUR, 0)
                putExtra(AlarmClock.EXTRA_MINUTES, 2)
            }

            // Verifica si hay alguna aplicación que pueda manejar la intención
            if (intent.resolveActivity(packageManager) != null) {
                try {
                    startActivity(intent)
                } catch (e: Exception) {
                    // Manejo de excepciones si algo sale mal
                    Toast.makeText(this, "Error al abrir la aplicación de alarmas", Toast.LENGTH_SHORT).show()
                    e.printStackTrace() // Esto te ayudará a depurar el error
                }
            } else {
                // Manejar el caso en que no hay aplicaciones de alarma
                Toast.makeText(this, "No hay aplicaciones de alarma disponibles", Toast.LENGTH_SHORT).show()
            }
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
