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

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)
        navController = findNavController(R.id.main_nav_host)

        gumbInfo.setOnClickListener(this)
        gumbJaNovinar.setOnClickListener(this)
        gumbNaslovnica.setOnClickListener(this)
        gumbObavijesti.setOnClickListener(this)
        gumbOglasnik.setOnClickListener(this)
        gumbSport.setOnClickListener(this)
        gumbVijesti.setOnClickListener(this)
        gumbVrijeme.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.gumbInfo -> {
                navController.navigate(R.id.action_naslovnicaFragment_to_infoFragment2)
            }
        }
    }
}

