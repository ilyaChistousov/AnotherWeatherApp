package chistousov.ilya.splash.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import chistousov.ilya.common.Result
import chistousov.ilya.splash.R
import chistousov.ilya.splash.databinding.FragmentSplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {

    private var binding: FragmentSplashScreenBinding? = null

    private val viewModel by viewModels<SplashScreenViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashScreenBinding.bind(view)

        collectLoading()
    }

    private fun collectLoading() {
        viewModel.loadingState.collect(viewLifecycleOwner) {
            when (it) {
                is Result.Loading -> {
                    Log.d("SplashScreenFragment", "Loading")
                }
                is Result.Success -> {
                    viewModel.launchCurrentWeather(true)
                }
                is Result.Error -> {
                    viewModel.launchCurrentWeather(false)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}