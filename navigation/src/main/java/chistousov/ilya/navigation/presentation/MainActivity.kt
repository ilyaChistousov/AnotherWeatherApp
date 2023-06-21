package chistousov.ilya.navigation.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import chistousov.ilya.common_impl.ActivityRequired
import chistousov.ilya.navigation.R
import chistousov.ilya.navigation.databinding.ActivityMainBinding
import chistousov.ilya.navigation.presentation.navigation.AppComponentRouter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var appComponentRouter: AppComponentRouter

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        appComponentRouter.onCreate(this)
    }
}