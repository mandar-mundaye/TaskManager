package com.example.ttmanager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {
   Button BC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        BC=(Button) findViewById(R.id.close);
        BC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            System.exit(0);
            }
        });
    }
}