package com.example.wahle.stuff;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    Path path = new Path();
    String newXString, newYString, newRadius, newSpeed;
    Path hi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        final EditText x = findViewById(R.id.x);
        final EditText y = findViewById(R.id.y);
        final EditText r = findViewById(R.id.r);
        final EditText s = findViewById(R.id.s);
        final Button b = findViewById(R.id.button);
        tv = findViewById(R.id.textView3);
        tv.setMovementMethod(new ScrollingMovementMethod());

        b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                String speedString = s.getText().toString();
                Double newSpeed = Double.parseDouble(speedString);

                String xString = x.getText().toString();
                Double newXString = Double.parseDouble(xString);

                String yString = y.getText().toString();
                Double newYString = Double.parseDouble(yString);

                String radiusString = r.getText().toString();
                Double newRadius = Double.parseDouble(radiusString);

                buildPath(newXString, newYString, newRadius, newSpeed);

                tv.setText("Right Distance: " + rightDistance1 +
                        "\n Left Disitance: " + leftDistance1  +
                        "\n Right Distance: " + rightDistance2 +
                        "\n Left Disitance: " + leftDistance2  +
                        "\n Right Distance: " + rightDistance3 +
                        "\n Left Disitance: " + leftDistance3);

            }
        });
    }

    public Path buildPath(Double x, Double y, Double r, Double s) {
        ArrayList<PathBuilder.Waypoint> sWaypoints = new ArrayList();
        sWaypoints.add(new PathBuilder.Waypoint(24,49,0,0));
        sWaypoints.add(new PathBuilder.Waypoint(24,85,10,12));
        sWaypoints.add(new PathBuilder.Waypoint(10,85,0,12));

        return hi = PathBuilder.buildPathFromWaypoints(sWaypoints);
    }
}
