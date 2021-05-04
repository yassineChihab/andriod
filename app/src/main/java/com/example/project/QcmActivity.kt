package com.example.project

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.project.databinding.ActivityChapterBinding
import com.example.project.databinding.ActivityQcmBinding
import java.util.concurrent.TimeUnit


class QcmActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityQcmBinding

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var questionAdapter: RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>? = null

    var  quesID:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQcmBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        questionAdapter=QuestionAdapter(this)
        layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.questionsView.adapter=questionAdapter
        binding.questionsView.layoutManager=layoutManager
        binding.questionCounter.setText("1/10")

        setSapHelper();
        startTimer();

    }

    private fun startTimer() {
        val totalTime:Long=10*60*1000
        val timer = object: CountDownTimer(totalTime+2000, 1000) {
            override fun onTick(remainigTime: Long) {
                val time:String= String.format("%02d:%02d min",
                    TimeUnit.MILLISECONDS.toMinutes(remainigTime),
                    TimeUnit.MILLISECONDS.toSeconds(remainigTime)-
                    TimeUnit.MINUTES.toSeconds( TimeUnit.MILLISECONDS.toMinutes(remainigTime))
                    )
                binding.timer.setText(time)

            }

            override fun onFinish() {

            }
        }
        timer.start()
    }

    fun setSapHelper(){
        val snapHleper=PagerSnapHelper()
        snapHleper.attachToRecyclerView(binding.questionsView)
        binding.questionsView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val view =snapHleper.findSnapView(recyclerView.layoutManager)
                quesID= recyclerView.layoutManager!!.getPosition(view!!)
                binding.questionCounter.setText((quesID+1).toString() + "/10")
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }


    fun next(view: View) {
        if(quesID<10){
            binding.questionsView.smoothScrollToPosition(quesID+1)
        }
    }
    fun Go_Back(view: View) {

        if(quesID>0){
            binding.questionsView.smoothScrollToPosition(quesID-1)
        }
    }
}