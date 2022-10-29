package br.com.mobile.alunosemgrupo

import androidx.room.RoomDatabase
import androidx.room.Database
import br.com.mobile.alunosemgrupo.Ranking


    @Database(entities = arrayOf(Ranking::class), version = 1)
    abstract class FlagDatabase: RoomDatabase() {
        abstract fun flagDao(): FlagDAO
        }
