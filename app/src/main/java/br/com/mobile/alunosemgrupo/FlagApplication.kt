package br.com.mobile.alunosemgrupo

import android.app.Application
import java.lang.IllegalStateException

class FlagApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: FlagApplication? = null
        fun getInstance(): FlagApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar application no Android Manifest")
            }
            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}