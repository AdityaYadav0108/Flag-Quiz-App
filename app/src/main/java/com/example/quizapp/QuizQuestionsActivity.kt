package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelecetedOption:Int=0
    private var userName:String?=null
    private var progressBar:ProgressBar?=null
    private var tvProgress:TextView?=null
    private var tvQuestion:TextView?=null
    private var ivFlag: ImageView?=null

    private var tvo1:TextView? =null
    private var tvo2:TextView? =null
    private var tvo3:TextView? =null
    private var tvo4:TextView? =null
    private var btnSubmit: Button?=null

    private var correctAnswers:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        userName=intent.getStringExtra(Constants.userName)

        progressBar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.tvProgress)
        tvQuestion=findViewById(R.id.tvQuestion)
        ivFlag=findViewById(R.id.ivFlag)

        tvo1=findViewById(R.id.tvo1)
        tvo2=findViewById(R.id.tvo2)
        tvo3=findViewById(R.id.tvo3)
        tvo4=findViewById(R.id.tvo4)
        btnSubmit=findViewById(R.id.btnSubmit)


        tvo1?.setOnClickListener(this)
        tvo2?.setOnClickListener(this)
        tvo3?.setOnClickListener(this)
        tvo4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()



        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        ivFlag?.setImageResource(question.image)
        tvQuestion?.text = question.question
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition / ${progressBar?.max}"
        tvo1?.text = question.optionOne
        tvo2?.text = question.optionTwo
        tvo3?.text = question.optionThree
        tvo4?.text = question.optionFour
        if(mCurrentPosition==mQuestionList!!.size){
            btnSubmit?.text="FINISH"
        }
        else{
            btnSubmit?.text="SUBMIT"
        }

    }
    fun selectedOptionView(tv:TextView?, selectedOptionNum:Int){
        defaultOptionsView()
        mSelecetedOption=selectedOptionNum
        tv?.setTypeface(tv.typeface,Typeface.BOLD)
        tv?.background=ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.tvo1 -> {
                tvo1?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.tvo2 -> {
                tvo2?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tvo3 -> {
                tvo3?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tvo4 -> {
                tvo4?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btnSubmit -> {
                if (mSelecetedOption == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else->{
                            Toast.makeText(this,"You made it to the end",Toast.LENGTH_SHORT).show()
                            val intent=Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.userName,this.userName)
                            intent.putExtra(Constants.totalQuestion,mQuestionList!!.size)
                            intent.putExtra(Constants.correctAnswers,this.correctAnswers)
                            startActivity(intent)
                            finish()


                        }
                    }
                }else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctOption != mSelecetedOption) {
                        answerView(mSelecetedOption, R.drawable.wrong_option_bg)
                    } else
                        correctAnswers++
                    answerView(question!!.correctOption, R.drawable.correct_option_bg)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        btnSubmit?.text = "FINISH"

                    } else
                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    mSelecetedOption = 0
                }



            }
        }
    }

    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                tvo1?.background=ContextCompat.getDrawable(this, drawableView)
            }
            2->{
                tvo2?.background=ContextCompat.getDrawable(this, drawableView)
            }
            3->{
                tvo3?.background=ContextCompat.getDrawable(this, drawableView)
            }
            4->{
                tvo4?.background=ContextCompat.getDrawable(this, drawableView)
            }

        }
    }
    private fun defaultOptionsView( ){
        val options=ArrayList<TextView>()


        tvo1?.let{
            options.add(0,it)
        }
        tvo2?.let{
            options.add(1,it)
        }
        tvo3?.let{
            options.add(2,it)
        }
        tvo4?.let{
            options.add(3,it)
        }
        for (option in options){
            option.background=ContextCompat.getDrawable(
                this,R.drawable.default_option_bg)
        }


    }
}