package Portal

import Portal.a257.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.main_nav_host)

        appBarConfiguration = AppBarConfiguration.Builder(R.id.homeFragment,R.id.accountsFragment,
        R.id.dashboardFragment,R.id.settingsFragment)
            .setDrawerLayout(main_drawer_layout)
            .build()

        setSupportActionBar(main_toolbar)

        setupActionBarWithNavController(navController,appBarConfiguration)

        visibilityNavElements(navController)

    }

    private fun visibilityNavElements(navController: NavController) {

    }

    private fun hideBothNavigation(){

    }

    private fun showBothNavigation(){

    }

    private fun setupNavControl(){

    }

    fun exitApp(){

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

}

