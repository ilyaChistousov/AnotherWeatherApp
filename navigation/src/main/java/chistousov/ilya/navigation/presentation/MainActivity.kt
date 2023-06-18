package chistousov.ilya.navigation.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import chistousov.ilya.navigation.databinding.ActivityMainBinding
import chistousov.ilya.navigation.presentation.navigation.AppComponentRouter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var componentRouter: AppComponentRouter

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        componentRouter.setActivity(this)
        componentRouter.setNavGraph()
    }
}