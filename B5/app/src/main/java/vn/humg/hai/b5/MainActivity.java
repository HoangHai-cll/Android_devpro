package vn.humg.hai.b5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Thiết lập StaggeredGridLayoutManager với 2 cột (chiều dọc)
        // Pinterest style: ảnh tự co dãn theo chiều cao gốc
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        // Tránh hiện tượng item bị nhảy khi scroll
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.setLayoutManager(layoutManager);

        // Danh sách ảnh từ pos2 đến pos7
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.pos2);
        imageList.add(R.drawable.pos3);
        imageList.add(R.drawable.pos4);
        imageList.add(R.drawable.pos5);
        imageList.add(R.drawable.pos6);
        imageList.add(R.drawable.pos7);
        
        // Lặp lại dữ liệu để có thể scroll và thấy rõ hiệu ứng Staggered
        List<Integer> displayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            displayList.addAll(imageList);
        }

        PinterestAdapter adapter = new PinterestAdapter(displayList);
        recyclerView.setAdapter(adapter);
    }
}
