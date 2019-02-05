package com.example.a16danielbr.notificaciones_estado;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIF_ALERTA_ID = 1;
    private Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.boton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder ncBuilder = new NotificationCompat.Builder(MainActivity.this);

                ncBuilder.setSmallIcon(android.R.drawable.stat_sys_warning);
                ncBuilder.setTicker("Alerta!");

                ncBuilder.setContentTitle("Mensaje de Alerta");
                ncBuilder.setContentText("Esto es un ejemplo de notificación.");

                Bitmap icono= BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
                ncBuilder.setLargeIcon(icono);

                Intent i = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, i, 0);
                ncBuilder.setContentIntent(pi);

                ncBuilder.setAutoCancel(true);

                NotificationManager nm = (NotificationManager)getSystemService(MainActivity.this.NOTIFICATION_SERVICE);
                Notification notificacion=ncBuilder.build();
                nm.notify(NOTIF_ALERTA_ID, notificacion);
            }
        });


    }
}
