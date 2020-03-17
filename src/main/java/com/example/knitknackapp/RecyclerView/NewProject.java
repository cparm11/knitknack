package com.example.knitknackapp.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.knitknackapp.R;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NewProject extends AppCompatActivity{

    //char for type
    char type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_project);

        type = 'a';

        Button build = findViewById(R.id.new_project);
        build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //build project and start new intent
                //get project name
                EditText projectNameEditText = findViewById(R.id.newProjectName);
                String projectName = projectNameEditText.getText().toString();

                buildProject(projectName);

                Intent intent = new Intent(NewProject.this, CurrentProject.class);
                intent.putExtra("fileName",projectName);
                startActivity(intent);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.knitButton:
                if (checked)
                    type = 'K';
                break;
            case R.id.crochetButton:
                if (checked)
                    type = 'C';
                break;
        }
    }

    private void buildProject(String projectName) {
        //get month day year
        EditText dateEditText = findViewById(R.id.newStartDate);
        String dateString = dateEditText.getText().toString();

        //parse date
        //int month = 0;
        //int day = 0;
        //int year = 0;
        //if(dateString.length() != 10)

        //open file
        try {
            String fileName;
            fileName = projectName.concat(".txt");
            File file = new File(fileName);
            BufferedWriter fOut = new BufferedWriter(new FileWriter(file));

            //write project name
            fOut.write(projectName);
            fOut.newLine();

            //write project type
            fOut.write(type);
            fOut.newLine();

            //write date
            /*fOut.write(year);
            fOut.newLine();
            fOut.write(month);
            fOut.newLine();
            fOut.write(day);
            fOut.newLine();*/

            fOut.write(dateString);
            fOut.newLine();

            //write counts
            fOut.write(0);
            fOut.newLine();

            //close file
            fOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

