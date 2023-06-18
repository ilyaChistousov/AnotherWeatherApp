package chistousov.ilya.navigation.presentation.navigation

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import chistousov.ilya.navigation.R
import javax.inject.Inject

class AppComponentRouter @Inject constructor(
    private val destinationProvider: DestinationProvider
) {

    private var activity: FragmentActivity? = null

    fun setActivity(activity: FragmentActivity) {
        this.activity = activity
    }

    fun setNavGraph() {
        val graph = getNavController().navInflater.inflate(
            destinationProvider.provideNavigationGraphId()
        )
        graph.setStartDestination(destinationProvider.provideStartDestinationId())
        getNavController().graph = graph
    }

    private fun getNavController(): NavController {
        val fragmentManager = activity?.supportFragmentManager
        val navHost = fragmentManager?.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        return navHost.navController
    }

    fun launch(destinationId: Int) {
        getNavController().navigate(destinationId)
    }

    fun pop() {
        requireActivity().onBackPressedDispatcher.onBackPressed()
    }

    private fun requireActivity(): FragmentActivity {
        return activity!!
    }
}