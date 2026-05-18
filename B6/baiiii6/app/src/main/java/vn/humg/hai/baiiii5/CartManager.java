package vn.humg.hai.baiiii5;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static final String PREF_NAME = "CoffeeCartPref";
    private static final String KEY_CART = "CartItems";
    private static CartManager instance;
    private final SharedPreferences sharedPreferences;
    private final Gson gson;

    private CartManager(Context context) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public static synchronized CartManager getInstance(Context context) {
        if (instance == null) {
            instance = new CartManager(context);
        }
        return instance;
    }

    public void saveCart(List<CartItem> cartItems) {
        String json = gson.toJson(cartItems);
        sharedPreferences.edit().putString(KEY_CART, json).apply();
    }

    public List<CartItem> getCart() {
        String json = sharedPreferences.getString(KEY_CART, null);
        if (json == null) {
            return new ArrayList<>();
        }
        Type type = new TypeToken<List<CartItem>>() {}.getType();
        return gson.fromJson(json, type);
    }

    public void addToCart(Coffee coffee) {
        List<CartItem> cart = getCart();
        boolean found = false;
        for (CartItem item : cart) {
            if (item.getCoffee().getId() == coffee.getId()) {
                item.setQuantity(item.getQuantity() + 1);
                found = true;
                break;
            }
        }
        if (!found) {
            cart.add(new CartItem(coffee, 1));
        }
        saveCart(cart);
    }

    public void removeFromCart(Coffee coffee) {
        List<CartItem> cart = getCart();
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getCoffee().getId() == coffee.getId()) {
                int qty = cart.get(i).getQuantity();
                if (qty > 1) {
                    cart.get(i).setQuantity(qty - 1);
                } else {
                    cart.remove(i);
                }
                break;
            }
        }
        saveCart(cart);
    }

    public int getCartCount() {
        List<CartItem> cart = getCart();
        int total = 0;
        for (CartItem item : cart) {
            total += item.getQuantity();
        }
        return total;
    }

    public double getTotalPrice() {
        List<CartItem> cart = getCart();
        double total = 0;
        for (CartItem item : cart) {
            total += item.getCoffee().getPrice() * item.getQuantity();
        }
        return total;
    }
}
