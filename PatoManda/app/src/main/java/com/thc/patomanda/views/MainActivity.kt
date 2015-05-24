package com.thc.patomanda.views

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.view.Menu
import android.view.View
import com.thc.patomanda.R
import com.thc.patomanda.models.Card
import com.thc.patomanda.repositories.CardRepository
import kotlinx.android.synthetic.activity_main.*

public class MainActivity : ActionBarActivity() {
    val cardRepository = CardRepository()
    val backFaceCard = Card("", "De vuelta la carta", Color.RED)
    var isBackFace = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }

    fun turnCard(_ : View){
        if (isBackFace)
            this.goFront()
        else
            this.goBack()
    }

    private fun goBack() {
        this.setCard(backFaceCard)
        isBackFace = true
    }

    private fun goFront() {
        this.setCard(cardRepository.random())
        isBackFace = false
    }

    private fun setCard(card: Card) {
        this.cardTittle.setText(card.tittle)
        this.cardDescription.setText(card.description)
        this.cardTittle.setBackgroundColor(card.background)
    }
}