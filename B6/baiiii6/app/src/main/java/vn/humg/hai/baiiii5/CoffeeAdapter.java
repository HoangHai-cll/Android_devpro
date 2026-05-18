package vn.humg.hai.baiiii5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder> {

    private final List<Coffee> coffeeList;
    private final List<CartItem> cartItems;
    public final OnCartChangeListener listener;

    public interface OnCartChangeListener {
        void onAdd(Coffee coffee);
        void onRemove(Coffee coffee);
    }

    public CoffeeAdapter(List<Coffee> coffeeList, List<CartItem> cartItems, OnCartChangeListener listener) {
        this.coffeeList = coffeeList;
        this.cartItems = cartItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coffee, parent, false);
        return new CoffeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder holder, int position) {
        Coffee coffee = coffeeList.get(position);
        holder.tvName.setText(coffee.getName());
        holder.tvPrice.setText(String.format("$%.2f", coffee.getPrice()));
        holder.imgCoffee.setImageResource(coffee.getImageResId());
        
        int quantity = 0;
        for (CartItem item : cartItems) {
            if (item.getCoffee().getId() == coffee.getId()) {
                quantity = item.getQuantity();
                break;
            }
        }
        holder.tvQuantity.setText(String.valueOf(quantity));

        holder.btnPlus.setOnClickListener(v -> listener.onAdd(coffee));
        holder.btnMinus.setOnClickListener(v -> {
            if (Integer.parseInt(holder.tvQuantity.getText().toString()) > 0) {
                listener.onRemove(coffee);
            }
        });
    }

    @Override
    public int getItemCount() {
        return coffeeList.size();
    }

    static class CoffeeViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCoffee, imgFavorite, btnMinus, btnPlus;
        TextView tvName, tvPrice, tvQuantity;

        public CoffeeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCoffee = itemView.findViewById(R.id.imgCoffee);
            imgFavorite = itemView.findViewById(R.id.imgFavorite);
            btnMinus = itemView.findViewById(R.id.btnMinus);
            btnPlus = itemView.findViewById(R.id.btnPlus);
            tvName = itemView.findViewById(R.id.tvCoffeeName);
            tvPrice = itemView.findViewById(R.id.tvCoffeePrice);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
        }
    }
}
