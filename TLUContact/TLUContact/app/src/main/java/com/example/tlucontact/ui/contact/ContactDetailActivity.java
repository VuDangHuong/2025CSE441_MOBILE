package com.example.tlucontact.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tlucontact.R;
import com.example.tlucontact.data.model.Contact;

public class ContactDetailActivity extends AppCompatActivity {

    private TextView tvContactName, tvContactPosition, tvContactPhone, tvContactEmail, tvContactDepartment;
    private Button btnBack;

    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        // Ánh xạ View
        tvContactName = findViewById(R.id.tvContactName);
        tvContactPosition = findViewById(R.id.tvContactPosition);
        tvContactPhone = findViewById(R.id.tvContactPhone);
        tvContactEmail = findViewById(R.id.tvContactEmail);
        tvContactDepartment = findViewById(R.id.tvContactDepartment);
        btnBack = findViewById(R.id.btnBack);


        // Nhận dữ liệu từ Intent
        contact = (Contact) getIntent().getSerializableExtra("contact");
        if (contact != null) {
            updateContactDetails();
        }

        // Xử lý sự kiện khi nhấn nút "Quay lại"
        btnBack.setOnClickListener(v -> finish());


    }

    // Cập nhật lại thông tin sau khi chỉnh sửa
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            contact = (Contact) data.getSerializableExtra("updatedContact");
            if (contact != null) {
                updateContactDetails();
            }
        }
    }

    private void updateContactDetails() {
        tvContactName.setText(contact.getName());
        tvContactPosition.setText("Chức vụ: " + contact.getPosition());
        tvContactPhone.setText("Số điện thoại: " + contact.getPhone());
        tvContactEmail.setText("Email: " + contact.getEmail());
        tvContactDepartment.setText("Đơn vị: " + contact.getDepartmentId());
    }
}
