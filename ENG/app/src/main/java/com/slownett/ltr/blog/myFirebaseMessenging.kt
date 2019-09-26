package com.slownett.ltr.blog

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.net.Uri
import java.io.IOException
import java.net.URL
import javax.net.ssl.HttpsURLConnection


//TODO: Apply notification
class myFirebaseMessenging:FirebaseMessagingService(){

    override fun onMessageReceived(p0: RemoteMessage?) {
        super.onMessageReceived(p0)

        var from=p0!!.from
        Log.d("From: ",from)

        if (p0.notification!=null){
            Log.d("notification: ", p0.notification!!.body)

            montrerNotification(p0.notification!!.title,p0.notification!!.body)
        }

        if (p0.data.size>0){
            Log.d("notification: ", p0.data.toString())
        }
    }


    fun getBitmapFromURL(src: String): Bitmap? {
        try {
            val url = URL(src)
            val connection = url.openConnection() as HttpsURLConnection
            connection.setDoInput(true)
            connection.connect()
            val input = connection.inputStream
            return BitmapFactory.decodeStream(input)
        } catch (e: IOException) {
            // Log exception
            return null
        }

    }


    private fun montrerNotification(title: String?, body: String?) {

        var sound=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        var intent=Intent(this, Home::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
       // intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        var pending= PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT)
        var notb:NotificationCompat.Builder=NotificationCompat.Builder(this)


                .setSmallIcon(R.drawable.icon)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(sound)
                .setContentIntent(pending)

        var notManager:NotificationManager= getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notManager.notify(0,notb.build())
    }
}