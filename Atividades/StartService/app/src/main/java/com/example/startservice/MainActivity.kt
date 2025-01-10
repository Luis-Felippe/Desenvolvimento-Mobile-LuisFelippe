package com.example.startservice

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Message
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.startservice.ui.theme.StartServiceTheme

class MainActivity : ComponentActivity() {

    private val controllChannelId = "Service_control_channel"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ServiceControllScreen(onStopClick = {}, onStartClick = {})
        }

    }

    private fun startBackgroundService(){
        val intent = Intent(this, BackgroundService::class.java)
        startService(intent)
        Toast.makeText(this, "Serviço iniciado pelo botão", Toast.LENGTH_SHORT).show()
        showControlNotification("serviço iniciado")
    }

    private fun stopBackgroundService(){
        val intent = Intent(this, BackgroundService::class.java)
        startService(intent)
        Toast.makeText(this, "Solicitaçao para parar os serviço", Toast.LENGTH_SHORT).show()
        showControlNotification("serviço parado")
    }

    private fun showControlNotification(message: String){
        val notification = NotificationCompat.Builder(this, controllChannelId)
            .setContentTitle("Controle de serviço")
            .setContentText(message)
            .setSmallIcon(android.R.drawable.ic_menu_info_details)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        NotificationManagerCompat.from(this).notify(System.currentTimeMillis().toInt(), notification)
    }

    private fun createControlNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                controllChannelId,
                "Controle de serviço",
                NotificationManager.IMPORTANCE_HIGH
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(channel)
        }
    }

    private fun requestNotificationPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val requestPermission = registerForActivityResult(ActivityResultContracts.RequestPermission){
                isGranted ->
                if(isGranted){
                    Toast.makeText(this, "Permissão negada", Toast.LENGTH_SHORT).show()
                }
                requestP
            }

        }
    }
}



