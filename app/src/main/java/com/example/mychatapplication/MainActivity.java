package com.example.mychatapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor shEdit;
    public static final String MyPREFERENCES = "MyPrefs";

    Button btn;
    EditText nickname;
    public static String NICKNAME = "usernickname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.enterchat);
        nickname = findViewById(R.id.nickname);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nickname.getText().toString().isEmpty()) {
                    Intent i = new Intent(MainActivity.this, ChatBoxActivity.class);
                    NICKNAME = nickname.getText().toString();
                    setPreference();
                    startActivity(i);
                }

            }
        });
    }

    protected void setPreference(){
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        shEdit = sharedPreferences.edit();
        shEdit.putString("name",NICKNAME);
        shEdit.apply();
    }
}
