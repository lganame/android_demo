package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myfirstapplication.teach.CustomListVIew;


public class MainActivityOrigin extends AppCompatActivity {
public static final String EXTRA_MESSAGE = "com.example.myfirstapplication.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_orgin);
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
    public void  startXiuRen(View view){
        System.out.println(view.getId());
        Toast.makeText(MainActivityOrigin.this,view.getId()+"",Toast.LENGTH_SHORT).show();
        /*switch(view.getId()){
        }*/

        Intent intent = new Intent(this,XiuRen.class);
        switch(view.getId()){
            case R.id.button12:{
                startActivity(intent.putExtra("url","https://github.com/lganame"));
                break;
            }
            case R.id.button15:{
                startActivity(intent.putExtra("url","https://www.kanxiaojiejie.com"));
                break;
            }
            case R.id.button16:{
                startActivity(intent.putExtra("url","http://www.1fuhskex.com/pc/index.html#/"));
                break;
            }
            case R.id.button17:{
                startActivity(intent.putExtra("url","https://zhimeishe.com"));
                break;
            }
            default:{
                startActivity(intent.putExtra("url","https://www.baidu.com"));
            }
        }
    }
    public void startTeach(View view){
        Intent intent = new Intent(this, CustomListVIew.class);
        startActivity(intent);
    }


}
