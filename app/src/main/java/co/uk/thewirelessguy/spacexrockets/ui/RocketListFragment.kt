package co.uk.thewirelessguy.spacexrockets.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import co.uk.thewirelessguy.spacexrockets.R
import co.uk.thewirelessguy.spacexrockets.databinding.FragmentRocketListBinding
import co.uk.thewirelessguy.spacexrockets.extension.setEmptyStateView
import co.uk.thewirelessguy.spacexrockets.extension.stop
import co.uk.thewirelessguy.spacexrockets.extension.toast
import co.uk.thewirelessguy.spacexrockets.viewmodel.RocketListViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class RocketListFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    private var _binding: FragmentRocketListBinding? = null
    private val binding get() = _binding!!
    private lateinit var commitsAdapter: RocketListAdapter
    private val viewModel: RocketListViewModel by viewModels()
    @Inject lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRocketListBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        binding.rocketList.apply {
            // Set LinearLayoutManager using default vertical list:
            layoutManager = LinearLayoutManager(context)

            hasFixedSize() // Improve performance (use only with fixed size items)
            setItemViewCacheSize(20)

            // Set adapter and initialise with empty list:
            commitsAdapter = RocketListAdapter(mutableListOf()) {
                // Navigate to RocketDetailFragment and pass rocketId and rocket model of clicked item as an Intent extra
                val action = RocketListFragmentDirections.actionRocketListFragmentToDetailFragment(it.id, it)
                val navController = Navigation.findNavController(binding.root)
                navController.navigate(action)
            }
            adapter = commitsAdapter

            // Set a view to display when list is empty:
            adapter?.setEmptyStateView(binding.rocketListEmpty.root)
        }

        binding.swipeRefresh.setOnRefreshListener(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.rocketList.observe(viewLifecycleOwner) {
            commitsAdapter.setData(it.toMutableList())
        }

        viewModel.isNetworkErrorShown.observe(viewLifecycleOwner) {
            // Todo: display errors
        }
    }

    override fun onResume() {
        super.onResume()
        //loadData()
    }

    override fun onRefresh() {
        // Handle pull down to refresh
        loadData()
    }

    private fun loadData() {
        Timber.d("loadData")
        viewModel.refreshDataFromRepository()
        binding.swipeRefresh.stop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_filter -> {
                var filterActiveRockets = sharedPreferences.getBoolean("filter_active_rockets", false)
                // Toggle the filterRockets boolean value
                filterActiveRockets = !filterActiveRockets
                // Save updated filterRockets value
                sharedPreferences.edit {
                    putBoolean("filter_active_rockets", filterActiveRockets)
                }
                viewModel.rocketList
                context?.toast("Filter $filterActiveRockets")
            }

        }
        return super.onOptionsItemSelected(item)
    }


}