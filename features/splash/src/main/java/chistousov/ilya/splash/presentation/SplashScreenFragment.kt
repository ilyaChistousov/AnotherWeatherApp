package chistousov.ilya.splash.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import chistousov.ilya.splash.R
import chistousov.ilya.splash.databinding.FragmentSplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen), LocationListener {

    private var binding: FragmentSplashScreenBinding? = null

    private val viewModel by viewModels<SplashScreenViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashScreenBinding.bind(view)

        checkLocationPermission()
    }

    private fun checkLocationPermission() {
        val locationManager =
            requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val hasPermission = requireActivity()
            .checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED

        Log.d("SplashScreenFragment", "hasPermission $hasPermission")
        if (!hasPermission) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSION_CODE
            )
            permissionListener().launch(Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                1000,
                10f,
                this
            )
        }
    }

    private fun permissionListener(): ActivityResultLauncher<String> {
        return registerForActivityResult(
            ActivityResultContracts.RequestPermission()) {
            if (it) {
                Log.d("SplashScreenFragment", "Permission granted ")
            } else {
                Log.d("SplashScreenFragment", "Permission denied")
                viewModel.loadDefaultLocation()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onLocationChanged(location: Location) {
        viewModel.loadCurrentLocation(location.latitude, location.longitude)
    }

    companion object {
        private const val PERMISSION_CODE = 100
    }
}