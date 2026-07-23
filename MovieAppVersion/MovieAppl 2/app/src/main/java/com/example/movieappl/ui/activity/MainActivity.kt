package com.example.movieappl.ui.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import com.example.movieappl.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var btnNav: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        bottomNav = findViewById(R.id.bottomNav)
        val navView = findViewById<NavigationView>(R.id.nav_view)

        // ✅ Custom Toolbar Views
        btnNav = findViewById(R.id.btnNav)

        // ✅ Nav Controller
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController

        // ===========================
        // ✅ NAV ICON CLICK (☰ / ←)
        // ===========================
        btnNav.setOnClickListener {
            if (navController.currentDestination?.id == R.id.homeFragment) {
                drawerLayout.openDrawer(GravityCompat.START)
            } else {
                navController.popBackStack(R.id.homeFragment, false)
            }
        }

        // ===========================
        // ✅ BOTTOM NAVIGATION
        // ===========================
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.homeFragment -> {
                    if (navController.currentDestination?.id != R.id.homeFragment) {
                        navController.popBackStack(R.id.homeFragment, false)
                    }
                    true
                }

                R.id.savedFragment -> {
                    if (navController.currentDestination?.id != R.id.savedFragment) {
                        navController.navigate(R.id.savedFragment)
                    }
                    true
                }

                else -> false
            }
        }

        // ===========================
        // ✅ DRAWER NAVIGATION
        // ===========================
        navView.setNavigationItemSelectedListener { item ->

            when (item.itemId) {

                R.id.nav_home -> {
                    navController.popBackStack(R.id.homeFragment, false)
                }

                R.id.nav_saved -> {
                    navController.navigate(R.id.savedFragment)
                }
            }

            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // ===========================
        // ✅ ICON SWITCH (☰ ↔ ←)
        // ===========================
        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {

                R.id.homeFragment -> {
                    btnNav.setImageResource(R.drawable.ic_menu)

                    bottomNav.menu.findItem(R.id.homeFragment).isChecked = true
                }

                R.id.savedFragment -> {
                    btnNav.setImageResource(R.drawable.ic_back)

                    bottomNav.menu.findItem(R.id.savedFragment).isChecked = true
                }
            }
        }

        // ===========================
        // ✅ SEARCH LISTENER (UI ONLY)
        // ===========================
    }
}



//
//import android.os.Bundle
//import androidx.appcompat.app.ActionBarDrawerToggle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.drawerlayout.widget.DrawerLayout
//import androidx.navigation.fragment.NavHostFragment
//import com.example.movieappl.R
//import com.google.android.material.appbar.MaterialToolbar
//import com.google.android.material.bottomnavigation.BottomNavigationView
//import com.google.android.material.navigation.NavigationView
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
//        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
//        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
//        val navView = findViewById<NavigationView>(R.id.nav_view)
//
//        setSupportActionBar(toolbar)
//
//        // ✅ Nav Controller
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
//        val navController = navHostFragment.navController
//
//        // ✅ Drawer Toggle (☰ icon)
//        val toggle = ActionBarDrawerToggle(
//            this,
//            drawerLayout,
//            toolbar,
//            R.string.open,
//            R.string.close
//        )
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()
//
//        // ✅ Bottom Navigation
//        bottomNav.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.homeFragment -> {
//                    navController.navigate(R.id.homeFragment)
//                    true
//                }
//                R.id.savedFragment -> {
//                    navController.navigate(R.id.savedFragment)
//                    true
//                }
//                else -> false
//            }
//        }
//
//        // ✅ Drawer Navigation Click
//        navView.setNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.nav_home -> {
//                    navController.navigate(R.id.homeFragment)
//                }
//                R.id.nav_saved -> {
//                    navController.navigate(R.id.savedFragment)
//                }
//            }
//            drawerLayout.closeDrawers()
//            true
//        }
//    }
//}