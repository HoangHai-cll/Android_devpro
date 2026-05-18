package vn.humg.hai.baiiii5;

import java.io.Serializable;

public class CartItem implements Serializable {
    private Coffee coffee;
    private int quantity;

    public CartItem(Coffee coffee, int quantity) {
        this.coffee = coffee;
        this.quantity = quantity;
    }

    public Coffee getCoffee() { return coffee; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
