package br.com.mobile.alunosemgrupo

import androidx.room.RoomDatabase
import androidx.room.Database



    @Database(entities = arrayOf(RankingBuilder::class), version = 1)
    abstract class FlagDatabase: RoomDatabase() {
        abstract fun flagDao(): FlagDAO
        }
