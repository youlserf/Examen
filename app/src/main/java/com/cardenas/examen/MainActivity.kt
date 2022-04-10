package com.cardenas.examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_main.*


const val PARAMETER_EXTRA_NAME = "name"
const val PARAMETER_EXTRA_GMAIL = "gmail"
const val PARAMETER_EXTRA_OFFICE = "office"
const val PARAMETER_EXTRA_PHONE = "phone"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val extras = this.intent.extras

        if (extras != null) {
            if (extras.get(PARAMETER_EXTRA_NAME) != null) {
                valor_nombre.text = extras.getString(PARAMETER_EXTRA_NAME)
            }

            if (extras.get(PARAMETER_EXTRA_GMAIL) != null) {
                valor_correo.text = extras.getString(PARAMETER_EXTRA_GMAIL)
            }

            if (extras.get(PARAMETER_EXTRA_OFFICE) != null) {
                valor_oficina.text = extras.getString(PARAMETER_EXTRA_OFFICE)
            }
            if (extras.get(PARAMETER_EXTRA_PHONE) != null) {
                valor_telefono.text = extras.getString(PARAMETER_EXTRA_PHONE)
            }
        }
    }
    fun editar_datos(view: View) {

        var name = valor_nombre.text.toString()
        val gmail = valor_correo.text.toString()
        val office = valor_oficina.text.toString()
        val phone = valor_telefono.text.toString()
        goEditActivity(name, gmail, office, phone)
    }
    fun goEditActivity(name: String, gmail: String, office: String, phone: String) {
        val intent = Intent(this, EditActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("gmail", gmail)
        intent.putExtra("office", office)
        intent.putExtra("phone", phone)
        startActivity(intent)
    }

    fun call(view: View) {}
}
