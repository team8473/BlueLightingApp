package com.example.wahle.stuff;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CurveActivity extends AppCompatActivity {

    EditText direction, speed, angle, radius;
    TextView tv;
    Path path = new Path();
    double leftDistance, rightDistance, leftSpeed, rightSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curve);
        direction = findViewById(R.id.direction);
        speed = findViewById(R.id.speed);
        angle = findViewById(R.id.angle);
        radius = findViewById(R.id.radius);
        Button b = findViewById(R.id.calculate2);
        Button a = findViewById(R.id.back2);
        tv= findViewById(R.id.textView2);
        tv.setMovementMethod(new ScrollingMovementMethod());

        b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String str = direction.getText().toString();

                String speedString = speed.getText().toString();
                Double newSpeed = Double.parseDouble(speedString);

                String angleString = angle.getText().toString();
                Double newAngle = Double.parseDouble(angleString);

                String radiusString = radius.getText().toString();
                Double newRadius = Double.parseDouble(radiusString);

                if(str.equals("Right") || str.equals("right") || str.equals("RIGHT")){
                    double distance = path.convertDistance(newAngle, newRadius);

                    double innerScale = path.innerScale(newRadius);

                    rightDistance = (distance * Math.abs(innerScale));
                    rightSpeed = (newSpeed * innerScale);
                    leftDistance = (distance);
                    leftSpeed = (newSpeed);

                    tv.setText(" Right Distance : " + rightDistance + "\n Right Speed : " + rightSpeed +
                            "\n Left Distance : " + leftDistance + "\n Left Speed : " + leftSpeed);
                }
                else if(str.equals("Left") || str.equals("left") || str.equals("LEFT")){
                    double distance = path.convertDistance(newAngle, newRadius);

                    double innerScale = path.innerScale(newRadius);

                    leftDistance = (distance * Math.abs(innerScale));
                    leftSpeed = (newSpeed * innerScale);
                    rightDistance = (distance);
                    rightSpeed = (newSpeed);

                    tv.setText(" Right Distance : " + rightDistance + "\n Right Speed : " + rightSpeed +
                            "\n Left Distance : " + leftDistance + "\n Left Speed : " + leftSpeed);
                }
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