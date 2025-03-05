package com.example.qlcb;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UnitDetailActivity extends AppCompatActivity {
    private ImageView imgAvatar;
    private TextView txtName, txtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_detail);

        // Ánh xạ view
        imgAvatar = findViewById(R.id.img_detail_avatar);
        txtName = findViewById(R.id.txt_detail_name);
        txtPhone = findViewById(R.id.txt_detail_phone);
        Button btnBack = findViewById(R.id.btn_back);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("phone");
            int imageResId = intent.getIntExtra("image", R.drawable.hang1); // Ảnh mặc định nếu null

            // Hiển thị dữ liệu
            txtName.setText(name);
            txtPhone.setText(phone);
            imgAvatar.setImageResource(imageResId);
        }

        // Xử lý sự kiện nút "Quay lại"
        btnBack.setOnClickListener(v -> {
            finish(); // Đóng UnitDetailActivity và quay lại UnitListActivity
        });
    }
}
