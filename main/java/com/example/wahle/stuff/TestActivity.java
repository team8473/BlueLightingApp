package com.example.wahle.stuff;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        final EditText test = findViewById(R.id.Test);
        final Button b = findViewById(R.id.button);
        tv= findViewById(R.id.textView3);
        tv.setMovementMethod(new ScrollingMovementMethod());

        b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                final String str = test.getText().toString();
                getSwitch(str);

            }
        });
    }

    public String getSwitch(String str) {
        switch (str) {
            case "BLUE" :
                tv.setText("BLUE");
                break;
            case "RED" :
                tv.setText("RED");
                break;
            default:
                tv.setText("\n HI");
        }
        return str;
    }
}
