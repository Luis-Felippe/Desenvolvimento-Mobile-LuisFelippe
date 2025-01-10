package com.example.startservice

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat

class BackgroundService: Service() {
    private  val channelID = "background_service_channel"
    private var isrunning = false

    override fun onCreate() {
        creteNotificationChannel()
        isrunning = true
        Toast.makeText(this, "serviço criado", Toast.LENGTH_SHORT).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification = NotificationCompat.Builder(this, channelID)
            .setContentTitle("Serviço em execução")
            .setContentText("O serviço está sendo executado em segundo plano")
            .setSmallIcon(android.R.drawable.ic_menu_info_details)
            .setOngoing(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        startForeground(1, notification)
        Toast.makeText(this, "serviço iniciado", Toast.LENGTH_SHORT).show()

        Thread{
            while (isrunning){
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException){
                    e.printStackTrace()
                }
            }
            stopSelf()
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        isrunning = false
        Toast.makeText(this, "Serviço parado", Toast.LENGTH_SHORT).show()
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun creteNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                channelID,
                "serviço em background",
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(channel)
        }
    }

}