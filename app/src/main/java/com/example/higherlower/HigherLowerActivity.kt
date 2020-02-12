package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class MainActivity : AppCompatActivity() {
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
        btnLower.setOnClickListener {
            onLowerClick()
        }
        btnEqual.setOnClickListener {
            onEqualClick()
        }
        btnHigher.setOnClickListener {
            onHigherClick()
        }
    }

    /**
     * Set the initial (UI) state of the game.
     */
    private fun initViews() {
        updateUI()
    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */
    private fun updateUI() {
        tvLastThrow.text = getString(R.string.last_throw, currentThrow)
        if (currentThrow == 1) {
            diceView.setImageResource(R.drawable.dice1)
        } else  if (currentThrow == 2) {
            diceView.setImageResource(R.drawable.dice2)
        } else  if (currentThrow == 3) {
            diceView.setImageResource(R.drawable.dice3)
        } else  if (currentThrow == 4) {
            diceView.setImageResource(R.drawable.dice4)
        } else  if (currentThrow == 5) {
            diceView.setImageResource(R.drawable.dice5)
        } else  if (currentThrow == 6) {
            diceView.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick() {
        rollDice()
        if (lastThrow < currentThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onLowerClick() {
        rollDice()
        if (lastThrow > currentThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onEqualClick() {
        rollDice()
        if (lastThrow == currentThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    /**
     * Displays a successful Toast message.
     */
    private fun onAnswerCorrect() {
        Toast.makeText(this, getString((R.string.correct)), Toast.LENGTH_LONG).show()
    }

    /**
     * Displays a incorrect Toast message.
     */
    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString((R.string.incorrect)), Toast.LENGTH_LONG).show()
    }
}
