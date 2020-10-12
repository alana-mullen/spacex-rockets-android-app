package co.uk.thewirelessguy.spacexrockets.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import co.uk.thewirelessguy.spacexrockets.R
import co.uk.thewirelessguy.spacexrockets.databinding.ActivityMainBinding
import co.uk.thewirelessguy.spacexrockets.extension.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.nav_host_fragment).navigateUp()

}