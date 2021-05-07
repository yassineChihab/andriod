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
    val manager=supportFragmentManager
    fun AfficheFragemntRank(view: View) {
        val trans=manager.beginTransaction()
        var fragmantRank=rankFragment()
        trans.add(R.id.maincontainer,fragmantRank)
        trans.addToBackStack("tag").commit()
    }

    fun afficheProgilFragmant(view: View) {
        val trans=manager.beginTransaction()
        var fragmentProfil=ProfilFragment()
        trans.add(R.id.maincontainer,fragmentProfil)
        trans.addToBackStack("tag").commit()
    }
}