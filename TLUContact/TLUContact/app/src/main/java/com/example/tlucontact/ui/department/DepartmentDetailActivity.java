package com.example.tlucontact.ui.department;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tlucontact.R;
import com.example.tlucontact.data.model.Department;

public class DepartmentDetailActivity extends AppCompatActivity {
    private TextView tvDepartmentName, tvDepartmentPhone, tvDepartmentAddress;
    private Button btnBack;

    private Department department;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_detail);

        // Ánh xạ View
        tvDepartmentName = findViewById(R.id.tvDepartmentName);
        tvDepartmentPhone = findViewById(R.id.tvDepartmentPhone);
        tvDepartmentAddress = findViewById(R.id.tvDepartmentAddress);
        btnBack = findViewById(R.id.btnBack);

        // Nhận dữ liệu từ Intent
        department = (Department) getIntent().getSerializableExtra("department");
        if (department != null) {
            updateDepartmentDetails();
        }

        // Quay lại
        btnBack.setOnClickListener(v -> finish());
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            department = (Department) data.getSerializableExtra("updatedDepartment");
            if (department != null) {
                updateDepartmentDetails();
            }
        }
    }

    private void updateDepartmentDetails() {
        tvDepartmentName.setText(department.getName());
        tvDepartmentAddress.setText(department.getAddress());
        tvDepartmentPhone.setText(department.getPhone());
    }
}
