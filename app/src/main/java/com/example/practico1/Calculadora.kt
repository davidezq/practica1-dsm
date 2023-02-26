package com.example.practico1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import java.nio.DoubleBuffer

class Calculadora : AppCompatActivity() {
    private fun calcularResultado(){
        val num1 = findViewById<EditText>(R.id.txt_numero1).text.toString().toDouble()
        val num2 = findViewById<EditText>(R.id.txt_numero2).text.toString().toDouble()
        val operacion = findViewById<Spinner>(R.id.spinnerOperaciones).selectedItemId.toInt()
        val lbl_resultado = findViewById<TextView>(R.id.lbl_resultado)
        var resultado:Double = 0.0

        when(operacion){
            0 -> {
                resultado = num1 + num2
            }
            1 -> {
                resultado = num1 - num2
            }
            2 -> {
                resultado = num1 * num2
            }
            3 -> {
                if(num2.toInt() == 0){
                    lbl_resultado.text = "No se puede dividir entre 0"
                    return
                }
                resultado = num1 / num2
            }
        }

        lbl_resultado.text = "Resultado: $resultado"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val operacionesMatematicas = findViewById<Spinner>(R.id.spinnerOperaciones)

        // generando un adapter para cargar las operaciones matemáticas en el spinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.operaciones_basicas,
            android.R.layout.simple_spinner_item
        )

        operacionesMatematicas.adapter = adapter

        findViewById<Button>(R.id.btn_calcular)
            .setOnClickListener{calcularResultado()}
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ejercicios, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.ejercicio1 -> {
                val intent = Intent(this, Promedio::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
            R.id.ejercicio2 -> {
                val intent = Intent(this, SalarioNeto::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
            R.id.ejercicio3 -> {
                val intent = Intent(this, Calculadora::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}