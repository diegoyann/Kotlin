package br.com.mobile.alunosemgrupo.model


data class Ranking(
    val user: String,
    val position: String,
    val quantity: String, var date: String,
    var selected: Boolean = false,
    var newRank: Boolean = false
)

class RankingBuilder{
    var user: String = ""
    var position: String = ""
    var quantity: String = ""
    var date: String = ""
    var newRank: Boolean = false

    fun build() : Ranking = Ranking(user,position,quantity,date,false, newRank)
}

fun ranking ( block : RankingBuilder.() -> Unit): Ranking = RankingBuilder().apply(block).build()

fun fakeRanking():MutableList<Ranking> = mutableListOf(
    ranking {
        user = "Thiago"
        position = "1"
        quantity = "10 acertos"
        date = "10 Outubro"
        newRank = false
    },
    ranking {
        user = "Matheus"
        position = "2"
        quantity = "9 acertos"
        date = "10 Outubro"
        newRank = false
    },
    ranking {
        user = "Angela"
        position = "3"
        quantity = "9 acertos"
        date = "15 Outubro"
        newRank = true
    },
    ranking {
        user = "Julia"
        position = "4"
        quantity = "8 acertos"
        date = "10 Outubro"
        newRank = false
    },
    ranking {
        user = "Fernando"
        position = "5"
        quantity = "7 acertos"
        date = "10 Outubro"
        newRank = false
    },
    ranking {
        user = "Marcelo"
        position = "6"
        quantity = "7 acertos"
        date = "14 Outubro"
        newRank = true
    }
)