package vn.humg.hai.b7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import vn.humg.hai.b7.model.Food;
import vn.humg.hai.b7.model.FoodViewModel;

public class FoodDetailFragment extends Fragment {

    private FoodViewModel viewModel;
    private ImageView imgDetail, btnBack, btnFav;
    private TextView tvName, tvDesc, tvTime;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_detail, container, false);

        // Ánh xạ View
        imgDetail = view.findViewById(R.id.imgDetail);
        btnBack = view.findViewById(R.id.btnBack);
        btnFav = view.findViewById(R.id.btnFav);
        tvName = view.findViewById(R.id.tvDetailName);
        tvDesc = view.findViewById(R.id.tvDetailDesc);
        tvTime = view.findViewById(R.id.tvDetailTime);

        // Khởi tạo ViewModel (dùng requireActivity để lấy chung instance với ListFragment)
        viewModel = new ViewModelProvider(requireActivity()).get(FoodViewModel.class);

        // Theo dõi món ăn được chọn
        viewModel.getSelectedFood().observe(getViewLifecycleOwner(), food -> {
            if (food != null) {
                displayFoodDetails(food);
            }
        });

        // Xử lý nút Back
        btnBack.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }

    private void displayFoodDetails(Food food) {
        imgDetail.setImageResource(food.getImageRes());
        tvName.setText(food.getName());
        tvDesc.setText(food.getDescription());
        tvTime.setText(food.getTime());

        // Cập nhật icon tim
        updateFavoriteIcon(food.isFavorite());

        // Xử lý nút Favorite
        btnFav.setOnClickListener(v -> {
            viewModel.toggleFavorite(food.getId());
            // Sau khi toggle, ViewModel sẽ notify, observer ở List và Detail sẽ nhận được
            // Tuy nhiên Food object trong selectedFood có thể không tự cập nhật UI nếu ta không update icon ở đây
            // hoặc ViewModel phải cập nhật lại selectedFood.
            // Để đơn giản, ta update icon luôn hoặc check lại ViewModel.
            updateFavoriteIcon(!food.isFavorite());
        });
    }

    private void updateFavoriteIcon(boolean isFavorite) {
        if (isFavorite) {
            btnFav.setImageResource(R.drawable.ic_heart_filled);
        } else {
            btnFav.setImageResource(R.drawable.ic_heart_outline);
        }
    }
}
