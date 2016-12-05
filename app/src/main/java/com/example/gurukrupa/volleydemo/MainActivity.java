package com.example.gurukrupa.volleydemo;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.nfc.Tag;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.gurukrupa.volleydemo.Utility.Api;
import com.example.gurukrupa.volleydemo.Utility.CheckInternetConnection;
import com.example.gurukrupa.volleydemo.Utility.Logs;
import com.example.gurukrupa.volleydemo.Utility.Utilities;
import com.example.gurukrupa.volleydemo.volly.VolleyJsonParserWihoutDialog;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public String TAG = MainActivity.class.getSimpleName();
    public CheckInternetConnection chkNet;
    private Context context;
    int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        chkNet = new CheckInternetConnection(context);
        context =  MainActivity.this;

        if (chkNet.checkInternet()) {
            getRadius();
        } else {
            Utilities.showAlertDialog(context, getString(R.string.nointernet));
        }


        if (checkAndRequestPermissions()) {
            // Call the camera or your reqwairment permission allow here
        } else {

        }
    }

    private void getRadius() {

        //String loginId = singleton.getUserDetail().getId();
        HashMap<String, String> params = new HashMap<>();
        params.put("id", "2");
        params.put("id", "2");
        VolleyJsonParserWihoutDialog volleyJsonParser = new VolleyJsonParserWihoutDialog(context);
       //volleyJsonParser.makeStringReq(Api.TestAPI, params, callGetRadius);
    }


    VolleyJsonParserWihoutDialog.VolleyCallback callGetRadius = new VolleyJsonParserWihoutDialog.VolleyCallback() {
        @Override
        public void onSuccess(String result) {


            Log.d(TAG, "getRadius Result --> " + result);

            try {


                if (result != null) {

                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        String Result = jsonObject.getString("Result");


                        if (Result.equalsIgnoreCase("1")) {


                            JSONObject objectResponse = jsonObject.getJSONObject("Response");
                            //String radiusID = objectResponse.getString(Constants.TAG_id);
                            //pHelper.setRadiusId(context, radiusID);
                            Log.d(TAG,"Responce-->" + objectResponse);
                            Logs.Message("" +objectResponse);



                        } else if (Result.equalsIgnoreCase("0")) {


                        } else if (Result.equalsIgnoreCase("2")) {


                        }


                    } catch (Exception e) {

                        e.printStackTrace();

                    }
                }

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        @Override
        public void onFailure(String jsonResponse) {

            Log.d("TAG", "ERROR ON GET RADIUS");
        }
    };


    private boolean checkAndRequestPermissions() {
        int permissionCoarseLocation = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int permissionFineLocation = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        List<String> listPermissionsNeeded = new ArrayList<>();
        if (permissionFineLocation != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        if (permissionCoarseLocation != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }
}
