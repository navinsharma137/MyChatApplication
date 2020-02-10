package com.example.mychatapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText nickname;
    public static final String NICKNAME = "usernickname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.enterchat);
        nickname = findViewById(R.id.nickname);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nickname.getText().toString().isEmpty()){
                    Intent i = new Intent(MainActivity.this,ChatBoxActivity.class);
                    i.putExtra(NICKNAME,nickname.getText().toString());
                    startActivity(i);
                }

            }
        });
    }
}
