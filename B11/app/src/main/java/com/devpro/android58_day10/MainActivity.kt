package com.devpro.android58_day10

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.devpro.android58_day10.MyExtendFunction.disable
import com.devpro.android58_day10.MyExtendFunction.hide
import com.devpro.android58_day10.databinding.ActivityMainBinding
import com.devpro.android58_day10.models.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val userA = User("1", "Alice", 30, "https://www.w3schools.com/howto/img_avatar.png")
        binding.newUser = userA

//        val tvName = findViewById<android.widget.TextView>(R.id.tvName)
//        tvName.text = userA.name
//        tvDemo.hide()
//        tvName.disable(0.3f)
    }
}