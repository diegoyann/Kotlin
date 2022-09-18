package br.com.mobile.alunosemgrupo


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color.parseColor
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat


class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswer = 0
    private var mUserName : String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        mUserName = intent.getStringExtra(Constants.user_name)

        mQuestionList = Constants.getQuestions()
        setQuestions()
        val optionOne = findViewById<TextView>(R.id.tv_opcao_um)
        val optionTwo = findViewById<TextView>(R.id.tv_opcao_dois)
        val optionThree = findViewById<TextView>(R.id.tv_opcao_tres)
        val optionFour = findViewById<TextView>(R.id.tv_opcao_quatro)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)


        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)



    }
    @SuppressLint("SetTextI18n")
    private fun setQuestions(){

        val optionOne = findViewById<TextView>(R.id.tv_opcao_um)
        val optionTwo = findViewById<TextView>(R.id.tv_opcao_dois)
        val optionThree = findViewById<TextView>(R.id.tv_opcao_tres)
        val optionFour = findViewById<TextView>(R.id.tv_opcao_quatro)
        val tvQuestion = findViewById<TextView>(R.id.textviewquestion)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)


        val question = mQuestionList!![mCurrentPosition -1]
        defaultOptionsView()

        if(mCurrentPosition == mQuestionList!!.size){
            btnSubmit.text = "Terminar"
        }else{
            btnSubmit.text = "Responder"
        }

        val progressBar = findViewById<ProgressBar>(R.id.barraprogresso)
        val tvProgressBar = findViewById<TextView>(R.id.tv_progresso)
        val ivImage = findViewById<ImageView>(R.id.iv_image)

        progressBar.progress = mCurrentPosition
        tvProgressBar.text = "$mCurrentPosition " + "/" + progressBar.max

        tvQuestion.text = question.question

        ivImage.setImageResource(question.image )

        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionThree.text = question.optionThree
        optionFour.text = question.optionFour

    }

    private fun defaultOptionsView(){
    val optionOne = findViewById<TextView>(R.id.tv_opcao_um)
    val optionTwo = findViewById<TextView>(R.id.tv_opcao_dois)
    val optionThree = findViewById<TextView>(R.id.tv_opcao_tres)
    val optionFour = findViewById<TextView>(R.id.tv_opcao_quatro)



        val opcoes = ArrayList<TextView>()
        opcoes.add(0,optionOne)
        opcoes.add(1,optionTwo)
        opcoes.add(2,optionThree)
        opcoes.add(3,optionFour)
        for (option in opcoes){
            option.setTextColor(parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        val optionOne = findViewById<TextView>(R.id.tv_opcao_um)
        val optionTwo = findViewById<TextView>(R.id.tv_opcao_dois)
        val optionThree = findViewById<TextView>(R.id.tv_opcao_tres)
        val optionFour = findViewById<TextView>(R.id.tv_opcao_quatro)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)
        defaultOptionsView()


        when (v?.id){


            R.id.tv_opcao_um ->{
                selectedOptionView(optionOne,1)
            }
            R.id.tv_opcao_dois ->{
                selectedOptionView(optionTwo,2)
            }
            R.id.tv_opcao_tres ->{
                selectedOptionView(optionThree,3)
            }
            R.id.tv_opcao_quatro ->{
                selectedOptionView(optionFour,4)
            }
            R.id.btn_submit ->{
                if (mSelectedOptionPosition == 0){
                   mCurrentPosition ++
                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestions()
                        }
                        else->{
                            val intent = Intent(this,FinalResultActivity::class.java)
                            intent.putExtra(Constants.user_name, mUserName)
                            intent.putExtra(Constants.correct_answers, mCorrectAnswer)
                            intent.putExtra(Constants.total_questions,mQuestionList!!.size)
                            startActivity(intent)
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                       mCorrectAnswer ++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                    if(mCurrentPosition == mQuestionList!!.size){
                        btnSubmit.text = "Terminar"
                    }else{
                        btnSubmit.text = "Proxima Pergunta"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }

    }
    private fun answerView(answer: Int, drawableView : Int) {
        val optionOne = findViewById<TextView>(R.id.tv_opcao_um)
        val optionTwo = findViewById<TextView>(R.id.tv_opcao_dois)
        val optionThree = findViewById<TextView>(R.id.tv_opcao_tres)
        val optionFour = findViewById<TextView>(R.id.tv_opcao_quatro)

        when (answer) {
            1 -> {
                optionOne.background = ContextCompat.getDrawable(this, drawableView)
            }

            2 -> {
                optionTwo.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                optionThree.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                optionFour.background = ContextCompat.getDrawable(this, drawableView)
            }

        }
    }

    private fun selectedOptionView(tv: TextView, selectedOption : Int){

        mSelectedOptionPosition = selectedOption
        tv.setTextColor(parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.typeface = Typeface.DEFAULT
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)

    }


}