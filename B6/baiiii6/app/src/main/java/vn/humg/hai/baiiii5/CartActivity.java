package vn.humg.hai.baiiii5;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView rvCart;
    private CartAdapter adapter;
    private CartManager cartManager;
    private TextView tvItemCount, tvSubTotal, tvTotal;
    private LinearLayout layoutEmpty, layoutSummary;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartManager = CartManager.getInstance(this);
        initViews();
        setupRecyclerView();

        btnBack.setOnClickListener(v -> finish());
    }

    private void initViews() {
        rvCart = findViewById(R.id.rvCart);
        tvItemCount = findViewById(R.id.tvItemCount);
        tvSubTotal = findViewById(R.id.tvSubTotal);
        tvTotal = findViewById(R.id.tvTotal);
        layoutEmpty = findViewById(R.id.layoutEmpty);
        layoutSummary = findViewById(R.id.layoutSummary);
        btnBack = findViewById(R.id.btnBack);
    }

    private void setupRecyclerView() {
        List<CartItem> cartItems = cartManager.getCart();
        updateUI(cartItems);

        adapter = new CartAdapter(cartItems, new CartAdapter.OnCartQuantityChangeListener() {
            @Override
            public void onIncrease(CartItem item) {
                cartManager.addToCart(item.getCoffee());
                refreshCart();
            }

            @Override
            public void onDecrease(CartItem item) {
                cartManager.removeFromCart(item.getCoffee());
                refreshCart();
            }
        });
        rvCart.setLayoutManager(new LinearLayoutManager(this));
        rvCart.setAdapter(adapter);
    }

    private void refreshCart() {
        List<CartItem> cartItems = cartManager.getCart();
        updateUI(cartItems);
        adapter = new CartAdapter(cartItems, adapter.listener);
        rvCart.setAdapter(adapter);
    }

    private void updateUI(List<CartItem> cartItems) {
        if (cartItems.isEmpty()) {
            layoutEmpty.setVisibility(View.VISIBLE);
            rvCart.setVisibility(View.GONE);
        } else {
            layoutEmpty.setVisibility(View.GONE);
            rvCart.setVisibility(View.VISIBLE);
        }

        int count = cartManager.getCartCount();
        tvItemCount.setText(getString(R.string.items_count, count));
        
        double total = cartManager.getTotalPrice();
        tvSubTotal.setText(String.format("%.0f", total));
        tvTotal.setText(getString(R.string.price_format, total));
    }
}
