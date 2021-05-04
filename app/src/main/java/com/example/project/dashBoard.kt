package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class dashBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
    }

    fun LancerQuiz(view: View) {

        val intent=Intent(this,ChapterActivity::class.java);
        this.startActivity(intent)



    }
}