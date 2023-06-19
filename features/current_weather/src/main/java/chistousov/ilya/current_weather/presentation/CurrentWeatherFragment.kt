package chistousov.ilya.current_weather.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import chistousov.ilya.common.Result
import chistousov.ilya.current_weather.R
import chistousov.ilya.current_weather.databinding.FragmentCurrentWeatherBinding
import chistousov.ilya.current_weather.domain.entity.CurrentWeather
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrentWeatherFragment : Fragment(R.layout.fragment_current_weather) {

    private var _binding: FragmentCurrentWeatherBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CurrentWeatherViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCurrentWeatherBinding.bind(view)
        observeState()
    }

    private fun observeState() {
        viewModel.currentWeatherState.collect(viewLifecycleOwner) { state ->
            when(state) {
                is Result.Success -> {
                    initFields(state.value)
                } else -> {

                }
            }
        }
    }

    private fun initFields(currentWeather: CurrentWeather) {
        binding.cityName.text = currentWeather.city
        binding.temp.text = getString(R.string.temp, currentWeather.temp.toString())
        binding.maxTemp.text = getString(R.string.max_temp, currentWeather.tempMax.toString())
        binding.minTemp.text = getString(R.string.min_temp, currentWeather.tempMin.toString())
        initWeatherImage(currentWeather.description)
    }

    private fun initWeatherImage(description: String) {
        val imageDrawable = when(description) {
            "Clear" -> chistousov.ilya.theme.R.drawable.clear
            "Rain" -> chistousov.ilya.theme.R.drawable.rain
            "Snow" -> chistousov.ilya.theme.R.drawable.snow
            "Thunderstorm" -> chistousov.ilya.theme.R.drawable.thunderstorm
            "Mist" -> chistousov.ilya.theme.R.drawable.mist
            else -> chistousov.ilya.theme.R.drawable.clouds
        }
        binding.weatherImage.setImageResource(imageDrawable)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}