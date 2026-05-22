package vn.humg.hai.b7.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

import vn.humg.hai.b7.R;

public class FoodViewModel extends ViewModel {
    // Danh sách tất cả món ăn
    private final MutableLiveData<List<Food>> foodList = new MutableLiveData<>();

    // Món ăn đang được chọn để xem chi tiết
    private final MutableLiveData<Food> selectedFood = new MutableLiveData<>();

    public FoodViewModel() {
        // Khởi tạo dữ liệu mẫu (Bạn thay R.drawable.img_... bằng ảnh bạn đã thêm ở B1)
        List<Food> initialList = new ArrayList<>();
        initialList.add(new Food(1, "Bánh mỳ ", "9 mins", 4.3, "Bánh mỳ sài gòn thơm ngon ... ", R.drawable.img_banhmy, false));
        initialList.add(new Food(2, "Cơm rang", "10 mins", 4.5, "Cơm rang thập cẩm...", R.drawable.img_comrang, false));
        initialList.add(new Food(3, "Cá kho ", "30 mins", 4.8, "Cá kho tộ gia truyền ...", R.drawable.img_cakho,false));
        initialList.add(new Food(4, "Mỳ cay  ", "15 mins", 4.2, "Mỳ cay hàn quốc ...", R.drawable.img_mycay,false));
        initialList.add(new Food(5, "Sườn xào chua ngọt ", "20 mins", 4.7, "Dẻ sườn thơm ngon ...", R.drawable.img_suon,false));
        initialList.add(new Food(6, "Thịt kho tàu ", "25 mins", 4.9, "Thịt kho tàu hảo hạng ...", R.drawable.img_thitkhotau,false));


        foodList.setValue(initialList);
    }

    // Getter cho danh sách món ăn
    public LiveData<List<Food>> getFoodList() {
        return foodList;
    }

    // Getter/Setter cho món ăn được chọn
    public void selectFood(Food food) {
        selectedFood.setValue(food);
    }
    public LiveData<Food> getSelectedFood() {
        return selectedFood;
    }

    // Hàm quan trọng: Đảo ngược trạng thái Favorite
    public void toggleFavorite(int foodId) {
        List<Food> currentList = foodList.getValue();
        if (currentList != null) {
            for (Food f : currentList) {
                if (f.getId() == foodId) {
                    f.setFavorite(!f.isFavorite()); // Đổi true thành false hoặc ngược lại
                    break;
                }
            }
            // Sau khi sửa thuộc tính bên trong Object, ta phải set lại Value
            // để các Fragment đang Observe nhận được thông báo thay đổi.
            foodList.setValue(currentList);
        }
    }
    }
