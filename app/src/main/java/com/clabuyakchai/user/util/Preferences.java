package com.clabuyakchai.user.util;

import android.content.Context;
import android.preference.PreferenceManager;

public abstract class Preferences {
    private static final String PREF_TOKEN = "pref_token";

    public static String getTokenSharedPreferences(Context context){
        return PreferenceManager
                .getDefaultSharedPreferences(context)
                .getString(PREF_TOKEN, null);
    }

    public static void setTokenSharedPreferences(Context context, String token){
        PreferenceManager
                .getDefaultSharedPreferences(context)
                .edit()
                .putString(PREF_TOKEN, token)
                .apply();
    }
}
