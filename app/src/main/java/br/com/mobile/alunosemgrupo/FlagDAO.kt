package br.com.mobile.alunosemgrupo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FlagDAO {
    @Query("SELECT * FROM ranking")
    fun getById(id: Long) : RankingBuilder?

    @Query("SELECT * FROM ranking")
    fun findAll(): List<RankingBuilder>

    @Insert
    fun insert(ranking: RankingBuilder)

    @Delete
    fun delete(ranking: RankingBuilder)
}