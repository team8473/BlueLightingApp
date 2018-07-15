package com.example.wahle.stuff;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.wahle.stuff.Path.leftDistance1;
import static com.example.wahle.stuff.Path.leftDistance2;
import static com.example.wahle.stuff.Path.leftDistance3;
import static com.example.wahle.stuff.Path.rightDistance1;
import static com.example.wahle.stuff.Path.rightDistance2;
import static com.example.wahle.stuff.Path.rightDistance3;

public class TestActivity extends AppCompatActivity {

    TextView tv;
    double Test = 0.0;

    public enum Ball {
        IS_RED_BALL, IS_BLUE_BALL
    }
    public static Ball ball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        final Button b = findViewById(R.id.button);
        tv = findViewById(R.id.textView3);
        tv.setMovementMethod(new ScrollingMovementMethod());

        b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (Test == 0.0) {
                    ball = Ball.IS_RED_BALL;
                    buildPath(1, 2, 3, 4);
                    Test += 1.0;
                } else if (Test == 1.0) {
                    ball = Ball.IS_BLUE_BALL;
                    buildPath(2, 3, 4, 5);
                    Test -= 1.0;
                }

                tv.setText("Right Distance: " + rightDistance1 +
                        "\n Left Disitance: " + leftDistance1  +
                        "\n Right Distance: " + rightDistance2 +
                        "\n Left Disitance: " + leftDistance2  +
                        "\n Right Distance: " + rightDistance3 +
                        "\n Left Disitance: " + leftDistance3);
            }
        });
    }

    public Path buildPath(double x, double y, double r, double s) {
        ArrayList<PathBuilder.Waypoint> sWaypoints = new ArrayList();
        sWaypoints.add(new PathBuilder.Waypoint(24,49,0,0));
        sWaypoints.add(new PathBuilder.Waypoint(x, y, r, s));
        sWaypoints.add(new PathBuilder.Waypoint(10,85,0,12));

        return PathBuilder.buildPathFromWaypoints(sWaypoints, "RED");
    }
}
