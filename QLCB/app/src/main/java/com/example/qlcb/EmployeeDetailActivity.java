package com.example.qlcb;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EmployeeDetailActivity extends AppCompatActivity {
    private ImageView imgAvatar;
    private TextView txtName, txtPhone, txtPosition,txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        // Ánh xạ view
        imgAvatar = findViewById(R.id.img_detail_avatar);
        txtName = findViewById(R.id.txt_detail_name);
        txtPhone = findViewById(R.id.txt_detail_phone);
        txtEmail = findViewById(R.id.txt_detail_email);
        txtPosition = findViewById(R.id.txt_detail_position);
        Button btnBack = findViewById(R.id.btn_back);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("phone");
            int imageResId = intent.getIntExtra("image", R.drawable.hang1);
            String email = intent.getStringExtra("email");
            String position = intent.getStringExtra("position");

            // Debug log để kiểm tra giá trị nhận được


            txtName.setText(name);
            txtPhone.setText(phone);
            imgAvatar.setImageResource(imageResId);
            txtEmail.setText(email);
            txtPosition.setText(position);
        }

        // Xử lý sự kiện nút "Quay lại"
        btnBack.setOnClickListener(v -> {
            finish(); // Đóng UnitDetailActivity và quay lại UnitListActivity
        });
    }
}
