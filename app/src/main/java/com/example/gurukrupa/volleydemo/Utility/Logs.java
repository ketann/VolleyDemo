package com.example.gurukrupa.volleydemo.Utility;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by GURUKRUPA on 12/5/2016.
 */

public class Logs {

    public static void Message (String message)
    {
        Log.d("Volley Dmoe", message);
    }

    public static void ToastMessage(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
