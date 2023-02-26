package com.example.practico1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.round

class SalarioNeto : AppCompatActivity() {

    private fun calcularSalarioNeto(){
        val nombre = findViewById<EditText>(R.id.txt_nombre).text
        val salarioBase = findViewById<EditText>(R.id.txt_salario).text.toString().toDouble()

        // Si el salario no es válido, no calcular nada
        if(salarioBase <=0){
            Toast.makeText(this,"Debe de ser un salario válido",Toast.LENGTH_LONG).show()
            return
        }

        // Calculando los descuentos

        val descuentoIsss = salarioBase * 0.03
        val descuentoAfp = salarioBase * 0.04
        val descuentoRenta = salarioBase * 0.05

        // Calculando el salario neto
        val salarioNeto = salarioBase - descuentoIsss - descuentoAfp - descuentoRenta
        findViewById<TextView>(R.id.lbl_neto).text =
            "Empleado: $nombre\n" +
            "Salario: $salarioBase\n" +
            "Descuentos:\n" +
                "\tISSS: ${round(descuentoIsss*100)/100}\n" +
                "\tAFP: ${round(descuentoAfp*100)/100}\n" +
                "\tRenta: ${round(descuentoRenta*100)/100}\n" +
            "Salario neto: ${round(salarioNeto*100)/100}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salario_neto)
        findViewById<Button>(R.id.btn_calcular).setOnClickListener{calcularSalarioNeto()}
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ejercicios,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id){
            R.id.ejercicio1 -> {
                val intent = Intent(this, Promedio::class.java,)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
            R.id.ejercicio2 -> {
                val intent = Intent(this,SalarioNeto::class.java)
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