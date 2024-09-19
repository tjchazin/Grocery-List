package com.zybooks.test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(v -> {
            Intent intent = new Intent(this, FirstActivity.class);
            startActivity(intent);
        });
        Button aboutusbutton = findViewById(R.id.aboutusbutton);
        aboutusbutton.setOnClickListener(v -> {
            Intent intent = new Intent(this, FourthActivity.class);
            startActivity(intent);
        });
    }

}
