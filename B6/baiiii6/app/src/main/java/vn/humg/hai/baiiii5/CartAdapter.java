package vn.humg.hai.baiiii5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private final List<CartItem> cartItems;
    public final OnCartQuantityChangeListener listener;

    public interface OnCartQuantityChangeListener {
        void onIncrease(CartItem item);
        void onDecrease(CartItem item);
    }

    public CartAdapter(List<CartItem> cartItems, OnCartQuantityChangeListener listener) {
        this.cartItems = cartItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem item = cartItems.get(position);
        Coffee coffee = item.getCoffee();

        holder.tvName.setText(coffee.getName());
        holder.tvPrice.setText(String.format("$%.0f", coffee.getPrice()));
        holder.tvQuantity.setText(String.valueOf(item.getQuantity()));
        holder.imgCoffee.setImageResource(coffee.getImageResId());

        holder.btnPlus.setOnClickListener(v -> listener.onIncrease(item));
        holder.btnMinus.setOnClickListener(v -> listener.onDecrease(item));
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCoffee, btnMinus, btnPlus;
        TextView tvName, tvPrice, tvQuantity, tvRating;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCoffee = itemView.findViewById(R.id.imgCartCoffee);
            btnMinus = itemView.findViewById(R.id.btnCartMinus);
            btnPlus = itemView.findViewById(R.id.btnCartPlus);
            tvName = itemView.findViewById(R.id.tvCartCoffeeName);
            tvPrice = itemView.findViewById(R.id.tvCartCoffeePrice);
            tvQuantity = itemView.findViewById(R.id.tvCartQuantity);
            tvRating = itemView.findViewById(R.id.tvRating);
        }
    }
}
