package com.example.wahle.stuff;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class FirstPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        Button b = findViewById(R.id.curveTurn);
        Button a = findViewById(R.id.encoderInches);
        Button c = findViewById(R.id.test);

        a.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                goToEncoderInches();
    }
});
        c.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                goToTest();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                goToCurveTurn();
    }
});

    }

    private void goToEncoderInches() {

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }
    private void goToCurveTurn() {

        Intent intent = new Intent(this, CurveActivity.class);

        startActivity(intent);

    }
    private void goToTest() {

        Intent intent = new Intent(this, TestActivity.class);

        startActivity(intent);
    }
}