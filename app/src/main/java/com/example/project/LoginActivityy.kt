package com.example.project

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.project.databinding.ActivityLoginActivityyBinding
import com.example.project.databinding.ActivityLoginBinding

class LoginActivityy : AppCompatActivity() {
    //var binding: ActivityLoginBinding? = null
   private lateinit var  binding: ActivityLoginActivityyBinding
   
    var dialog: ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginActivityyBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
      
        dialog = ProgressDialog(this)
        dialog!!.setMessage("Logging in...")
        binding!!.submitBtn.setOnClickListener{ startActivity(Intent(this,dashBoard::class.java))}
        binding!!.createNewBtn.setOnClickListener { startActivity(Intent(this@LoginActivityy, signupactivity::class.java)) }
    }
}