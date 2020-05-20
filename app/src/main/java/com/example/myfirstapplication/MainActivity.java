package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;


public class MainActivity extends AppCompatActivity {
public static final String EXTRA_MESSAGE = "com.example.myfirstapplication.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Called when the user tags the Send button */
    //线性布局
    public void startLinearLayoutV(View view){
        try {
            Intent intent = new Intent(this,LinearLayoutV.class);
            startActivity(intent);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    //表格布局
    public void startTableLayout(View view){
        try {
            Intent intent = new Intent(this, TableLayout.class);
            startActivity(intent);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    //
}
