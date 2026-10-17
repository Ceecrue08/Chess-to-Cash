
package com.chesstocash.game

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(20, 30, 20, 30)
            setBackgroundColor(Color.rgb(24, 29, 39))
        }

        val title = TextView(this).apply {
            text = "♟ CHESS-TO-CASH ♟"
            textSize = 27f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        root.addView(title)

        val subtitle = TextView(this).apply {
            text = "THINK • PLAY • WIN"
            textSize = 14f
            setTextColor(Color.rgb(220, 185, 110))
            gravity = Gravity.CENTER
            setPadding(0, 12, 0, 30)
        }

        root.addView(subtitle)

        val board = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        val pieces = arrayOf(
            "♜♞♝♛♚♝♞♜",
            "♟♟♟♟♟♟♟♟",
            "        ",
            "        ",
            "        ",
            "        ",
            "♙♙♙♙♙♙♙♙",
            "♖♘♗♕♔♗♘♖"
        )

        for (row in 0..7) {
            val rank = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
            }

            for (col in 0..7) {
                val square = TextView(this).apply {
                    text = pieces[row][col].toString()
                    textSize = 29f
                    gravity = Gravity.CENTER
                    setTextColor(
                        if (row < 2) Color.BLACK else Color.WHITE
                    )
                    setBackgroundColor(
                        if ((row + col) % 2 == 0)
                            Color.rgb(238, 216, 181)
                        else
                            Color.rgb(120, 82, 58)
                    )
                }

                rank.addView(
                    square,
                    LinearLayout.LayoutParams(0, 43, 1f)
                )
            }

            board.addView(rank)
        }

        root.addView(board)

        val status = TextView(this).apply {
            text = "CHESS COINS: 0"
            textSize = 18f
            setTextColor(Color.rgb(220, 185, 110))
            gravity = Gravity.CENTER
            setPadding(0, 25, 0, 20)
        }

        root.addView(status)

        setContentView(root)
    }
}
