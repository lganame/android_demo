package com.example.myfirstapplication;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

public class WebViewActivity extends AppCompatActivity {
    EditText url;
    WebView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        show= findViewById(R.id.show);
        show.loadUrl("http://baidu.com");
    }
}
