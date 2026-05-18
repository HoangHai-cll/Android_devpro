package vn.humg.hai.baiiii5;

import java.io.Serializable;

public class Coffee implements Serializable {
    private int id;
    private String name;
    private double price;
    private int imageResId;
    private boolean isFavorite;

    public Coffee(int id, String name, double price, int imageResId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageResId = imageResId;
        this.isFavorite = false;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getImageResId() { return imageResId; }
    public boolean isFavorite() { return isFavorite; }
    public void setFavorite(boolean favorite) { isFavorite = favorite; }
}
