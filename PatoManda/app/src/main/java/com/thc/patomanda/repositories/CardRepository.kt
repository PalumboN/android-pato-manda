package com.thc.patomanda.repositories

import com.thc.patomanda.R
import com.thc.patomanda.models.Card
import java.util.HashSet
import java.util.Random

/**
 * Created by Palumbo on 23/05/2015.
 */

public class CardRepository {
    var cards = HashSet<Card>()
    init {
        this.add(newCard("TOMA 1", "Elija a alguien para que toma un trago."))
        this.add(newCard("TOMA 2", "Elija a alguien para que toma dos tragos."))
        this.add(newCard("TOMA 3", "Elija a alguien para que toma tres tragos."))
        this.add(newCard("SIN DERECHA", "Si agarra el vaso con la mano derecha tendrá que tomar el doble de tragos de los que debería.\nEsto es válido por las próximas 2 rondas."))
        this.add(newCard("SIN IZQUIERDA", "Si agarra el vaso con la mano izquierda tendrá que tomar el doble de tragos de los que debería.\nEsto es válido por las próximas 2 rondas."))
        this.add(newCard("EN UN PIE", "Deberá mantenerce en un pie por 10 segundos.\nSi no lo logra deberá tomar 3 tragos."))
        this.add(newCard("BARQUITO", "Elija algún topic y comience la ronda de cosas que pertenezcan a éste. Pierde aquel que no responda en 5 segundos o repita algo ya dicho y tomará 2 tragos.\nEjemplos: marcas de autos, razas de perros, animales del zoo, etc."))
        this.add(newCard("APLAUSOS", "Dar un aplauso, señalar a alguien y decir el nombre de otra persona. La persona nombrada deberá repetir la acción. Pierde aquel que nombre a la misma persona que señala o aplauda cuando no corresponda y deberá tomar dos tragos."))
        this.add(newCard("PATO", "En ronda, deben jugar a matar patos diciendo:\n'Un pato' -> 'Dos patas' -> 'PUM' -> 'Agua' -> 'Dos patos' -> 'Cuatro patas' -> 'PUM' -> 'PUM' -> 'Agua' -> 'Agua' -> 'Tres patos' -> 'Seis patas' -> 'PUM' -> 'PUM' -> 'PUM' -> 'Agua' -> 'Agua' -> 'Agua' ...\nPierde el que se equivoque y tomará 3 tragos."))
        this.add(newCard("ESCLAVO", "Seleccione a alguien para que sea su esclavo.\nSiempre que usted tome todos sus esclavos deberán tomar la misma cantidad."))
        this.add(newCard("CASCADA", "Todos toman en ronda al mismo tiempo.\nNadie puede parar hasta que no pare de tomar la persona de su izquierda."))
        this.add(newCard("REY MANDA", "¡Sos el REY, decide lo que quieras!"))
    }

    fun random() : Card {
        var index = Random().nextInt(cards.size())
        return cards.elementAt(index)
    }

    fun add(card: Card) {
        cards.add(card)
    }

    private fun newCard(tittle: String, description: String) : Card {
        return Card(tittle, description,  R.drawable.card_front)
    }
}