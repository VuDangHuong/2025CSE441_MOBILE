package com.example.qlcb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListActivity extends AppCompatActivity {
    public EmployeeAdapter adapter;
    private List<Staff> employeeList = new ArrayList<>();
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        SearchView searchView = findViewById(R.id.search_view);

        // Khởi tạo danh sách đơn vị
        employeeList.add(new Staff("Kiều Tuấn Dũng", "0383682951", R.drawable.hang1, "dungkt@tlu.edu.vn","Phó khoa CNTT"));
        employeeList.add(new Staff("Chim Cánh Cụt", "0383682952", R.drawable.hang1,"chimcanhcut@gmail.com","Giảng vieen"));
        employeeList.add(new Staff("Nguyễn Thọ Thông", "0383682953", R.drawable.hang1,"thongdz@tlu.edu.vn","Giảng viên"));
        adapter = new EmployeeAdapter(this, employeeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Xử lý sự kiện tìm kiếm
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return false;
            }
        });
        // Xử lý sự kiện khi bấm vào nút "Quay lại"
        btnBack = (Button) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeListActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Đóng UnitListActivity để không quay lại trang này khi nhấn back
            }
        });

        Button btnSort = findViewById(R.id.btn_sort);
        btnSort.setOnClickListener(v -> adapter.sortByNameAZ());
    }
}
