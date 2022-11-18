package com.mpasko.groupapplication

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    lateinit var tv_time: TextView
    lateinit var tv_clicks: TextView

    lateinit var b_start: Button
    lateinit var b_click: Button

    var currentTime = 10
    var currentClicks = 0

    //stworzenie timera
    lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        //init objektów
        tv_time = findViewById(R.id.tv_time)
        tv_clicks = findViewById(R.id.tv_clicks)

        b_start = findViewById(R.id.b_start)
        b_click = findViewById(R.id.b_click)

        //init gry
        b_click.isEnabled = false

        b_start.setOnClickListener {
            //rozpoczecie nowej gry
            currentTime = 10 // 10 sekund
            currentClicks = 0

            tv_time.text = "Czas: $currentTime"
            tv_clicks.text = "Kliknięcia: $currentClicks"

            //zmiana buttona
            b_start.isEnabled = false
            b_click.isEnabled = true

            //start timera
            timer.start()
        }

        b_click.setOnClickListener {
            //zwiększenie liczby kliknięć
            currentClicks++;
            tv_clicks.text = "Kliknięcia: $currentClicks"
        }

        //init timera
        timer = object : CountDownTimer(10000, 1000) { //10000 = 10 seconds game, 1000 = refresh each second
            override fun onTick(millisUntilFinished: Long) {

                currentTime--
                val time = currentTime + 1
                tv_time.text = "Czas: $time"
            }

            override fun onFinish() {
                //koniec timera
                tv_time.text = "Czas: 0"

                //zmiana buttona
                b_start.isEnabled = true
                b_click.isEnabled = false
            }
        }
    }
}