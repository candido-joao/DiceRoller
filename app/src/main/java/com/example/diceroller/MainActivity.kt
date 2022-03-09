package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * Esta activity permite ao usuário rolar um dado e visualizar o resultado
 * na tela.
 */
class MainActivity : AppCompatActivity() {

    /**
     * Este método é chamado quando a Activity é criada.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //
        //Encontra o botão no layout
        val rollButton: Button = findViewById(R.id.button)

        // Define um listener de clique no botão para rolar os dados quando o usuário tocar no botão
        rollButton.setOnClickListener { rollDice() }

        // Faz um lançamento de dados quando o aplicativo for iniciado
        rollDice()
    }

    /**
     * Joga os dados e atualize a tela com o resultado.
     */
    private fun rollDice() {
        // Cria um novo objeto Dice com 6 lados e role-o
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Encontra o ImageView no layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determina qual ID de recurso drawable usar com base na jogada de dados
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Atualiza o ImageView com o ID de recurso drawable correto
        diceImage.setImageResource(drawableResource)

        // Atualiza a descrição do conteúdo
        diceImage.contentDescription = diceRoll.toString()
    }
}

/**
 * Dado com um número fixo de lados
 */
class Dice(private val numSides: Int) {

    /**
     * Faz uma rolagem de dados aleatória e retorna o resultado.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}