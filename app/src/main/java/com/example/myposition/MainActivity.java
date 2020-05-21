package com.example.myposition;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.myfirstapplication.R;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends Activity {
    //定位都要通过LocationManager这个类实现
    private String provider;
    private OkHttpClient okHttpClient;
    private LocationManager location;
    @SuppressWarnings("static-access")
    //关闭时解除监听器
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if (location != null) {
            location.removeUpdates(locationListener);
        };
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        ;
        List<String> list = locationManager.getProviders(true);
        if (list.contains(LocationManager.GPS_PROVIDER)) {
            //是否为GPS位置控制器
            provider = LocationManager.GPS_PROVIDER;
        } else if (list.contains(LocationManager.NETWORK_PROVIDER)) {
            //是否为网络位置控制器
            provider = LocationManager.NETWORK_PROVIDER;
        } else {
            return;
        }
        Location location = locationManager.getLastKnownLocation(provider);
        if (location != null) {
            //获取当前位置，这里只用到了经纬度
            String string = provider.toString() + "纬度为：" + location.getLatitude() + ",经度为：" + location.getLongitude();
            Toast.makeText(this, string, Toast.LENGTH_LONG).show();
        }

        //绑定定位事件，监听位置是否改变
        //第一个参数为控制器类型第二个参数为监听位置变化的时间间隔（单位：毫秒）
        //第三个参数为位置变化的间隔（单位：米）第四个参数为位置监听器
        locationManager.requestLocationUpdates(provider, 2000, 2, locationListener);
    }

    LocationListener locationListener = new LocationListener() {

        @Override
        public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
            // TODO Auto-generated method stub
            Toast.makeText(getApplicationContext(),"onStatusChanged",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onProviderEnabled(String arg0) {
            // TODO Auto-generated method stub
            Toast.makeText(getApplicationContext(),"触发onProviderEnabled事件",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onProviderDisabled(String arg0) {
            // TODO Auto-generated method stub
            Toast.makeText(getApplicationContext(),"触发onProviderDisabled事件",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onLocationChanged(Location arg0) {
            // TODO Auto-generated method stub
            // 更新当前经纬度
            // TODO Auto-generated method stub
            // 更新当前经纬度
            Toast.makeText(getApplicationContext(), "经纬度改变", Toast.LENGTH_LONG).show();
            LocationManager locationManager =  (LocationManager) getSystemService(Context.LOCATION_SERVICE);;
            List<String> list = locationManager.getProviders(true);
            if (list.contains(LocationManager.GPS_PROVIDER)) {
                //是否为GPS位置控制器
                provider = LocationManager.GPS_PROVIDER;
            }
            else if (list.contains(LocationManager.NETWORK_PROVIDER)) {
                //是否为网络位置控制器
                provider = LocationManager.NETWORK_PROVIDER;
            } else {
                return ;
            }
            Location location = locationManager.getLastKnownLocation(provider);
            String sql = " INSERT INTO `velocity`.`position`(`user`, `xpos`, `ypos`) VALUES ('lgana'"+','+location.getLongitude()+','+location.getLatitude()+")";
            Toast.makeText(getApplicationContext(),sql,Toast.LENGTH_LONG).show();
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10,TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .build();
            //post方式提交的数据
            FormBody formBody = new FormBody.Builder()
                    .add("sql", sql)
                    .build();
            final Request request = new Request.Builder()
                    .url("https://www.mathjjulgana.xyz:8090/data/operateOne")//请求的url
                    .post(formBody)
                    .build();
            //创建/Call
            Call call = okHttpClient.newCall(request);
            //加入队列 异步操作
            call.enqueue(new Callback() {
                //请求错误回调方法
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if(response.code()==200) {
                        //Toast.makeText(getApplicationContext(),"已成功插入",Toast.LENGTH_LONG).show();
                    }
                };
                @Override
                public void onFailure(Call call, IOException e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }
    };

    public void startposition(View view) {
        // TODO Auto-generated method stub
        // 更新当前经纬度
        // Toast.makeText(this,"123",Toast.LENGTH_LONG).show();
        LocationManager locationManager =  (LocationManager) getSystemService(Context.LOCATION_SERVICE);;
        List<String> list = locationManager.getProviders(true);
        if (list.contains(LocationManager.GPS_PROVIDER)) {
            //是否为GPS位置控制器
            provider = LocationManager.GPS_PROVIDER;
        }
        else if (list.contains(LocationManager.NETWORK_PROVIDER)) {
            //是否为网络位置控制器
            provider = LocationManager.NETWORK_PROVIDER;
        } else {
            return ;
        }
        Location location = locationManager.getLastKnownLocation(provider);
        String sql = " INSERT INTO `velocity`.`position`(`user`, `xpos`, `ypos`) VALUES ('lgana'"+','+location.getLongitude()+','+location.getLatitude()+")";

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        //post方式提交的数据
        FormBody formBody = new FormBody.Builder()
                .add("sql", sql)
                .build();
        final Request request = new Request.Builder()
                .url("https://www.mathjjulgana.xyz:8090/data/operateOne")//请求的url
                .post(formBody)
                .build();
        //创建/Call
        Call call = okHttpClient.newCall(request);
        //加入队列 异步操作
        call.enqueue(new Callback() {
            //请求错误回调方法
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.code()==200) {
//                   Toast.makeText(getApplicationContext(),new Date().toString(),Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call call, IOException e){

            }
        });
    }

}
