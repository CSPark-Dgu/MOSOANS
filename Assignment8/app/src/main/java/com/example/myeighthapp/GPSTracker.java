package com.example.myeighthapp;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;

import androidx.core.app.ActivityCompat;

public class GPSTracker extends Service implements LocationListener {   //NEW -> Service

    private final Context myContext;
    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;
    boolean canGetGPSINFO = false;

    Location myLocation;
    double latitude;
    double longitude;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; //10 meters
    private static final long MIN_TIME_BW_UPDATES = 30000; //30 seconds
    protected LocationManager myLocationManager;

    public GPSTracker(Context context) {
        myContext = context;
        getLocation();
    }

    /*
    GPS 정보 -> 기기의 GPS 센서로부터 정보 획득
    만약에 GPS가 안되는 곳이라면? -> 주변 네트워크 기지국 위치를 통해 간접적으로 GPS 위치 정보를 획득
     */
    public Location getLocation() {
        try {
            myLocationManager = (LocationManager) myContext.getSystemService(LOCATION_SERVICE);
            isGPSEnabled = myLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkEnabled = myLocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNetworkEnabled) {
                //do nothing
            } else {
                this.canGetGPSINFO = true;
                if (isNetworkEnabled) {
                    if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED){
                        myLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                                MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        if (myLocation != null) {
                            latitude = myLocation.getLatitude();
                            longitude = myLocation.getLongitude();
                        }
                    }
                }
                if (isGPSEnabled) {
                    if (myLocation != null) {
                        myLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        if (myLocationManager != null) {
                            myLocation = myLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (myLocation != null) {
                                latitude = myLocation.getLatitude();
                                longitude = myLocation.getLongitude();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myLocation;
    }

    public void stopUsingGPS() {
        if (myLocation != null) {
            myLocationManager.removeUpdates(GPSTracker.this);
        }
    }

    public double getLatitude() {
        if (myLocation != null) {
            latitude = myLocation.getLatitude();
        }
        return latitude;
    }

    public double getLongitude() {
        if (myLocation != null) {
            longitude = myLocation.getLongitude();
        }
        return longitude;
    }

    public boolean canGetLocation() {
        return this.canGetGPSINFO;
    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(myContext);
        alertDialog.setTitle("GPS는 설정중입니다.");
        alertDialog.setMessage("GPS는 활성화되지 않았습니다. 설정창으로 이동하시겠습니까?");
        alertDialog.setPositiveButton("설정", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                myContext.startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel(); //다이얼로그 취소
            }
        });
        alertDialog.show();
    }

    @Override
    public void onLocationChanged(Location location){

    }

    @Override
    public void onProviderEnabled(String provider){

    }

    public void onStatusChanged(String provider, int status, Bundle extras){

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}