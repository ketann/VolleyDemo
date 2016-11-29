package com.example.gurukrupa.volleydemo.Utility;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.example.gurukrupa.volleydemo.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Utilities {

    // display alert dilaog in app any where
    public static void showAlertDialog(Context context, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.app_name);
        builder.setMessage(message);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();

    }

    // display alert Toast in app any where
    public static void showToast(Context context, String message) {
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }


    public static boolean isClassRunning(Context context, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager
                .getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }


    // for check internet connenction
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    // For change Date Format
    public static String convertToUKformat(String date) {
        String finaldate = null;
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = fmt.parse(date);
            SimpleDateFormat fmtOut = new SimpleDateFormat("dd-MMM-yyyy");
            finaldate = fmtOut.format(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return finaldate;

    }

    // change date format
    public static String convertFormat(String date) throws ParseException {

        DateFormat writeFormat = new SimpleDateFormat("dd MMM yy, K:mm aa");

        Date date2 = null;
        date2 = stringToDate(date);
        // date = readFormat.parse(dateStr);

        String formattedDate = "";
        if (date2 != null) {
            formattedDate = writeFormat.format(date2);
        }

        System.out.println(formattedDate);

        return formattedDate;

    }


    // convert string to Date Format
    public static Date stringToDate(String stDate) {

        // String dateString = "03/26/2012 11:49:00 AM";
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");

        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(stDate);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        System.out.println(convertedDate);
        return convertedDate;

    }

    public static Date stringToDatekkMM(String stDate) {

        // String dateString = "03/26/2012 11:49:00 AM";
        SimpleDateFormat dateFormat = new SimpleDateFormat("kk:mm");

        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(stDate);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        System.out.println(convertedDate);
        return convertedDate;

    }


    public static String convertTimeAMPM(String date) {


        String finaldate = null;
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = fmt.parse(date);
            SimpleDateFormat fmtOut = new SimpleDateFormat("HH:mm aa");
            finaldate = fmtOut.format(date1);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return finaldate;

    }


    //convert string date format to api date format
    public static String convertToAPIformat(String date) {
        String finaldate = null;
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
            Date date1 = fmt.parse(date);
            SimpleDateFormat fmtOut = new SimpleDateFormat("yyyy-MM-dd");
            finaldate = fmtOut.format(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return finaldate;

    }

    // for Check string is empty or not
    public static boolean isStringEmpty(String s) {

        if (s.length() == 0 || s == null || s.equals("") || s.equals(" ")) {
            return true;

        } else {
            return false;

        }

    }

    //  it return current date
    public static String getCurrentDate() {

        String currentDate = null;
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            currentDate = df.format(c.getTime());
        } catch (Exception e) {
        }
        return currentDate;

    }


    // json convert to ArrayList
    public static ArrayList<Integer> getUserArrayListFromJson(String usersJsonArray) {


        ArrayList<Integer> arrayListUserTemp = new ArrayList<Integer>();

        try {

            JSONObject rootObj = new JSONObject(usersJsonArray);
            JSONArray arrUserPos = rootObj.getJSONArray("usersPosition");

            if (arrUserPos != null) {
                for (int i = 0; i < arrUserPos.length(); i++) {
                    arrayListUserTemp.add(Integer.parseInt(arrUserPos.get(i).toString()));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return arrayListUserTemp;
    }


    public static void getKeywordArrayListFromJsonArray() {

    }

    public static String getJsonArrayFromKeywordArrayList(ArrayList<String> arrayList_keywords) {

        String strKeywordsSArray = "";

        try {

            JSONObject json = new JSONObject();
            json.put("keywords", new JSONArray(arrayList_keywords));
            strKeywordsSArray = json.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return strKeywordsSArray;

    }

    public static Bitmap blur(Bitmap image, Context context) {

        if (null == image)
            return null;

        final float BITMAP_SCALE = 0.4f;
        final float BLUR_RADIUS = 15f;

        int width = Math.round(image.getWidth() * BITMAP_SCALE);
        int height = Math.round(image.getHeight() * BITMAP_SCALE);

        Bitmap inputBitmap = Bitmap.createScaledBitmap(image, width, height, false);
        Bitmap outputBitmap = Bitmap.createBitmap(inputBitmap);

        RenderScript rs = RenderScript.create(context);
        ScriptIntrinsicBlur theIntrinsic = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        Allocation tmpIn = Allocation.createFromBitmap(rs, inputBitmap);
        Allocation tmpOut = Allocation.createFromBitmap(rs, outputBitmap);
        theIntrinsic.setRadius(BLUR_RADIUS);
        theIntrinsic.setInput(tmpIn);
        theIntrinsic.forEach(tmpOut);
        tmpOut.copyTo(outputBitmap);

        return outputBitmap;
    }


    public static Bitmap getBitmapFromURL(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static int timeDifference(String fromDate, String toDate) {

        int Hours = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date Date1 = format.parse(fromDate);
            Date Date2 = format.parse(toDate);

            long mills = Date2.getTime() - Date1.getTime();
            Log.v("Data1", "" + Date1.getTime());
            Log.v("Data2", "" + Date2.getTime());
            Hours = (int) (mills / (1000 * 60 * 60));
            int Mins = (int) (mills / (1000 * 60)) % 60;
            long Secs = (int) (mills / 1000) % 60;

            String diff = Hours + ":" + Mins + ":" + Secs;
            Log.d("TAG", "Difference in hour---->" + Hours);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return Hours;
    }

    public static String splitFromTime(String fromDate) {
        String[] from_date_time = null;
        from_date_time = fromDate.split(" ");
        String Date_str = from_date_time[0];
        String form_Time_str = from_date_time[1];

        Log.e("TAG", "Time_str--> " + form_Time_str);

        String[] time = null;
        time = form_Time_str.split(":");
        String hours = time[0];
        String min = time[1];
        String sec = time[2];
        Log.e("TAG", "Time_str--> " + hours);

        String finalString = hours + ":" + min;

        return finalString;
    }

    public static String splitToTime(String toDate) {
        String[] from_date_time = null;
        from_date_time = toDate.split(" ");
        String Date_str = from_date_time[0];
        String form_Time_str = from_date_time[1];


        String[] time = null;
        time = form_Time_str.split(":");
        String hours = time[0];
        String min = time[1];
        String sec = time[2];
        Log.e("TAG", "Time_str--> " + hours);

        String finalString = hours + ":" + min;

        return finalString;
    }


    public static String convertArrayListToCommaSaperte(ArrayList<Integer> list) {

        String finalString = "";

        finalString = android.text.TextUtils.join(",", list);

        return finalString;

    }


    public static String convertArrayListToCommaSaperteString(ArrayList<String> list) {

        String finalString = "";

        finalString = android.text.TextUtils.join(",", list);

        return finalString;

    }


    public static boolean isAppIsInBackground(Context context) {
        boolean isInBackground = true;
        ActivityManager am = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            List<ActivityManager.RunningAppProcessInfo> runningProcesses = am
                    .getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo processInfo : runningProcesses) {
                if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    for (String activeProcess : processInfo.pkgList) {
                        if (activeProcess.equals(context.getPackageName())) {
                            isInBackground = false;
                        }
                    }
                }
            }
        } else {
            List<ActivityManager.RunningTaskInfo> taskInfo = am
                    .getRunningTasks(1);
            ComponentName componentInfo = taskInfo.get(0).topActivity;
            if (componentInfo.getPackageName().equals(context.getPackageName())) {
                isInBackground = false;
            }
        }

        return isInBackground;
    }


    public static boolean isGPSEnable(Context context, LocationManager locationManager) {

        boolean isGPSEnable = false;

        isGPSEnable = locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER);


        return isGPSEnable;

    }


    public static boolean isNetworkEnable(Context context, LocationManager locationManager) {

        boolean isNetworkEnable = false;


        // Getting network status
        isNetworkEnable = locationManager
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER);


        return isNetworkEnable;


    }

    public static boolean CheckDates(String startDate, String endDate) {

        boolean IsDateIsGreterFromTodayDate = false;

        SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if (dfDate.parse(startDate).after(dfDate.parse(endDate))) {
                IsDateIsGreterFromTodayDate = true;  // If start date is before end date.
            } else if (dfDate.parse(startDate).equals(dfDate.parse(endDate))) {
                IsDateIsGreterFromTodayDate = true;  // If two dates are equal.
            } else {
                IsDateIsGreterFromTodayDate = false; // If start date is after the end date.
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return IsDateIsGreterFromTodayDate;
    }


}
