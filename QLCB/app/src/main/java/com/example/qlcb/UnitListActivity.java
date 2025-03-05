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

public class UnitListActivity extends AppCompatActivity {
    private UnitAdapter adapter;
    private List<Unit> unitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_unit_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewUnits);
        SearchView searchView = findViewById(R.id.search_view);

        // Khởi tạo danh sách đơn vị
        unitList.add(new Unit("Phòng đào tạo", "0383682951", R.drawable.hang1));
        unitList.add(new Unit("Phòng công tác sinh viên", "0383682952", R.drawable.hang1));
        unitList.add(new Unit("Phòng học 310-B5", "0383682953", R.drawable.hang1));

        // Thiết lập Adapter
        adapter = new UnitAdapter(this, unitList);
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
        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UnitListActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Đóng UnitListActivity để không quay lại trang này khi nhấn back
            }
        });

        Button btnSort = findViewById(R.id.btn_sort);
        btnSort.setOnClickListener(v -> adapter.sortByNameAZ());
    }
}

