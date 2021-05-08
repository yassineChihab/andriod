package com.example.project

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.project.databinding.ActivityChapterBinding
import com.example.project.databinding.ActivityQcmBinding
import java.util.concurrent.TimeUnit


class QcmActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityQcmBinding
    private var questionsView:RecyclerView?=null
    private var questionCounter:TextView?=null
     var  questListGV:GridView?=null


    private var layoutManager: RecyclerView.LayoutManager? = null
    private var questionAdapter: RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>? = null
    private  var QuestionGridAdapter:QuestionGridAdapter?=null
    var  quesID:Int=0
    var drawer:DrawerLayout?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQcmBinding.inflate(layoutInflater)
        setContentView(R.layout.question_list_layout)
        questionAdapter=QuestionAdapter(this)
        layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        var questionsView=findViewById<RecyclerView>(R.id.questions_view)
        questionsView.adapter=questionAdapter
        questionsView.layoutManager=layoutManager
        var questionCounter=findViewById<TextView>(R.id.questionCounter)
        questionCounter.setText("1/10")
        drawer=findViewById(R.id.drawer_layout)
        QuestionGridAdapter= QuestionGridAdapter(10)
        val GridListQuest:GridView=findViewById(R.id.ques_list_gv)
        GridListQuest.adapter=QuestionGridAdapter


        setSapHelper();
        startTimer();


    }

    private fun startTimer() {
        val totalTime:Long=2*60*1000
        val timer = object: CountDownTimer(totalTime+1000, 1000) {
            override fun onTick(remainigTime: Long) {
                val time:String= String.format("%02d:%02d min",
                    TimeUnit.MILLISECONDS.toMinutes(remainigTime),
                    TimeUnit.MILLISECONDS.toSeconds(remainigTime)-
                    TimeUnit.MINUTES.toSeconds( TimeUnit.MILLISECONDS.toMinutes(remainigTime))
                    )
                val timer=findViewById<TextView>(R.id.timer)
                timer.setText(time)

            }

            override fun onFinish() {

            }
        }
        timer.start()
    }

    fun setSapHelper(){
        val snapHleper=PagerSnapHelper()
        var questionsView=findViewById<RecyclerView>(R.id.questions_view)
        snapHleper.attachToRecyclerView(questionsView)
        questionsView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val view =snapHleper.findSnapView(recyclerView.layoutManager)
                quesID= recyclerView.layoutManager!!.getPosition(view!!)
                var questionCounter=findViewById<TextView>(R.id.questionCounter)
                questionCounter.setText((quesID+1).toString() + "/10")
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }


    fun next(view: View) {
        if(quesID<10){
            var questionsView=findViewById<RecyclerView>(R.id.questions_view)
           questionsView!!.smoothScrollToPosition(quesID+1)
        }
    }
    fun Go_Back(view: View) {

        if(quesID>0){
            var questionsView=findViewById<RecyclerView>(R.id.questions_view)
            questionsView!!.smoothScrollToPosition(quesID-1)
        }
    }

    fun AfficheScore(view: View) {
        val intent= Intent(this ,ResultActivity ::class.java)
        startActivity(intent)
        finish()
    }


}