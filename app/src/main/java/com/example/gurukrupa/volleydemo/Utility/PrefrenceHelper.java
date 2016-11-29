package com.example.gurukrupa.volleydemo.Utility;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefrenceHelper {

    //This variables are required for whole application
    public static final String KEY_ACTIVE_PREF = "myPref";
    public static final String KEY_CURRENTCHOICERADIUS = "currentChoiceRadius";
    public static final String KEY_CURRENTCHOICERADIUSONE = "currentChoiceRadiusOne";
    public static final String KEY_ISPROXYENABLE = "proxyenable";
    public static final String KEY_PROFILE_PIC_PATH = "profile_pic_path";
    public static final String KEY_PROFILE_FB = "profile_pic_from_fb";
    public static final String KEY_REDIUS_ID = "radius_id";
    public static final String KEY_FIRSTTIME_STRANGER = "first_time_strangers";
    public static final String KEY_LOGIN_ID = "login_id";
    public static final String KEY_REDIUS_ID_ONE = "radius_one_id";
    public static final String KEY_BACKGROUND_POSITION = "background_position";
    public static final String KEY_SIGN_IN = "KeepLoggedIn";
    public static final String KEY_GCM_TOKEN = "gcm_token";


    Context context;
    SharedPreferences sharedPreferences;

    /**
     * @param context
     * @param radius
     */

    public PrefrenceHelper(Context context) {
        this.context = context;
    }

    // for set current radius
    public void setCurrentRadius(Context context, String radius) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_CURRENTCHOICERADIUS, radius);

        editor.commit();

    }


    public void setRadiusId(Context context, String radiusID) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_REDIUS_ID, radiusID);

        editor.commit();

    }


    public void setFirstTimeStrangerDisplay(Context context, boolean flag) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_FIRSTTIME_STRANGER, flag);
        editor.commit();

    }

    /**
     * @param context
     * @return
     */

    // for save visibilit status
    public boolean getFirstTimeStrangerDisplay(Context context) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        boolean isFirstTimeStrangerDisplay = sharedPreferences.getBoolean(KEY_FIRSTTIME_STRANGER, false);

        return isFirstTimeStrangerDisplay;

    }


    /**
     * @param context
     * @return
     */

    // for get current radius
    public String getCurrentRadius(Context context) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        String size = sharedPreferences.getString(KEY_CURRENTCHOICERADIUS, "100");

        return size;

    }


    public String getRadiusId(Context context) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        String size = sharedPreferences.getString(KEY_REDIUS_ID, "1");

        return size;

    }

    /**
     * @param context
     * @param flag
     */
    // for set visibility status
    public void setIsVisiable(Context context, boolean flag) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_ISPROXYENABLE, flag);
        editor.commit();

    }

    /**
     * @param context
     * @return
     */

    // for save visibilit status
    public boolean isVisiable(Context context) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        boolean isVisiable = sharedPreferences.getBoolean(KEY_ISPROXYENABLE, false);

        return isVisiable;

    }

    /**
     * @param context
     * @param path
     * @param username
     */

    // for set profile pic
    public void setProfilePic(Context context, String path, String username) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_PROFILE_PIC_PATH + username, path);

        editor.commit();

    }

    /**
     * @param context
     * @param username
     * @return
     */
    // for getprofile pic
    public String getProfilePic(Context context, String username) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        String path = sharedPreferences.getString(KEY_PROFILE_PIC_PATH + username, "");

        return path;

    }


    // for set login Id
    public void setLoginId(Context context, String loginId) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_LOGIN_ID, loginId);

        editor.commit();

    }

    /**
     * @param context
     * @param username
     * @return
     */
    // for getprofile pic
    public String getLoginId(Context context) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        String path = sharedPreferences.getString(KEY_LOGIN_ID, "");

        return path;

    }


    //login detail

    String KEY_fbid = "fb_id";
    String KEY_email = "fb_email";
    String KEY_username = "fb_username";
    String KEY_firstname = "fb_firstname";
    String KEY_lastname = "fb_lastname";
    String KEY_gender = "fb_gender";
    String KEY_imagePath = "fb_imagepath";
    String KEY_latitude = "latitude";
    String KEY_longitude = "longitude";


    public String getFbid() {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        String fbid = sharedPreferences.getString(KEY_fbid, "");

        return fbid;

    }

    public void setFbid(String fbid) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_fbid, fbid);

        editor.commit();

    }

    public String getEmail() {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        String Email = sharedPreferences.getString(KEY_email, "");

        return Email;
    }

    public void setEmail(String email) {
        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_email, email);

        editor.commit();
    }

    public String getUsername() {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        String Username = sharedPreferences.getString(KEY_username, "");

        return Username;
    }

    public void setUsername(String username) {
        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_username, username);

        editor.commit();
    }

    public String getFirstname() {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        String Firstname = sharedPreferences.getString(KEY_firstname, "");

        return Firstname;
    }

    public void setFirstname(String firstname) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_firstname, firstname);
        editor.commit();
    }

    public String getLastname() {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        String Lastname = sharedPreferences.getString(KEY_lastname, "");

        return Lastname;
    }

    public void setLastname(String lastname) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_lastname, lastname);

        editor.commit();
    }

    public String getGender() {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        String Gender = sharedPreferences.getString(KEY_gender, "");

        return Gender;
    }

    public void setGender(String gender) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_gender, gender);

        editor.commit();
    }

    public String getImagePath() {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        String ImagePath = sharedPreferences.getString(KEY_imagePath, "");

        return ImagePath;
    }

    public void setImagePath(String imagePath) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_imagePath, imagePath);
        editor.commit();
    }


    public void setLatitude(String firstname) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_latitude, firstname);
        editor.commit();
    }

    public String getLatitude() {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        String Lastname = sharedPreferences.getString(KEY_latitude, "");

        return Lastname;
    }


    public void setLongitude(String firstname) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_longitude, firstname);
        editor.commit();
    }

    public String getLongitude() {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        String Lastname = sharedPreferences.getString(KEY_longitude, "");

        return Lastname;
    }


    public void setBackgroundPosition(int position) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_BACKGROUND_POSITION, position);
        editor.commit();
    }

    public int getBackgroundPosition() {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        int position = sharedPreferences.getInt(KEY_BACKGROUND_POSITION, 0);

        return position;
    }


    public void setSignIn(Context context, boolean flag) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_SIGN_IN, flag);
        editor.commit();

    }

    /**
     * @param context
     * @return
     */

    // for save visibilit status
    public boolean isSignIn(Context context) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        boolean isSignIn = sharedPreferences.getBoolean(KEY_SIGN_IN, false);

        return isSignIn;

    }


    public String getRadius_One_ID(Context context) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        String size = sharedPreferences.getString(KEY_REDIUS_ID_ONE, "1");

        return size;

    }


    public void setRadiusId_One(Context context, String radiusID) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_REDIUS_ID_ONE, radiusID);

        editor.commit();

    }


    public void setCurrentRadiusOne(Context context, String radiusone) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_CURRENTCHOICERADIUSONE, radiusone);

        editor.commit();

    }


    public String getGCMToken(Context context) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);
        String token = sharedPreferences.getString(KEY_GCM_TOKEN, "");

        return token;

    }


    public void setGCMToken(Context context, String token) {

        sharedPreferences = context.getSharedPreferences(KEY_ACTIVE_PREF,
                context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_GCM_TOKEN, token);

        editor.commit();

    }

}
