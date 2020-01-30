package com.poorna.bottomdrawerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var homeFragment: HomeFragment
    private lateinit var settingFragment: SettingFragment
    private lateinit var accountFragment: AccountFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation = findViewById(R.id.bottom_navigation)

        homeFragment = HomeFragment()
        settingFragment = SettingFragment()
        accountFragment = AccountFragment()

        bottomNavigation.setOnNavigationItemSelectedListener {
            var selectedFragment: Fragment = homeFragment
            when (it.itemId) {
                R.id.menu_home -> selectedFragment = homeFragment
                R.id.menu_settings -> selectedFragment = settingFragment
                R.id.menu_account -> selectedFragment = accountFragment
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame_layout, selectedFragment)
                .commit()

            return@setOnNavigationItemSelectedListener true
        }

        bottomNavigation.selectedItemId = R.id.menu_home

    }
}
