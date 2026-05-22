package vn.humg.hai.b7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.humg.hai.b7.model.Food;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Food> foodList;
    private final OnItemClickListener listener;

    // Interface để xử lý sự kiện click từ Fragment
    public interface OnItemClickListener {
        void onItemClick(Food food);
    }

    public FoodAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    // Hàm để cập nhật dữ liệu mới cho Adapter
    public void setData(List<Food> list) {
        this.foodList = list;
        notifyDataSetChanged(); // Yêu cầu vẽ lại danh sách
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        if (food == null) return;

        // Đổ dữ liệu vào View
        holder.imgFood.setImageResource(food.getImageRes());
        holder.tvName.setText(food.getName());
        holder.tvTime.setText(food.getTime());
        holder.tvRating.setText(String.valueOf(food.getRating()));

        // XỬ LÝ LOGIC QUAN TRỌNG: Hiển thị tim nếu là món yêu thích
        if (food.isFavorite()) {
            holder.imgFavIcon.setVisibility(View.VISIBLE);
        } else {
            holder.imgFavIcon.setVisibility(View.GONE);
        }

        // Bắt sự kiện click vào item
        holder.itemView.setOnClickListener(v -> listener.onItemClick(food));
    }

    @Override
    public int getItemCount() {
        return foodList != null ? foodList.size() : 0;
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgFood, imgFavIcon;
        private final TextView tvName, tvTime, tvRating;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.imgFood);
            imgFavIcon = itemView.findViewById(R.id.imgFavIcon);
            tvName = itemView.findViewById(R.id.tvFoodName);
            tvTime = itemView.findViewById(R.id.tvFoodTime);
            tvRating = itemView.findViewById(R.id.tvFoodRating);
        }
    }
}