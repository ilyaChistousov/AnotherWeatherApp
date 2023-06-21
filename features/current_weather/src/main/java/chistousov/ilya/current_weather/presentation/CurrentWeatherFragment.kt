package chistousov.ilya.current_weather.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
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

//    class Screen(
//        val isSuccessLoading: Boolean
//    ) : BaseScreenArgs
//
//    @Inject
//    lateinit var factory: CurrentWeatherViewModel.Factory
//    private val viewModel: CurrentWeatherViewModel by viewModelFactory {
//        factory.create(args())
//    }

    private val viewModel: CurrentWeatherViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCurrentWeatherBinding.bind(view)
        observeState()

        launchDetails()
        launchForecast()
        onBackPressed()
    }

    private fun observeState() {
        viewModel.currentWeatherState.collect(viewLifecycleOwner) { state ->
            when(state) {
                is Result.Loading -> {
                    initFieldsVisibility(binding.loadingBar)
                }
                is Result.Success -> {
                    initFieldsVisibility(binding.contentContainer)
                    initFields(state.value)
                }
                is Result.Error -> {
                    initFieldsVisibility(binding.errorMessage)
                }
            }
        }
    }

    private fun initFieldsVisibility(visibleView: View) {
        arrayOf(binding.contentContainer, binding.errorMessage, binding.loadingBar).forEach {
            it.isVisible = it == visibleView
        }
    }

    private fun initFields(currentWeather: CurrentWeather) {
        binding.cityName.text = currentWeather.city
        binding.temp.text = getString(R.string.temp, currentWeather.temp.toString())
        binding.maxTemp.text = getString(R.string.max_temp, currentWeather.tempMax.toString())
        binding.minTemp.text = getString(R.string.min_temp, currentWeather.tempMin.toString())
        initWeatherImage(currentWeather.description)
    }

    private fun initWeatherImage(main: String) {
        val imageDrawable = when(main) {
            "Clear" -> chistousov.ilya.theme.R.drawable.clear
            "Rain" -> chistousov.ilya.theme.R.drawable.rain
            "Snow" -> chistousov.ilya.theme.R.drawable.snow
            "Thunderstorm" -> chistousov.ilya.theme.R.drawable.thunderstorm
            "Mist" -> chistousov.ilya.theme.R.drawable.mist
            else -> chistousov.ilya.theme.R.drawable.clouds
        }
        binding.weatherImage.setImageResource(imageDrawable)
    }

    private fun launchDetails() {
        binding.weatherDetails.setOnClickListener {
            viewModel.launchWeatherDetails()
        }
    }

    private fun launchForecast() {
        binding.weatherForecast.setOnClickListener {
            viewModel.launchForecast()
        }
    }

    private fun onBackPressed() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().moveTaskToBack(true)
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}