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

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.UnitViewHolder> {
    private Context context;
    private List<Unit> unitList;
    private List<Unit> unitListFull; // Lưu danh sách gốc để tìm kiếm

    public UnitAdapter(Context context, List<Unit> units) {
        this.context = context;
        this.unitList = new ArrayList<>(units);
        this.unitListFull = new ArrayList<>(units); // Sao chép danh sách ban đầu
    }

    @NonNull
    @Override
    public UnitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_unit, parent, false);
        return new UnitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnitViewHolder holder, int position) {
        Unit unit = unitList.get(position);
        holder.bind(unit);

        // Xử lý sự kiện click vào item
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, UnitDetailActivity.class);
            intent.putExtra("name", unit.getName());
            intent.putExtra("phone", unit.getPhone());
            intent.putExtra("image", unit.getImage()); // Truyền ảnh
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return unitList.size();
    }

    static class UnitViewHolder extends RecyclerView.ViewHolder {
        private ImageView appImage;
        private TextView txtName;
        private TextView txtPhone;

        public UnitViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtPhone = itemView.findViewById(R.id.txt_phone);
            appImage = itemView.findViewById(R.id.img_avatar);
        }

        public void bind(Unit unit) {
            txtName.setText(unit.getName());
            txtPhone.setText(unit.getPhone());
            appImage.setImageResource(unit.getImage());
        }
    }

    // Hàm tìm kiếm theo tên
    public void filter(String text) {
        unitList.clear();
        if (text.isEmpty()) {
            unitList.addAll(unitListFull);
        } else {
            text = text.toLowerCase();
            for (Unit unit : unitListFull) {
                if (unit.getName().toLowerCase().contains(text)) {
                    unitList.add(unit);
                }
            }
        }
        notifyDataSetChanged(); // Cập nhật RecyclerView
    }
    public void sortByNameAZ() {
        Collections.sort(unitList, Comparator.comparing(Unit::getName));
        notifyDataSetChanged();
    }
}
