package com.example.aniwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.aniwatch.databinding.ActivityMainBinding
import com.example.aniwatch.databinding.LandscapeBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        anime()
    }

    fun anime() {
        binding.apply {
            webView.webViewClient = WebViewClient()
            webView.loadUrl("https://animego.org")
        }
    }

    override fun onBackPressed() {
        binding.webView.goBack()
    }
}