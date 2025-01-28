package com.example.bomarshe;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtil {
    public static void clearAllData(Context context, String prefName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
