package com.example.practico1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Promedio : AppCompatActivity() {

    private fun calcularPromedio(){
        val nombreEstudiante = findViewById<EditText>(R.id.txt_estudiante).text
        var notas = DoubleArray(5)
        for(i in 0..notas.size-1){
            notas[i] = findViewById<EditText>(resources.getIdentifier("txt_nota${i+1}","id",packageName)).text.toString().toDouble()
            if(notas[i] > 10){
                Toast.makeText(this,"Revise las notas si son correctas",Toast.LENGTH_LONG).show()
                return
            }
        }
        var promedio = notas.sum() / notas.size
        findViewById<TextView>(R.id.lbl_promedio).text = "Estudiante: $nombreEstudiante\nPromedio: $promedio\n${if (promedio >= 6) "Aprobado 🎉" else "Reprobado 😔"}"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promedio)
        findViewById<Button>(R.id.btn_calcular).setOnClickListener{calcularPromedio()}
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ejercicios,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id == R.id.ejercicio1){
            val intent = Intent(this, Promedio::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}