package com.cardenas.examen

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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

    fun call(view: View) {
        val phone = valor_telefono.text.toString()
        val call = Uri.parse("tel:"+phone)
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED){
        val i = Intent(Intent.ACTION_CALL, call)
        startActivity(i)
        }
        else{
            Toast.makeText(this, "No hay permiso para realizar llamada",
            Toast.LENGTH_LONG)
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CALL_PHONE),
                123
            )
        }

    }

    fun whats(view: View) {
        val message = valor_nombre.text.toString()
        sendMessage(message);
    }

    fun sendMessage(message:String){

        // Creating intent with action send
        val intent = Intent(Intent.ACTION_SEND)

        // Setting Intent type
        intent.type = "text/plain"

        // Setting whatsapp package name
        intent.setPackage("com.whatsapp")

        // Give your message here
        intent.putExtra(Intent.EXTRA_TEXT, message)

        // Checking whether whatsapp is installed or not
        if (intent.resolveActivity(packageManager) == null) {
            Toast.makeText(this,
                "Please install whatsapp first.",
                Toast.LENGTH_SHORT).show()
            return
        }

        // Starting Whatsapp
        startActivity(intent)
    }

    fun sms(view: View) {
        val message = valor_nombre.text.toString()
        val phone = valor_telefono.text.toString()
        val call = Uri.parse("tel:"+phone)

        val sendIntent = Intent(Intent.ACTION_VIEW)
        sendIntent.type = "vnd.android-dir/mms-sms"
        sendIntent.putExtra("address", call)
        sendIntent.putExtra("sms_body", message)
        startActivity(sendIntent)
    }
}
