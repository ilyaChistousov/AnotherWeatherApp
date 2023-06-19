package chistousov.ilya.navigation.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import chistousov.ilya.common_impl.ActivityRequired
import chistousov.ilya.navigation.R
import chistousov.ilya.navigation.databinding.ActivityMainBinding
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