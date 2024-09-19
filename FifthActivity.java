package com.zybooks.test;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FifthActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        TextView textView = findViewById(R.id.textView6);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        Button buttonhome = findViewById(R.id.buttonhome);
        buttonhome.setOnClickListener(v -> {
            Intent intent = new Intent(this, IntroActivity.class);
            startActivity(intent);
        });
    }}


