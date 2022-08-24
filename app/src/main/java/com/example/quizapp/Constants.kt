package com.example.quizapp

object Constants {
    val userName="user_name"
    val totalQuestion="total_questions"
    val correctAnswers="correct_answers"
    fun getQuestions():ArrayList<Question>{
        val QuestionList=ArrayList<Question>()

        val que1=Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Brazil",
            "Serbia",
            "Panama",
            1
        )
        val que2=Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Russia",
            "Belgium",
            "Georgia",
            "Germany",
            4
        )
        val que3=Question(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Spain",
            "India",
            "Ireland",
            "Indonesia",
            2
        )
        val que4=Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Germany",
            "Belgium",
            "Belarus",
            "Italy",
            2
        )
        val que5=Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Bangladesh",
            "Brazil",
            "Zambia",
            "Jamaica",
            2
        )
        val que6=Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Australia",
            "New Zealand",
            "Fiji",
            "United Kingdom",
            3
        )
        val que7=Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "United Arab Emirates",
            "Kuwait",
            "Jordan",
            "Sudan",
            2
        )
        val que8=Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Switzerland",
            "Finland",
            "Norway",
            1
        )
        val que9=Question(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia",
            "Fiji",
            "United Kingdom",
            "New Zealand",
            4
        )
        val que10=Question(
            10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "New Zealand",
            "Australia",
            "Fiji",
            "United Kingdom",
            1
        )
        QuestionList.add(que1)
        QuestionList.add(que2)
        QuestionList.add(que3)
        QuestionList.add(que4)
        QuestionList.add(que5)
        QuestionList.add(que6)
        QuestionList.add(que7)
        QuestionList.add(que8)
        QuestionList.add(que10)

        return QuestionList

    }
}