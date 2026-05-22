package vn.humg.hai.b7.model;

public class Food {

    private int id;
    private String name;
    private String time;
    private double rating;
    private String description;
    private int imageRes; // ID của ảnh trong drawable
    private boolean isFavorite; // Trạng thái tim

    public Food(int id, String name, String time, double rating, String description, int imageRes, boolean isFavorite) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.rating = rating;
        this.description = description;
        this.imageRes = imageRes;
        this.isFavorite = isFavorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
