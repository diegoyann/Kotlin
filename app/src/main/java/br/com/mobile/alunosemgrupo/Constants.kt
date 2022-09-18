package br.com.mobile.alunosemgrupo

object Constants{

  const val user_name : String = "user_name"
    const val  total_questions : String = "total_questions"
    const val correct_answers :String = "correct_answers"

    fun getQuestions(): ArrayList<Questions>{
        val questionList = ArrayList<Questions>()

        val question1 = Questions(1,
            "A qual país pertence essa bandeira?",
            R.drawable.flag_of_argentina,
            "Australia",
            "Argentina",
            "Armênia",
            "Colômbia",
            2
        )
        questionList.add(question1)

        val question2 = Questions(2,
            "A qual país pertence essa bandeira?",
            R.drawable.flag_of_australia,
            "Australia",
            "China",
            "Armênia",
            "Colômbia",
            1
        )
        questionList.add(question2)

        val question3 = Questions(3,
            "A qual país pertence essa bandeira?",
            R.drawable.flag_of_belgium,
            "Alemanha",
            "Bélgica",
            "Armênia",
            "Colômbia",
            2
        )
        questionList.add(question3)

        val question4 = Questions(4,
            "A qual país pertence essa bandeira?",
            R.drawable.flag_of_brazil,
            "Estados Unidos",
            "Venezuela",
            "Brasil",
            "Colômbia",
            3
        )
        questionList.add(question4)

        val question5 = Questions(5,
            "A qual país pertence essa bandeira?",
            R.drawable.flag_of_denmark,
            "Finlandia",
            "Suécia",
            "Armênia",
            "Dinamarca",
            4
        )
        questionList.add(question5)

        val question6 = Questions(6,
            "A qual país pertence essa bandeira?",
            R.drawable.flag_of_fiji,
            "Venezuela",
            "Estados Unidos",
            "Inglaterra",
            "Fiji",
            4
        )
        questionList.add(question6)

        val question7 = Questions(7,
            "A qual país pertence essa bandeira?",
            R.drawable.flag_of_germany,
            "Africa do Sul",
            "Alemanha",
            "Japão",
            "Chile",
            2
        )
        questionList.add(question7)

        val question8 = Questions(8,
            "A qual país pertence essa bandeira?",
            R.drawable.flag_of_india,
            "Egito",
            "Peru",
            "India",
            "Colômbia",
            3
        )
        questionList.add(question8)

        val question9 = Questions(9,
            "A qual país pertence essa bandeira?",
            R.drawable.flag_of_kuwait,
            "Egito",
            "Republica Democrática do Congo",
            "Armênia",
            "Kuwait",
            4
        )
        questionList.add(question9)

        val question10 = Questions(10,
            "A qual país pertence essa bandeira?",
            R.drawable.flag_of_new_zealand,
            "Nova Zelândia",
            "Australia",
            "Inglaterra",
            "Escócia",
            1
        )
        questionList.add(question10)


        return questionList
    }
}