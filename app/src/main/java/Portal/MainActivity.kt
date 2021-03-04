package Portal

import Portal.a257.R
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

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navController = findNavController(R.id.main_nav_host)

        val drawerToggle = ActionBarDrawerToggle(this,main_drawer_layout,R.string.open,R.string.close)
        main_drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        //Ove dvije linije koda su dodane zbog toga jer sam umjesto <fragment> stavio <FragmentContainerView>
        //Ako se odlucim vratiti na <fragment> onda zakomentirati ove dvije linije koda
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
        val navControler = navHostFragment.navController

        /*
        appBarConfiguration = AppBarConfiguration.Builder(R.id.vijestiNavItem,R.id.sportNavItem,
        R.id.obavijestiNavItem,R.id.zabavaNavItem,R.id.oglasnikNavItem,R.id.jaNovinarNavItem,R.id.vrijemeBottomNav,
            R.id.kontaktBottomNav,R.id.pretraziBottomNav)
            .setDrawerLayout(main_drawer_layout)
            .build()
        */
        //setupActionBarWithNavController(navController)
        //visibilityNavElements(navController)
    }
/*
    private fun visibilityNavElements(navController: NavController) {
        navController.addOnDestinationChangedListener{ _, destination, _ ->
            when (destination.id){
                R.id.kontaktBottomNav -> hideBothNavigation()
                R.id.obavijestiNavItem -> hideBottomNavigation()
                else -> showBothNavigation()
            }
        }
    }
*/
    private fun hideBothNavigation(){
        main_bottom_navigation_view?.visibility = View.GONE
        main_navigation_view?.visibility = View.GONE
        main_drawer_layout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }

    private fun hideBottomNavigation(){
        main_bottom_navigation_view?.visibility = View.GONE
        main_navigation_view?.visibility = View.VISIBLE
        main_drawer_layout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)

        main_navigation_view?.setupWithNavController(navController)
    }

    private fun showBothNavigation(){
        main_bottom_navigation_view?.visibility = View.VISIBLE
        main_navigation_view?.visibility = View.VISIBLE
        main_drawer_layout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        setupNavControl()
    }

    private fun setupNavControl(){
        main_navigation_view?.setupWithNavController(navController)
        main_bottom_navigation_view?.setupWithNavController(navController)
    }

    fun exitApp(){
        this.finishAffinity()
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,appBarConfiguration)
    }

    override fun onBackPressed() {
        when{
            main_drawer_layout.isDrawerOpen(GravityCompat.START) -> {
                main_drawer_layout.closeDrawer(GravityCompat.START)
            }
            else -> {
                super.onBackPressed()
            }
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            android.R.id.home -> {
                main_drawer_layout.openDrawer(GravityCompat.START)
                true
            }
            else -> false
        }
    }
}

