package com.definelab.assingment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.definelab.assingment.ui.allmatches.AllMatchesFragment
import com.definelab.assingment.ui.savedmatches.SavedMatchesFragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val navView = findViewById<NavigationView>(R.id.nav_view)
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
4
        setSupportActionBar(toolbar)

        val toggle = androidx.appcompat.app.ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.open,
            R.string.close
        )

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        replaceFragment(AllMatchesFragment())

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_all_matches -> {
                    replaceFragment(AllMatchesFragment())
                }
                R.id.nav_saved_matches -> {
                    replaceFragment(SavedMatchesFragment())
                }
            }
            drawer.closeDrawers()
            true
        }

        toggle.drawerArrowDrawable.color = resources.getColor(R.color.white, theme)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}