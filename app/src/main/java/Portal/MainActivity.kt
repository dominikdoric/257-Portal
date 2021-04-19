package Portal

import Portal.a257.R
import Portal.firestore.Firestore
import Portal.firestore.RecyclerActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_main) as NavHostFragment
        navController = navHostFragment.findNavController()
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.naslovnicaBottomNav,
                R.id.vrijemeBottomNav,
                R.id.infoBottomNav,
                R.id.kontaktBottomNav,
                R.id.vijestiNavDrawer,
                R.id.sportNavDrawer,
                R.id.obavijestiNavDrawer,
                R.id.oglasnikNavDrawer,
                R.id.poljoprivredaNavDrawer,
                R.id.priceCitateljaNavDrawer,
                R.id.zabavaNavDrawer
            ),
            main_drawer_layout
        )
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottom_navigation.setupWithNavController(navController)
        navigation_drawer.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.firestore){
            val intent = Intent(this, Firestore::class.java)
            startActivity(intent)
        }
        if (item.itemId == R.id.firestoreRecycler){
            val intent = Intent(this,RecyclerActivity::class.java)
            startActivity(intent)
        }
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}

