package chistousov.ilya.forecast.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import chistousov.ilya.forecast.R
import chistousov.ilya.forecast.databinding.ForecastItemBinding
import chistousov.ilya.forecast.domain.entity.ForecastItem

class ForecastAdapter :
    ListAdapter<ForecastItem, ForecastAdapter.ForecastViewHolder>(DiffUtilForecast()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val binding = ForecastItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ForecastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.create(getItem(position))
    }

    class ForecastViewHolder(private val binding: ForecastItemBinding) : ViewHolder(binding.root) {

        fun create(forecastItem: ForecastItem) {
            binding.itemDate.text = forecastItem.time
            binding.itemTemp.text = binding.root.context.getString(
                R.string.temp, forecastItem.temp.toString()
            )
        }
    }

    class DiffUtilForecast : DiffUtil.ItemCallback<ForecastItem>() {

        override fun areItemsTheSame(oldItem: ForecastItem, newItem: ForecastItem): Boolean {
            return oldItem.time == newItem.time
        }

        override fun areContentsTheSame(oldItem: ForecastItem, newItem: ForecastItem): Boolean {
            return oldItem == newItem
        }
    }
}