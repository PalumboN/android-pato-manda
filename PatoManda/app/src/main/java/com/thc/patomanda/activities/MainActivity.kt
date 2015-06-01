package com.thc.patomanda.activities

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.telephony.TelephonyManager
import android.view.Menu
import android.view.View
import com.google.android.gms.ads.*
import com.thc.patomanda.R
import com.thc.patomanda.models.Card
import com.thc.patomanda.repositories.CardRepository
import kotlinx.android.synthetic.activity_main.*

public class MainActivity : ActionBarActivity() {
    val cardRepository = CardRepository()
    val backFaceCard = Card("", "", R.drawable.card_back)
    var isBackFace = true

    var gamesCount = 0
    var interstitialAd = InterstitialAd(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.loadInterstitial()
        this.goBack()
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
        gamesCount++
        this.loadAdIfShould()
    }

    private fun setCard(card: Card) {
        this.cardTittle.setText(card.tittle)
        this.cardDescription.setText(card.description)
        this.cardBackground.setBackgroundResource(card.background)
    }


    // AdMob
    private fun loadInterstitial() {
        // Configurar el intersticial.
        interstitialAd.setAdUnitId("ca-app-pub-1928006837437146/2324431519")
        interstitialAd.setAdListener(MyAdListener(interstitialAd));
    }

    // Como es asincrónico, el anuncio se mostrará cuando esté listo (Listener)
    private fun sendAdRequest() {
        var  tManager = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        var  deviceHash = tManager.getDeviceId()

        // Crear la solicitud de anuncio.
        var adRequest = AdRequest.Builder().addTestDevice(deviceHash).build()

        // Comenzar la carga del intersticial.
        interstitialAd.loadAd(adRequest)
    }

    private fun loadAdIfShould() {
        if (gamesCount == 2 || gamesCount == 5)
            this.sendAdRequest()
    }
}

class MyAdListener(interstitial: InterstitialAd) : AdListener() {
    val interstitial = interstitial

    override fun onAdLoaded(){
        interstitial.show()
    }
}
