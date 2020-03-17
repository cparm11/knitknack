package com.example.knitknackapp.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.knitknackapp.R;

public class CounterView extends AppCompatActivity {
    Button Plus;
    Button Minus;
    TextView counter_text;
    int counter = 0;

    //@SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter_view);

        Plus = findViewById(R.id.plus);
        Minus = findViewById(R.id.minus);
        counter_text = findViewById(R.id.counter);


        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                counter_text.setText(Integer.toString(counter));
            }
        });
        Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                counter_text.setText(Integer.toString(counter));
            }
        });

    }


}
