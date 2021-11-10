package com.example.serviceexcercise2;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SecondService extends IntentService {
    private static final String TAG ="Service test" ;

    /**
     * @deprecated
     */
    public SecondService() {
        super("My Service");
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service is Created", Toast.LENGTH_LONG).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service is Started", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "from the onHandleIntent method ");
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service is Stopped", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
}
