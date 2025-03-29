package com.example.aplicativojoguempo

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

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
    }

    //unusedView - Significa que estou chamando o Parametro, mas não estou Usuando

    fun selecionadoPedra(unusedView:  View){
        opcaoSelecionada("Pedra")
    }

    fun selecionadoPapel(unusedView: View){
        opcaoSelecionada("Papel")
    }

    fun selecionadoTesoura(unusedView: View){
        opcaoSelecionada("Tesoura")
    }

    fun opcaoSelecionada (opcao:String){

        val imagemResultado: ImageView = findViewById(R.id.imageResult)
        val textResultado: TextView = findViewById(R.id.textResultado)
        var numero:Int = Random.nextInt(3)
        val opcoes: Array<String> = arrayOf("Pedra", "Papel", "Tesoura")
        val opcoesApp: String = opcoes[numero]

        when(opcoesApp){
            "Pedra"     -> imagemResultado.setImageResource(R.drawable.pedra)
            "Papel"     -> imagemResultado.setImageResource(R.drawable.papel)
            "Tesoura"   -> imagemResultado.setImageResource(R.drawable.tesoura)
        }

        // Definindo as opções de vitória
        // Se o App Ganhar do Usuário vai se Verdadeiro
        //Se o App Perder do Usuário vai ser Falso
        val vitoria: Boolean = when {
            (opcoesApp == "Tesoura" && opcao == "Papel") ||
                    (opcoesApp == "Papel" && opcao == "Pedra") ||
                    (opcoesApp == "Pedra" && opcao == "Tesoura") -> true
            else -> false
        }

        val empate: Boolean = opcoesApp == opcao

        // Exibindo o resultado
        when {
            vitoria -> textResultado.text =getString(R.string.perdeu)
            empate -> textResultado.text =getString(R.string.empate)
            else -> textResultado.text = getString(R.string.ganhou)
        }
    }

}