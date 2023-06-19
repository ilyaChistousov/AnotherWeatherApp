package chistousov.ilya.navigation.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import chistousov.ilya.common_impl.ActivityRequired
import chistousov.ilya.navigation.databinding.ActivityMainBinding
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var activityRequired: Set<@JvmSuppressWildcards ActivityRequired>

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        activityRequired.forEach {
            it.onCreate(this)
        }
    }
}