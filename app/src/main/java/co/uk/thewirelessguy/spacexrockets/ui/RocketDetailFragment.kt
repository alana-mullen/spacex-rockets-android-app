package co.uk.thewirelessguy.spacexrockets.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import co.uk.thewirelessguy.spacexrockets.databinding.FragmentRocketDetailBinding
import co.uk.thewirelessguy.spacexrockets.extension.loadUrl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RocketDetailFragment : Fragment() {

    private var _binding: FragmentRocketDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRocketDetailBinding.inflate(inflater, container, false)

        getRocketDetail()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getRocketDetail() {
        arguments?.let {
            val passedArguments = RocketDetailFragmentArgs.fromBundle(it)
            val rocketDetail = passedArguments.rocket
            lifecycleScope.launch {
                binding.apply {
                    image.loadUrl(rocketDetail.image)
                    rocketName.text = rocketDetail.rocketName
                    description.text = rocketDetail.description
                    wikipedia.text = rocketDetail.wikipedia
                }
            }
        }
    }

}