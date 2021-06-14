package com.example.aerolineanj

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.aerolineanj.databinding.ActivityMainBinding
import com.example.aerolineanj.ui.Profile.ProfileFragment
import com.example.aerolineanj.ui.home.HomeFragment
import com.example.aerolineanj.ui.login.LoginActivity
import com.example.aerolineanj.ui.history.HistoryFragment

/*
    LAB 04 - Diseño y programacion de plataformas moviles

    Natalia Solano - Joy Bonilla
    Grupo 10am

 */

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private var homeFragment: HomeFragment = HomeFragment()
    private var profileFragment: ProfileFragment = ProfileFragment()
    private var historyFragment: HistoryFragment = HistoryFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_logout
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main, homeFragment).commit()
            }
            R.id.nav_gallery -> {
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main, profileFragment).commit()
            }
            R.id.nav_slideshow -> {
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main, historyFragment).commit()
            }
            R.id.nav_logout -> {
                var intent = Intent(this, LoginActivity::class.java)
                finish()
                startActivity(intent)
            }
        }
        return true
    }

}