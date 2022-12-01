package com.aziz.cemilanlebaranpt3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.aziz.cemilanlebaranpt3.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        step 1
        val manageFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment? ?: return
//        step 2
        val navHostController = manageFragment.navController
//        step 3
        val bottomnaagation: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomnaagation.setupWithNavController(navHostController)

    }
}