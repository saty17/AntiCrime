package com.example.anticrime;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.anticrime.ModelResponse.User;

public class SharedPrefManager {

    private static String SHARED_PREF_NAME="anticrime";
    private static SharedPreferences sharedPreferences;
    static Context context;
    private static SharedPreferences.Editor editor;

    public SharedPrefManager(Context context) {
        this.context = context;
    }

    public void saveUser(User user){

        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt("Id", user.getId());
        editor.putString("UserName", user.getUserName());
        editor.putString("Email",user.getEmail());
        editor.putBoolean("logged",true);
        editor.apply();
        //editor.commit();

    }

    public boolean isLoggedIn(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("logged",false);

    }

    public static User getUser(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new User(sharedPreferences.getInt("Id",-1),sharedPreferences.getString("UserName",null),
                sharedPreferences.getString("Email",null));

    }
    public  static void setUser(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.putString("UserName", null);
        editor.commit();

    }

    public void logout(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
