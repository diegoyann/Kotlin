package br.com.mobile.alunosemgrupo

    import android.content.SharedPreferences
    import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.Flag

object Prefs {
        val PREF_ID = "FLAG"

        private fun prefs(): SharedPreferences {
            val context = FlagApplication.getInstance().applicationContext
            return context.getSharedPreferences(PREF_ID, 0)
        }
//salva a shared preference
        fun setBoolean(flag: String, valor: Boolean) =  prefs().edit().putBoolean(flag, valor).apply()

        fun getBoolean(flag: String) = prefs().getBoolean(flag, false)

        fun setString(flag: String, valor: String) =  prefs().edit().putString(flag, valor).apply()

        fun getString(flag: String) = prefs().getString(flag, "")

    }