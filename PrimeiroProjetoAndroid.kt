package br.unipar.projetoteste

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val resultado = findViewById<TextView>(R.id.txtResultado)

        val inputIdade = findViewById<EditText>(R.id.edIdade)

        val botaoValidar = findViewById<Button>(R.id.btnIdade)

        botaoValidar.setOnClickListener {

            //Pega o valor do input da tela
            val idadeInformada = inputIdade.text.toString();

            if(idadeInformada.isNotEmpty()){

                val idadeInt = idadeInformada.toInt();

                if(idadeInt >= 18){
                    resultado.setText("Você é maior de idade");
                }else{
                    resultado.setText("Você é menor de idade");
            }

        }else{
            resultado.setText("Informe uma idade")
        }

    }
 }

    fun limparValores(view: View){
        val resultado = findViewById<TextView>(R.id.txtResultado)
        val input= findViewById<EditText>(R.id.edIdade)

        resultado.setText("")
        input.setText("")
    }
}








<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="409dp"
        android:layout_height="354dp"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp">

        <TextView
            android:id="@+id/txtPergunta"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Qual sua idade?" />

        <EditText
            android:id="@+id/edIdade"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="number" />

        <Button
            android:id="@+id/btnIdade"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Verificar" />

        <TextView
            android:id="@+id/txtResultado"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

        <Button
            android:id="@+id/btnLimpar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Limpar"
            android:onClick="limparValores"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent" />
    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>


