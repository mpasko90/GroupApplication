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

    //create timer
    lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        //init the objects
        tv_time = findViewById(R.id.tv_time)
        tv_clicks = findViewById(R.id.tv_clicks)

        b_start = findViewById(R.id.b_start)
        b_click = findViewById(R.id.b_click)

        //init the game by disabling the click button
        b_click.isEnabled = false

        //click listeners
        b_start.setOnClickListener {
            //start new game
            currentTime = 10 // 10 seconds game
            currentClicks = 0

            tv_time.text = "Time: $currentTime"
            tv_clicks.text = "Clicks: $currentClicks"

            //change button state
            b_start.isEnabled = false
            b_click.isEnabled = true

            //start the timer
            timer.start()
        }

        b_click.setOnClickListener {
            //increase clicks and display them
            currentClicks++;
            tv_clicks.text = "Clicks: $currentClicks"
        }

        //init the timer
        timer = object : CountDownTimer(10000, 1000) { //10000 = 10 seconds game, 1000 = refresh each second
            override fun onTick(millisUntilFinished: Long) {
                //each second display the time
                currentTime--
                val time = currentTime + 1 // adjust the time + 1 for the output
                tv_time.text = "Time: $time"
            }

            override fun onFinish() {
                //timer ended
                tv_time.text = "Time: 0"

                //change button state
                b_start.isEnabled = true
                b_click.isEnabled = false
            }
        }
    }
}