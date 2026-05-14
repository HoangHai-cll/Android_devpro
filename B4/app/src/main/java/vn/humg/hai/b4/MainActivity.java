package vn.humg.hai.b4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // 1. Khai báo các biến private cho các View
    private ImageView btnBack, btnMenu, imgHeart;
    private Button btnWifi, btnBreakfast, btnRating, btnBooking;
    private TextView tvHotelName, tvPrice, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Xử lý tràn viền (Padding theo hệ thống)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 2. Ánh xạ ID từ XML sang biến Java
        initViews();

        // 3. Thiết lập các sự kiện click (Ví dụ)
        setupClickListeners();
    }

    private void initViews() {
        // Ánh xạ các icon ở header
        btnBack = findViewById(R.id.back);
        btnMenu = findViewById(R.id.menu);
        imgHeart = findViewById(R.id.img_heart);

        // Ánh xạ các nút tiện ích (Dùng ID từ bản code tối ưu tôi gửi trước đó)
        btnWifi = findViewById(R.id.btnWifi);
        btnBreakfast = findViewById(R.id.btnBreakfast);
        btnRating = findViewById(R.id.btnRating);
        btnBooking = findViewById(R.id.btnbooking);

        // Ánh xạ các TextView
        tvHotelName = findViewById(R.id.textHotelName);
        tvPrice = findViewById(R.id.textPrice);
        tvDescription = findViewById(R.id.textContent);
    }

    private void setupClickListeners() {
        // Ví dụ: Khi nhấn nút Booking Now
        btnBooking.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Bạn đã nhấn Đặt phòng!", Toast.LENGTH_SHORT).show();
        });

        // Ví dụ: Khi nhấn nút Back
        btnBack.setOnClickListener(v -> {
            finish(); // Đóng Activity
        });

        // Ví dụ: Đổi trạng thái tim (Yêu thích)
        imgHeart.setOnClickListener(v -> {
            imgHeart.setSelected(!imgHeart.isSelected());
            Toast.makeText(this, "Đã thêm vào danh sách yêu thích", Toast.LENGTH_SHORT).show();
        });
    }
}