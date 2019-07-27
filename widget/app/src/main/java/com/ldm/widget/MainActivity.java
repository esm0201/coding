package com.ldm.widget;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    SeekBar sb;
    Button bt;
    int mValueProgress;
    public static final int NOTIFICATION_ID = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        sb = findViewById(R.id.seekBar);
        bt = findViewById(R.id.button);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mValueProgress = progress;
                tv.setText("현재 볼륨"+mValueProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "볼륨크기를"+mValueProgress+"에서 시작이겠지 뭐!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "볼륨크기를"+mValueProgress+"으로 변경 완료!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onSetNoti(View v){
        Toast.makeText(getApplicationContext(), Build.VERSION.SDK_INT+" "+Build.VERSION_CODES.O, Toast.LENGTH_SHORT).show();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        String NOTIFICATION_CHANNEL_ID = "CH_ID_01";

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,"My Notifications",NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0,1000,500,1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,NOTIFICATION_CHANNEL_ID);
        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle("중요공지")
                .setContentText("4차산업혁명에 대한 공지입니다.")
                .setSubText("클릭하면 구글의 홈페이지로 이동 가능")
                .setLargeIcon(BitmapFactory.decodeResource((getResources()),R.drawable.dog))
                .setContentIntent(pendingIntent);

                notificationManager.notify(NOTIFICATION_ID,notificationBuilder.build());
    }
}
