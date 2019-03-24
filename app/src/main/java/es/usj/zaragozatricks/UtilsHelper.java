package es.usj.zaragozatricks;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class UtilsHelper {

    public static SharedPreferences getSharedPreference(Context ctx){
        return ctx.getSharedPreferences("keys", Activity.MODE_PRIVATE);
    }

    public static void setProfileInfo(String id, Context ctx, ArrayList<String> profileInfo ){
        SharedPreferences.Editor editor = getSharedPreference(ctx).edit();
        editor.putString(id,TextUtils.join(",",profileInfo));
        editor.apply();
    }

    public  static ArrayList<String> getProfileInfo(Context ctx, String id){
        SharedPreferences sp = getSharedPreference(ctx);
        return  new ArrayList<String>(Arrays.asList(TextUtils.split(sp.getString(id,""),",")));
    }
}
