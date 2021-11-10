package com.example.serviceexcercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startMethod(View view) {
        Intent intent = new Intent(this,ThirdService.class);
//        intent.putExtra("Hello", "This is my message");
        startService(intent);
    }

    public void stopMethod(View view) {
        Intent intent = new Intent(this,ThirdService.class);
        stopService(intent);
    }
}