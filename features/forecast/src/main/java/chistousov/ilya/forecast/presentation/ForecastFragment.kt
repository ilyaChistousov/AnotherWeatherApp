package chistousov.ilya.forecast.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import chistousov.ilya.common.Result
import chistousov.ilya.forecast.R
import chistousov.ilya.forecast.databinding.FragmentForecastBinding
import chistousov.ilya.forecast.domain.entity.Forecast
import chistousov.ilya.forecast.presentation.adapter.ForecastAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForecastFragment : Fragment(R.layout.fragment_forecast) {

    private var _binding: FragmentForecastBinding? = null
    private val binding: FragmentForecastBinding get() = _binding!!

    private val viewModel: ForecastViewModel by viewModels()
    private val adapter = ForecastAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentForecastBinding.bind(view)

        collectForecast()
    }

    private fun collectForecast() {
        viewModel.forecastItem.collect(viewLifecycleOwner) {
            when(it) {
                is Result.Loading -> {
                    Log.d("ForecastFragment", it.toString())
                }
                is Result.Success -> {
                    Log.d("ForecastFragment", it.value.toString())
                    adapter.submitList(it.value.forecast)
                    binding.recycler.adapter = adapter
                    initFields(it.value)
                }
                is Result.Error -> {

                }
            }
        }
    }

    private fun initFields(forecast: Forecast) {
        binding.cityName.text = forecast.city
        binding.temp.text = getString(R.string.temp, forecast.temp.toString())
        binding.maxTemp.text = getString(R.string.max_temp, forecast.tempMax.toString())
        binding.minTemp.text = getString(R.string.min_temp, forecast.tempMin.toString())
    }
}