package com.zybooks.test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        Button buttonmore = findViewById(R.id.buttonmore);
        buttonmore.setOnClickListener(v -> {
            Intent intent = new Intent(this, FifthActivity.class);
            startActivity(intent);
        });
    }}