package com.example.quizapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var tvResult=findViewById<TextView>(R.id.tvResult)
        var tvResultName=findViewById<TextView>(R.id.tvResultName)
        var btnFinish=findViewById<Button>(R.id.btnResultFinish)

        tvResultName.text=intent.getStringExtra(Constants.userName)
        val correctAnswers=intent.getIntExtra(Constants.correctAnswers,0)
        val TotalQuestions=intent.getIntExtra(Constants.totalQuestion,0)

        tvResult.text="You scored $correctAnswers out of $TotalQuestions"
        btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}