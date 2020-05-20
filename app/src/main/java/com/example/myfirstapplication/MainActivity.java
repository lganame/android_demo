package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
public static final String EXTRA_MESSAGE = "com.example.myfirstapplication.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
public void startCurrentPoistion(View view){
        Intent intent = new Intent(this,CurrentPosition.class);
        startActivity(intent);
}

}
