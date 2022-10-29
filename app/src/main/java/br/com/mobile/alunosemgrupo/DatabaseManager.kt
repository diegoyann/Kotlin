package br.com.mobile.alunosemgrupo
import androidx.room.Room

object DatabaseManager {

    // singleton
    private var dbInstance: FlagDatabase
    init {
        val appContext = FlagApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext,
            FlagDatabase::class.java,
            "lms.sqlite"
        ).build()
    }

    fun getRankingDAO(): FlagDAO {
        return dbInstance.flagDao()
    }
}







