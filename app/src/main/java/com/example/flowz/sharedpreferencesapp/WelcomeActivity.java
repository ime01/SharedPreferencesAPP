package com.example.flowz.sharedpreferencesapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }
    public  void logout (View view){
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.MYPREFERENCE, Context.MODE_PRIVATE);
        Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        moveTaskToBack(true);
        WelcomeActivity.this.finish();
    }
    public void exit(View view){
        moveTaskToBack(true);
        WelcomeActivity.this.finish();
    }

}
