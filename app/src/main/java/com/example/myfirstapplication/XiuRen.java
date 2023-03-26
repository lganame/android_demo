package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class XiuRen extends AppCompatActivity {
    private WebView webView;
    private SwipeRefreshLayout swipeRefresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operate_data);
        initView();

    }
    private void initView(){
        String url= (String)getIntent().getExtras().get("url");
        //获得控件
        /*webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webView.loadUrl(url);
        //系统默认会通过手机浏览器打开网页，为了能够直接通过WebView显示网页，则必须设置
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //使用WebView加载显示url
                view.loadUrl(url);
                //返回true
                return true;
            }
        });*/
        View view = this.getLayoutInflater().inflate(R.layout.xiuren, null);

        //SwipeRefresh
        swipeRefresh = (SwipeRefreshLayout)view.findViewById(R.id.swipe_contain);
        //设置触发下拉刷新的距离
        swipeRefresh.setDistanceToTriggerSync(300);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //重新加载刷新页面
                Toast.makeText(XiuRen.this,"刷新页面中",Toast.LENGTH_LONG).show();
                webView.loadUrl(webView.getUrl());
            }
        });
        //首次启动刷新页面
        swipeRefresh.post(new Runnable() {
            @Override
            public void run() {
                swipeRefresh.setRefreshing(true);
                webView.loadUrl(webView.getUrl());
            }
        });
        swipeRefresh.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light);

        //WebView
        webView = (WebView)findViewById(R.id.webview);
        webView.loadUrl(url);
        //添加javaScript支持
        webView.getSettings().setJavaScriptEnabled(true);
        //取消滚动条
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        //触摸焦点起作用
        webView.requestFocus();
        //点击链接继续在当前browser中响应
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //设置进度条
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress == 100){
                    //隐藏进度条
                    swipeRefresh.setRefreshing(false);
                }else if(!swipeRefresh.isRefreshing()){
                    swipeRefresh.setRefreshing(true);
                }
            }
        });

    }
    /**
     * 使点击回退按钮不会直接退出整个应用程序而是返回上一个页面
     *
     * */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()){
            webView.goBack();//返回上个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);//退出整个应用程序
    }
    protected void onDestroy() {
        super.onDestroy();
        //清空所有Cookie
        // CookieSyncManager.createInstance(QzmobileApp.getContext());  //Create a singleton CookieSyncManager within a context
        CookieManager cookieManager = CookieManager.getInstance(); // the singleton CookieManager instance
        cookieManager.removeAllCookie();// Removes all cookies.
        CookieSyncManager.getInstance().sync(); // forces sync manager to sync now
        try {
            webView.setWebChromeClient(null);
            webView.setWebViewClient(null);
            webView.getSettings().setJavaScriptEnabled(false);
            webView.clearCache(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
