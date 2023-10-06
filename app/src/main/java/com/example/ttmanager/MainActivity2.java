package com.example.ttmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {

    EditText editTextTask;
    DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        FloatingActionButton buttonAddTask= (FloatingActionButton) findViewById(R.id.buttonAddTask);
        editTextTask = findViewById(R.id.editTextTask);
        datePicker = findViewById(R.id.datePicker);

        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = editTextTask.getText().toString();
                int year = datePicker.getYear();
                int month = datePicker.getMonth();
                int day = datePicker.getDayOfMonth();

                // Create a Task object and pass it to the second activity
                Task taskObject = new Task(task, year, month, day);
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                intent.putExtra("taskObject", taskObject);
                startActivity(intent);
            }
        });
    }
}