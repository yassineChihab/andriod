package com.example.project

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat

class Spalch : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalch)
        val appname:TextView=findViewById(R.id.app_name);
      //  val type=ResourcesCompat.getFont(this,R.drawable.blacklist)
        //appname.setTypeface(type)
        val animation=AnimationUtils.loadAnimation(this,R.anim.animation)
        appname.animation=animation
        val time:Long=4000


        Handler().postDelayed(
            Runnable {
                val intent= Intent(SplashScreen@this,LoginActivityy::class.java)
                startActivity(intent)
                finish()


            } ,time
        )
    }
}