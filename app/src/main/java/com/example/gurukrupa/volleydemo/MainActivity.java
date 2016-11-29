package com.example.gurukrupa.volleydemo;

import android.content.Context;
import android.nfc.Tag;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.gurukrupa.volleydemo.Utility.Api;
import com.example.gurukrupa.volleydemo.Utility.CheckInternetConnection;
import com.example.gurukrupa.volleydemo.Utility.Utilities;
import com.example.gurukrupa.volleydemo.volly.VolleyJsonParserWihoutDialog;

import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public String TAG = MainActivity.class.getSimpleName();
    public CheckInternetConnection chkNet;
    private Context context;
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
    }

    private void getRadius() {

        //String loginId = singleton.getUserDetail().getId();
        HashMap<String, String> params = new HashMap<>();
        params.put("id", "2");
        params.put("id", "2");
        VolleyJsonParserWihoutDialog volleyJsonParser = new VolleyJsonParserWihoutDialog(context);
        volleyJsonParser.makeStringReq(Api.Get_Radius, params, callGetRadius);
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
}
