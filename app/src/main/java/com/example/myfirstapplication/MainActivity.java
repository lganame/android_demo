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
public void startMyPosition(View view){
        Intent intent = new Intent(this,MyPosition.class);
        startActivity(intent);
    }

    public  void startLearnContent(View view){
        Intent intent = new Intent(this,LearnContent.class);
        startActivity(intent);
    }

    public void operateData(View view){
        Intent intent = new Intent(this,OperateData.class);
        startActivity(intent);
    }

    public void  startMyBlog(View view){
        Intent intent = new Intent(this,MyBlog.class);
        startActivity(intent);
    }
    public void startMyGitHub(View view){
        Intent intent = new Intent(this,MyGitHub.class);
        startActivity(intent);
    }
    public void startIntroMyself(View view){
        Intent intent = new Intent(this,IntroMyself.class);
        startActivity(intent);
    }

    public void  startAppUpdate(View view){
        Intent intent = new Intent(this,AppUpdate.class);
        startActivity(intent);
    }

}
