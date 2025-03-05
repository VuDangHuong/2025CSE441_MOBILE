package com.example.qlcb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeAdapter  extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {
    private Context context;
    private List<Staff> employeeList;
    private List<Staff> employeeListFull; // Lưu danh sách gốc để tìm kiếm
    public EmployeeAdapter(Context context, List<Staff> employees) {
        this.context = context;
        this.employeeList = new ArrayList<>(employees);
        this.employeeListFull = new ArrayList<>(employees); // Sao chép danh sách ban đầu
    }
    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Staff employee = employeeList.get(position);
        holder.bind(employee);

        // Xử lý sự kiện click vào item
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, EmployeeDetailActivity.class);
            intent.putExtra("name", employee.getName());
            intent.putExtra("phone", employee.getPhone());
            intent.putExtra("image", employee.getImage());
            intent.putExtra("email", employee.getEmail()); // Thêm email
            intent.putExtra("position", employee.getPosition()); // Thêm position
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        private ImageView appImage;
        private TextView txtName;
        private TextView txtPhone;


        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtPhone = itemView.findViewById(R.id.txt_phone);
            appImage = itemView.findViewById(R.id.img_avatar);

        }
        public void bind(Staff employee) {
            txtName.setText(employee.getName());
            txtPhone.setText(employee.getPhone());
            appImage.setImageResource(employee.getImage());

        }
    }
    public void filter(String text) {
        employeeList.clear();
        if (text.isEmpty()) {
            employeeList.addAll(employeeList);
        } else {
            text = text.toLowerCase();
            for (Staff employee : employeeListFull) {
                if (employee.getName().toLowerCase().contains(text)) {
                    employeeList.add(employee);
                }
            }
        }
        notifyDataSetChanged(); // Cập nhật RecyclerView
    }
    public void sortByNameAZ() {
        Collections.sort(employeeList, Comparator.comparing(Staff::getName));
        notifyDataSetChanged();
    }
}
