package com.example.flowz.sharedpreferencesapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.RemoteControlClient;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button signIn,logIn;
   private EditText userName, password;
   public static final String MYPREFERENCE = "MyPrefs";
   public static final String name = "nameKey";
   public static final String pass = "passwordKey";
   SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName =(EditText)findViewById(R.id.enteredName);
        password =(EditText)findViewById(R.id.enteredPassword);
    }

    @Override
    protected void onResume() {
        sharedPreferences = getSharedPreferences(MYPREFERENCE,Context.MODE_PRIVATE);
        if (sharedPreferences.contains(name)){
            if (sharedPreferences.contains(pass)){
                Intent open = new Intent(this, WelcomeActivity.class);
                startActivity(open);
        }
        }
        super.onResume();
    }
    public void login (View view){
        Editor editor = sharedPreferences.edit();
        String u = userName.getText().toString();
        String p = password.getText().toString();
        editor.putString(name,u);
        editor.putString(pass,p);
        editor.commit();
        Intent open = new Intent(this, WelcomeActivity.class);
        startActivity(open);
    }
}
