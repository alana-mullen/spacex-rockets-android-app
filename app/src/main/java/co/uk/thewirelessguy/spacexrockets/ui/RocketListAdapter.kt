package co.uk.thewirelessguy.spacexrockets.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.uk.thewirelessguy.spacexrockets.databinding.RocketListItemBinding
import co.uk.thewirelessguy.spacexrockets.extension.loadUrl
import co.uk.thewirelessguy.spacexrockets.model.Rockets

class RocketListAdapter(
    private var items: MutableList<Rockets>,
    private val listener: (Rockets) -> Unit
) : RecyclerView.Adapter<RocketListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding: RocketListItemBinding = RocketListItemBinding.inflate(
            LayoutInflater.from(
                parent.context
            ), parent, false
        )
        return ViewHolder(binding, listener)
    }

    override fun getItemCount() = items.size

    internal fun setData(data: MutableList<Rockets>?) {
        // Assign the list to the RecyclerView. If data is null, assign an empty list to the adapter.
        this.items = data ?: mutableListOf()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    class ViewHolder(
        private val itemBinding: RocketListItemBinding,
        private val listener: (Rockets) -> Unit
    ) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

        private lateinit var rocket: Rockets

        init {
            itemBinding.root.setOnClickListener(this)
        }

        fun bind(item: Rockets) {
            this.rocket = item
            itemBinding.rocketName.text = item.rocketName
            itemBinding.firstFlight.text = item.firstFlightFormatted
            itemBinding.country.text= item.country
            itemBinding.image.loadUrl(item.image)
        }

        override fun onClick(v: View?) {
            listener(rocket)
        }

    }
}
