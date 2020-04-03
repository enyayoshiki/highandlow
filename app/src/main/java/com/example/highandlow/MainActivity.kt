package com.example.highandlow

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val tag = "high and low"
    private var yourCard = 0
    private var droidCard = 0
    private var hitCount = 0
    private var loseCount = 0
    private var gameStart = false
    private var answerd = false


    override fun onResume() {
        super.onResume()
        hitCount = 0
        loseCount = 0
        hit_Text.text = getString(R.string.hittext)
        lose_Text.text = getString(R.string.losetext)
        gameStart = true
        answerd = false
        drawCard()
    }

    private fun drawCard() {
        yourCardimage.setImageResource(R.drawable.z02)
        droidcardimage.setImageResource(R.drawable.z01)

        yourCard = (1..13).random()
        Log.d(tag,"YOU:"+yourCard)
        when(yourCard){
            1 ->yourCardimage.setImageResource(R.drawable.d01)
            2 ->yourCardimage.setImageResource(R.drawable.d02)
            3 ->yourCardimage.setImageResource(R.drawable.d03)
            4 ->yourCardimage.setImageResource(R.drawable.d04)
            5 ->yourCardimage.setImageResource(R.drawable.d05)
            6 ->yourCardimage.setImageResource(R.drawable.d06)
            7 ->yourCardimage.setImageResource(R.drawable.d07)
            8 ->yourCardimage.setImageResource(R.drawable.d08)
            9 ->yourCardimage.setImageResource(R.drawable.d09)
            10 ->yourCardimage.setImageResource(R.drawable.d10)
            11 ->yourCardimage.setImageResource(R.drawable.d11)
            12 ->yourCardimage.setImageResource(R.drawable.d12)
            13 ->yourCardimage.setImageResource(R.drawable.d13)
        }
        droidCard = (1..13).random()
        Log.d(tag,"droid:"+droidCard)
        answerd = false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        highBtn.setOnClickListener{
            if ((gameStart && !answerd)){
                highandlow('h')
            }
        }
        lowBtn.setOnClickListener {
            if (gameStart && !answerd) {
                highandlow('l')
            }
        }
        nextBtn.setOnClickListener {
            if (gameStart) {
                drawCard()
            }
        }
    }
    private fun highandlow(answer:Char) {
        showDroidCard()
        answerd = true
        val balance = droidCard - yourCard
        if (balance == 0) {
        } else if (balance > 0 && answer == 'h') {
            hitCount++
            hit_Text.text = getString(R.string.hittext) + hitCount
        } else if (balance < 0 && answer == 'l') {
            hitCount++
            hit_Text.text = getString(R.string.hittext) + hitCount
        } else {
            loseCount++
            lose_Text.text = getString(R.string.losetext) + loseCount
        }
        if (hitCount == 5) {
            resultText.text = "あなたの勝ちです"
            gameStart = false
        } else if (loseCount == 5) {
            resultText.text = "あなたの負けです"
            gameStart = false
        } else {
        }
    }

    private fun showDroidCard() {
        when (droidCard) {
            1 -> droidcardimage.setImageResource(R.drawable.c01)
            2 -> droidcardimage.setImageResource(R.drawable.c02)
            3 -> droidcardimage.setImageResource(R.drawable.c03)
            4 -> droidcardimage.setImageResource(R.drawable.c04)
            5 -> droidcardimage.setImageResource(R.drawable.c05)
            6 -> droidcardimage.setImageResource(R.drawable.c06)
            7 -> droidcardimage.setImageResource(R.drawable.c07)
            8 -> droidcardimage.setImageResource(R.drawable.c08)
            9 -> droidcardimage.setImageResource(R.drawable.c09)
            10 -> droidcardimage.setImageResource(R.drawable.c10)
            11 -> droidcardimage.setImageResource(R.drawable.c11)
            12 -> droidcardimage.setImageResource(R.drawable.c12)
            13 -> droidcardimage.setImageResource(R.drawable.c13)
        }
    }
}






