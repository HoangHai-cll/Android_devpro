package vn.humg.hai.baiiii5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCoffeeMenu;
    private CoffeeAdapter adapter;
    private List<Coffee> coffeeList;
    private CartManager cartManager;
    private TextView tvCartBadge;
    private FrameLayout cartContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cartManager = CartManager.getInstance(this);
        initViews();
        loadData();
        setupRecyclerView();

        cartContainer.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }

    private void initViews() {
        rvCoffeeMenu = findViewById(R.id.rvCoffeeMenu);
        tvCartBadge = findViewById(R.id.tvCartBadge);
        cartContainer = findViewById(R.id.cartContainer);
        updateCartBadge();
    }

    private void loadData() {
        coffeeList = new ArrayList<>();
        coffeeList.add(new Coffee(1, "Mixed Black Coffee", 12.00, R.drawable.img_mixed));
        coffeeList.add(new Coffee(2, "Mixed Black Coffee", 12.00, R.drawable.img_mixel1));
        coffeeList.add(new Coffee(3, "Mixed Black Coffee", 12.00, R.drawable.img_expresso));
        coffeeList.add(new Coffee(4, "Hot Chocolate", 12.00, R.drawable.img_hotchocolate));
        coffeeList.add(new Coffee(5, "Caramel Frappucino", 15.00, R.drawable.img_caramelfrappucino));
        coffeeList.add(new Coffee(6, "Ice Coffee", 10.00, R.drawable.img_icecoffee));
    }

    private void setupRecyclerView() {
        adapter = new CoffeeAdapter(coffeeList, cartManager.getCart(), new CoffeeAdapter.OnCartChangeListener() {
            @Override
            public void onAdd(Coffee coffee) {
                cartManager.addToCart(coffee);
                refreshCart();
            }

            @Override
            public void onRemove(Coffee coffee) {
                cartManager.removeFromCart(coffee);
                refreshCart();
            }
        });
        rvCoffeeMenu.setLayoutManager(new GridLayoutManager(this, 2));
        rvCoffeeMenu.setAdapter(adapter);
    }

    private void refreshCart() {
        updateCartBadge();
        // Since we want to update the quantities shown in the list
        adapter = new CoffeeAdapter(coffeeList, cartManager.getCart(), adapter.listener);
        rvCoffeeMenu.setAdapter(adapter);
    }

    private void updateCartBadge() {
        int count = cartManager.getCartCount();
        tvCartBadge.setText(String.valueOf(count));
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshCart();
    }
}
