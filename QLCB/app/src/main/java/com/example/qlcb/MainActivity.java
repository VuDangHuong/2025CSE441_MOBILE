package com.example.qlcb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnUnits;
    private Button btnStaff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnUnits = (Button) findViewById(R.id.btn_units);
        btnStaff =(Button) findViewById(R.id.btn_staff);

        btnUnits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent units = new Intent(MainActivity.this, UnitListActivity.class);
                startActivity(units);
            }
        });

        btnStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent staffs= new Intent(MainActivity.this, EmployeeListActivity.class);
                startActivity(staffs);
            }
        });
    }
}