package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.project.databinding.ActivityLoginBinding

class loginActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN

        binding= ActivityLoginBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        binding.lancer.setOnClickListener {
            if(binding.nom.text.toString().isEmpty()){
                Toast.makeText(this,"Entre votre nom svp",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent=Intent(this ,dashBoard::class.java)
                startActivity(intent)
                finish()


            }
        }


    }
}