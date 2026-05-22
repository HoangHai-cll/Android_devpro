package vn.humg.hai.b7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import vn.humg.hai.b7.model.FoodViewModel;

public class FoodListFragment extends Fragment {

    private FoodViewModel viewModel;
    private FoodAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 1. Inflate layout cho fragment này
        View view = inflater.inflate(R.layout.fragment_food_list, container, false);

        // 2. Ánh xạ RecyclerView
        RecyclerView rcvFood = view.findViewById(R.id.rcvFood);
        rcvFood.setLayoutManager(new LinearLayoutManager(getContext()));

        // 3. Khởi tạo ViewModel (Dùng requireActivity để dùng chung dữ liệu với Detail)
        viewModel = new ViewModelProvider(requireActivity()).get(FoodViewModel.class);

        // 4. Thiết lập Adapter và xử lý sự kiện click
        adapter = new FoodAdapter(food -> {
            // Khi bấm vào 1 item:
            // - Lưu món ăn đó vào biến selectedFood trong ViewModel
            viewModel.selectFood(food);

            // - Chuyển sang Fragment Detail
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new FoodDetailFragment()) // fragment_container là id trong activity_main
                    .addToBackStack(null) // Cho phép bấm Back để quay lại list
                    .commit();
        });

        rcvFood.setAdapter(adapter);

        // 5. THEO DÕI DỮ LIỆU: Khi danh sách món ăn thay đổi, tự động cập nhật Adapter
        viewModel.getFoodList().observe(getViewLifecycleOwner(), foods -> {
            if (foods != null) {
                adapter.setData(foods);
            }
        });

        return view;
    }
}