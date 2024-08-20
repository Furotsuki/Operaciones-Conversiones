package com.example.conjuto_apps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val num1: EditText = findViewById(R.id.ednum1);
        val select: RadioGroup = findViewById(R.id.roper);
        val btncalular: Button = findViewById(R.id.btncal);
        val result: TextView = findViewById(R.id.txtresult);
        val seguir: Button = findViewById(R.id.sigue);
        btncalular.setOnClickListener{
            val n1 = num1.text.toString().toIntOrNull()
            val selectOperationId = select.checkedRadioButtonId
            if ( n1 == null){
                Toast.makeText(this,"Digite el Número",Toast.LENGTH_SHORT).show();
            }else{
                val binario = decimalBinario(n1)
                val octal = decimalOctal(n1)
                val hexa = decimalHexa(n1)
                val res = when (selectOperationId) {
                    R.id.rbin -> binario;
                    R.id.roct -> octal;
                    R.id.rhex -> hexa;

                    else -> null
                }
                result.text = if(res != null) "\n$res" else "Resultado: Error"
            }

        }
        //Funcion de oneclick para pasar a una siguiente pagina
        seguir.setOnClickListener{
            val siguiente = Intent(this,SaberTriangulo::class.java)
            startActivity(siguiente)
        }
    }
    //Funcion para hacer conversion de decimal a binario
    private fun decimalBinario(numero:Int):String {
        var numero = numero
        var binario = ""

        if (numero == 0) {
            return "0"
        }

        while (numero > 0) {
            val residuo = numero % 2
            binario = residuo.toString() + binario
            numero /= 2
        }

        return binario
    }
    //Funcion para hacer conversion de decimal a octal
    private fun decimalOctal(numero: Int):String{
        var numero = numero
        var octal = ""

        if (numero == 0) {
            return "0"
        }

        while (numero > 0) {
            val residuo = numero % 8
            octal = residuo.toString() + octal
            numero /= 8
        }

        return octal
    }
    //Funcion para hacer conversion de decimal a Hexadecimal
    private fun decimalHexa(numero: Int):String{
        var numero = numero
        var hexa = ""
        val hexDigits = "0123456789ABCDEF"

        if (numero == 0) {
            return "0"
        }

        while (numero > 0) {
            val residuo = numero % 16
            hexa = hexDigits[residuo] + hexa
            numero /= 16
        }

        return hexa
    }
}