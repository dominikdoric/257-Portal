package Portal

import Portal.a257.R
import Portal.fragmenti.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Externalizable

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val drawerToggle = ActionBarDrawerToggle(this, main_drawer_layout, R.string.open, R.string.close)
        main_drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        val naslovnicaFragment = NaslovnicaFragment()
        val vijestiFragment = VijestiFragment()
        val obavijestiFragment = ObavijestiFragment()
        val oglasnikFragment = OglasnikFragment()
        val sportFragment = SportFragment()
        val zabavaFragment = ZabavaFragment()
        val vrijemeFragment = VrijemeFragment()
        val infoFragment = InfoFragment()
        val jaNovinarFragment = JaNovinarFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout_host,naslovnicaFragment)
            commit()
        }

        navigation_drawer.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.vijestiNavDrawer -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout_host, vijestiFragment)
                        addToBackStack(null)
                        commit()
                        main_drawer_layout.closeDrawer(GravityCompat.START)
                    }
                    true
                }
                R.id.obavijestiNavDrawer -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout_host, obavijestiFragment)
                        addToBackStack(null)
                        commit()
                        main_drawer_layout.closeDrawer(GravityCompat.START)
                    }
                    true
                }
                R.id.oglasnikNavDrawer -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout_host, oglasnikFragment)
                        addToBackStack(null)
                        commit()
                        main_drawer_layout.closeDrawer(GravityCompat.START)
                    }
                    true
                }
                R.id.sportNavDrawer -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout_host, sportFragment)
                        addToBackStack(null)
                        commit()
                        main_drawer_layout.closeDrawer(GravityCompat.START)
                    }
                    true
                }
                R.id.zabavaNavDrawer -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout_host, zabavaFragment)
                        addToBackStack(null)
                        commit()
                        main_drawer_layout.closeDrawer(GravityCompat.START)
                    }
                    true
                }
                else -> false
            }
        }

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.vrijemeBottomNav -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout_host, vrijemeFragment)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.naslovnicaBottomNav -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout_host, naslovnicaFragment)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.infoBottomNav -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout_host, infoFragment)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.jaNovinarBottomNav -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout_host, jaNovinarFragment)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                else -> false
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                main_drawer_layout.openDrawer(GravityCompat.START)
                true
            }
            else -> false
        }
    }
}

