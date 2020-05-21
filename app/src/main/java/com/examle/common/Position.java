package com.examle.common;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.widget.Toast;

import java.security.Provider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class Position extends Activity {

    public  Map<String,Double> getLocation(){
        Map<String,Double> resultMap = new HashMap<>();
        resultMap.put("xpos",0.0);
        resultMap.put("ypos",0.0);
         String provider;
        //获取定位服务
        //获取当前可用的位置控制器
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
            resultMap.put("error",1.0);
            return resultMap;
        }
        Location location = locationManager.getLastKnownLocation(provider);
        resultMap.put("xpos",location.getLongitude());
        resultMap.put("ypos",location.getLatitude());
        return resultMap;
    }
}
