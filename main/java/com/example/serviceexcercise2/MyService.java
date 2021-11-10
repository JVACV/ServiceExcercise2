package com.example.serviceexcercise2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {

    final class MyThreadClass implements Runnable{

        int service_id;
        MyThreadClass(int service_id){
            this.service_id = service_id;
        }

        @Override
        public void run() {

            int i = 0;
            synchronized (this){
                while (i<10){
                    try {
                        wait(1500);
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf(service_id);
            }

        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service is Created", Toast.LENGTH_LONG).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        int i = 0;
//        synchronized (this){
//            while (i<10){
//                try {
//                    wait(1500);
//                    i++;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            stopSelf();
//        }
//        String message;
//        message = intent.getStringExtra("coming");
//        Toast.makeText(this, "Message = "+message, Toast.LENGTH_LONG).show();
//        stopSelf();
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
        Thread thread = new Thread(new MyThreadClass(startId));
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service is Stopped", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
}
