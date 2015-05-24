package com.thc.patomanda.repositories

import android.graphics.Color
import com.thc.patomanda.models.Card
import java.util.HashSet
import java.util.Random

/**
 * Created by Palumbo on 23/05/2015.
 */

public class CardRepository {
    var cards = HashSet<Card>()
    init {
        this.add(Card("Toma 1", "Elija a alguien para que toma un trago.", Color.WHITE))
        this.add(Card("Toma 2", "Elija a alguien para que toma dos tragos.", Color.WHITE))
        this.add(Card("Toma 3", "Elija a alguien para que toma tres tragos.", Color.WHITE))
        this.add(Card("Un barquito lleno de..", "Elija un topic y comience la ronda de palabras referidas a lo elegido. Aquel que no responda en 5 segundos o repita alguna ya dicha toma un trago. Ejemplos: marcas de autos, razas de perros, etc.", Color.WHITE))
        this.add(Card("Aplausos", "Deberá dar un aplauso, luego seleccionar a alguna persona y decir el nombre de otra; la persona que nombre deberá repetir la acción. El juego continúa hasta que alguien nombre a la misma persona que señala o aplauda cuando no corresponda, entonces deberá tomar dos tragos.", Color.WHITE))
        this.add(Card("PATO", "'Un pato, dos patas, PUM, agua' \n 'Dos patos, cuatro patas, PUM, PUM, agua, agua'", Color.WHITE))
        this.add(Card("Esclavo", "Seleccione a alguien para que sea su esclavo, esto significa que siempre que usted tome sus esclavos deberán tomar la misma cantidad.", Color.WHITE))
        this.add(Card("CASCADA", "Todos toman en ronda al mismo tiempo. Nadie puede parar hasta que no pare de tomar la persona de su izquierda.", Color.WHITE))
        this.add(Card("REY MANDA", "Sos el REY, decide lo que quieras.", Color.WHITE))
    }

    fun random() : Card {
        var index = Random().nextInt(cards.size())
        return cards.elementAt(index)
    }

    fun add(card: Card) {
        cards.add(card)
    }
}