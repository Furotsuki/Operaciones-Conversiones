package com.example.conjuto_apps

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SaberTriangulo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val lado1 : EditText = findViewById(R.id.lado1);
        val lado2 : EditText = findViewById(R.id.lado2);
        val lado3 : EditText = findViewById(R.id.lado3);
        val resultado : TextView = findViewById(R.id.result_tria);
        val calcular : Button = findViewById(R.id.calc);

        calcular.setOnClickListener{
            var l1 = lado1.text.toString().toIntOrNull()
            var l2 = lado2.text.toString().toIntOrNull()
            var l3 = lado3.text.toString().toIntOrNull()
            var res = ""
            if ( l1 == null || l2 == null || l3 == null){
                Toast.makeText(this,"Digite todos los Lados",Toast.LENGTH_SHORT).show();
            }else{
                if(l1 == l2 && l2 == l3) {res = "Equilátero"}
                else if(l1 == l2 || l1 == l3 || l2 == l3) {res = "Isósceles"}
                else{res = "Escaleno"}
            }
            resultado.text = if(res != null) "$res" else "Resultado: Error"
        }
    }
}