package com.example.myposition;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.myfirstapplication.R;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
public static final String EXTRA_MESSAGE = "com.example.myfirstapplication.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startposition(View view){
        System.out.println(new Date().toString());
        System.out.println("Log.DEBUG"+Log.DEBUG);
   }

}
