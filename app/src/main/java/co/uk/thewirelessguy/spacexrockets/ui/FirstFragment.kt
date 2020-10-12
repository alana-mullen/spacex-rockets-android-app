package co.uk.thewirelessguy.spacexrockets.ui

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.edit
import androidx.navigation.fragment.findNavController
import co.uk.thewirelessguy.spacexrockets.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class FirstFragment : Fragment() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            navigateToMain()
        }

        /**
         * If first opening then set first_time else open RocketListFragment
         */
        var firstTime = sharedPreferences.getBoolean("first_time", true)
        when {
            !firstTime -> {
                navigateToMain()
            }
            else -> {
                firstTime = !firstTime
                sharedPreferences.edit {
                    putBoolean("first_time", firstTime)
                }
            }
        }


    }

    private fun navigateToMain() {
        findNavController().apply {
            // Todo: remove back arrow after navigation to RocketListFragment
            popBackStack(R.id.RocketList, true)
            navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment())
        }
    }

}