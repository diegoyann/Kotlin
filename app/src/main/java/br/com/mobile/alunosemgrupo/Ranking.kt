package br.com.mobile.alunosemgrupo

import android.provider.SyncStateContract.Columns
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.util.TableInfo.Column
import com.google.gson.GsonBuilder
import java.io.Serializable


data class Ranking(
    val user: String,
    val position: String,
    val quantity: String, var date: String,
    var selected: Boolean = false,
    var newRank: Boolean = false

)

@Entity(tableName = "ranking")
class RankingBuilder : Serializable{
    @PrimaryKey
    var id:Long = 0
    var user: String = ""
    var position: String = ""
    var quantity: String = ""
    var date: String = ""


    fun build() : Ranking = Ranking(user,position,quantity,date,false)
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}

fun ranking ( block : RankingBuilder.() -> Unit): Ranking = RankingBuilder().apply(block).build()

fun realRanking():List<RankingBuilder> {
    val rank = listOf<RankingBuilder>()

    return rank
}



