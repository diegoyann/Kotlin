package br.com.mobile.alunosemgrupo

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService : FirebaseMessagingService() {
val TAG = "firebase"

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG,"Novo Token : $token")

        Prefs.setString("FB_TOKEN",token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.d(TAG, "Menssagem Recebida")

        if (message?.notification != null){
            val titulo = message?.notification?.title
            val texto = message?.notification?.body
            Log.d(TAG, titulo!!)
            Log.d(TAG, texto!!)
            NotificationUtil.create(1,Intent(this,MainActivity::class.java),titulo,texto)

        }
    }



}