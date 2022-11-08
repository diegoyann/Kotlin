package br.com.mobile.alunosemgrupo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "ranking")
class RankingBuilder : Serializable{
    @PrimaryKey
    var id:Long = 0
    var user: String = ""
    var position: String = ""
    var quantity: String = ""
    var date: String = ""
    var newRank: Boolean = false

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}





