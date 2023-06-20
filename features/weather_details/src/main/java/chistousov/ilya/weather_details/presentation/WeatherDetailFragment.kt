package chistousov.ilya.weather_details.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import chistousov.ilya.common.Result
import chistousov.ilya.presentation.BaseScreenArgs
import chistousov.ilya.weather_details.R
import chistousov.ilya.weather_details.databinding.FragmentWeatherDetailBinding
import chistousov.ilya.weather_details.domain.entity.WeatherDetails
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherDetailFragment : Fragment(R.layout.fragment_weather_detail) {

    private var _binding: FragmentWeatherDetailBinding? = null
    private val binding: FragmentWeatherDetailBinding get() = _binding!!
    private val viewModel: WeatherDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentWeatherDetailBinding.bind(view)

        observeDetails()
    }

    private fun observeDetails() {
        viewModel.weatherDetails.collect(viewLifecycleOwner) { details ->
            when (details) {
                is Result.Success -> {
                    initFields(details.value)
                }
                else -> {

                }
            }
        }
    }

    private fun initFields(weatherDetails: WeatherDetails) {
        binding.cityName.text = weatherDetails.city
        binding.temp.text = getString(R.string.temp, weatherDetails.temp.toString())
        binding.maxTemp.text = getString(R.string.max_temp, weatherDetails.tempMax.toString())
        binding.minTemp.text = getString(R.string.min_temp, weatherDetails.tempMin.toString())
        binding.weather.text = getString(R.string.weather, weatherDetails.description)
        binding.wind.text = getString(R.string.wind, weatherDetails.wind.toString())
        binding.pressure.text = getString(R.string.pressure, weatherDetails.pressure.toString())
        binding.humidity.text = getString(R.string.humidity, weatherDetails.humidity.toString())
        binding.feelsLike.text = getString(R.string.feels_like, weatherDetails.feelsLike.toString())
        binding.clouds.text = getString(R.string.cloudiness, weatherDetails.clouds.toString())
    }
}