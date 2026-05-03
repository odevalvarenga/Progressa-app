package com.example.progressa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Certifique-se que o arquivo activity_home.xml existe em res/layout
        setContentView(R.layout.activity_home)
    }
}