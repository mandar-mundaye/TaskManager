package com.example.ttmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity3 extends AppCompatActivity {
    Button dn;
    ArrayList<String> taskList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        taskList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        ListView listViewTasks = findViewById(R.id.listViewTasks);
        listViewTasks.setAdapter(adapter);

        // Retrieve the Task object from the first activity
        Intent intent = getIntent();
        if (intent != null) {
            Task taskObject = intent.getParcelableExtra("taskObject");
            if (taskObject != null) {
                // Add the task with date and time to the list
                taskList.add(taskObject.toString());
                adapter.notifyDataSetChanged();
            }
        }

        // Button to navigate to the next activity
        Button buttonNextActivity = findViewById(R.id.buttonNextActivity);
        buttonNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the next activity
                Intent nextActivityIntent = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(nextActivityIntent);
            }
        });
        listViewTasks.setOnItemLongClickListener((parent, view, position, id) -> {
            // Handle task item long-click to delete the task.
            removeTask(position);
            return true;
        });
    }

    private void removeTask(int position) {
        if (position >= 0 && position < taskList.size()) {
            taskList.remove(position);
            adapter.notifyDataSetChanged();
        }
    }
}