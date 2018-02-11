package com.example.wahle.stuff;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static final double     COUNTS_PER_MOTOR_REV    = 374 ;
    public static final double     DRIVE_GEAR_REDUCTION    = 2.0 ;
    public static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;
    public static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
                                                             (WHEEL_DIAMETER_INCHES * Math.PI);


    EditText rightEncoder, leftEncoder;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.click);
        Button a = findViewById(R.id.back1);
        tv= findViewById(R.id.textView);
        tv.setMovementMethod(new ScrollingMovementMethod());

        b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                rightEncoder = findViewById(R.id.rightEncoder);
                String rightString = rightEncoder.getText().toString();
                Double right = Double.parseDouble(rightString);
                double newRightValue = (right/ COUNTS_PER_INCH);

                leftEncoder = findViewById(R.id.leftEncoder);
                String leftString = leftEncoder.getText().toString();
                Double left = Double.parseDouble(leftString);
                double newLeftValue = (left / COUNTS_PER_INCH);

                tv.setText("Right Inches : \n" + newRightValue + "\n Left Inches : \n" + newLeftValue);
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v){
                goToFirstPage();
            }
        });
    }
    private void goToFirstPage(){
        Intent intent = new Intent(this, FirstPageActivity.class);

        startActivity(intent);
    }
}