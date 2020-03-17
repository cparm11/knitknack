package com.example.knitknackapp.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.io.BufferedWriter;
import java.io.FileWriter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knitknackapp.R;
import com.example.knitknackapp.RecyclerView.MyAdapter;

public class CurrentProject extends AppCompatActivity {
    Button Plus;
    Button Minus;
    TextView counter_text;
    TextView displayProject;
    int counter = 0;

    String name;

    String[] myDataset;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_project);

      /*  Plus = (Button) findViewById(R.id.plus);
        Minus = (Button) findViewById(R.id.minus);
        counter_text = findViewById(R.id.counter);
      */ // displayProject = findViewById(R.id.title_bar2);

        RecyclerView recyclerView = findViewById(R.id.counter_list);
       // RecyclerView recyclerView = new RecyclerView(this);
        RecyclerView.Adapter mAdapter;
        LinearLayoutManager layoutManager;

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);

        //read from file about project
        Intent intent = getIntent();
        String projectName = intent.getStringExtra("fileName");
        String type;
        String date;
        String num;

       // displayProject.setText(projectName);

        try {
            assert projectName != null;
            String fileName = projectName.concat(".txt");
            File file = new File(fileName);
            BufferedReader fIn = new BufferedReader(new FileReader(file));

            name = fIn.readLine();
            type = fIn.readLine();
            date = fIn.readLine();
            num = fIn.readLine();

            //set view
            displayProject.setText(name);
            counter_text.setText(num);
            counter = Integer.parseInt(num);

        } catch (IOException e) {
            e.printStackTrace();
        }




//—set on click listeners on the buttons—–
      /*  Plus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                counter++;
                counter_text.setText(Integer.toString(counter));
            }
        });
        Minus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                counter--;
                counter_text.setText(Integer.toString(counter));
            }
        });
*/
       /* Button add = findViewById(R.id.add_counter);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               // LinearLayout new_counter = findViewById(R.id.NEWcounter);
               // LL.addView(new_counter);
            }
        });*/
    }

    //when closing
    /*protected void onStop() {
        try {
            BufferedWriter fOut = new BufferedWriter(new FileWriter(name));

        } catch (IOException e) {
            e.printStackTrace();
        }

        super.onStop();
    }*/
}
