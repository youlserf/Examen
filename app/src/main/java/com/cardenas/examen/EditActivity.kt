package com.cardenas.examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_main.*

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val extras = this.intent.extras

        if (extras != null) {
            if (extras.get(PARAMETER_EXTRA_NAME) != null) {
                nombre_valor.setText(extras.getString(PARAMETER_EXTRA_NAME))
            }

            if (extras.get(PARAMETER_EXTRA_GMAIL) != null) {
                correo_valor.setText(extras.getString(PARAMETER_EXTRA_GMAIL))
            }

            if (extras.get(PARAMETER_EXTRA_OFFICE) != null) {
                oficina_valor.setText(extras.getString(PARAMETER_EXTRA_OFFICE))
            }

            if (extras.get(PARAMETER_EXTRA_PHONE) != null) {
                telefono_valor.setText(extras.getString(PARAMETER_EXTRA_PHONE))
            }
        }

    }

    fun guardar_datos(view: View) {
        val nombre = findViewById<TextView>(R.id.nombre_valor)
        val name = nombre.text.toString()
        val correo = findViewById<TextView>(R.id.correo_valor)
        val gmail = correo.text.toString()
        val oficina = findViewById<TextView>(R.id.oficina_valor)
        val office = oficina.text.toString()
        val telefono = findViewById<TextView>(R.id.telefono_valor)
        val phone = telefono.text.toString()
        goMainActivity(name, gmail, office, phone)
    }
    fun goMainActivity(name: String, gmail: String, office: String, phone: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("gmail", gmail)
        intent.putExtra("office", office)
        intent.putExtra("phone", phone)
        Toast.makeText(this, "GUARDADO", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }
}