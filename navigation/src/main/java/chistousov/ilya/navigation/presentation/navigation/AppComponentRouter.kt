package chistousov.ilya.navigation.presentation.navigation

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import chistousov.ilya.common_impl.ActivityRequired
import chistousov.ilya.navigation.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppComponentRouter @Inject constructor(
    private val destinationProvider: DestinationProvider
) : ActivityRequired {

    private var activity: FragmentActivity? = null

    override fun onCreate(activity: FragmentActivity) {
        this.activity = activity
        setNavGraph()
    }

    private fun setNavGraph() {
        val graph = getNavController().navInflater.inflate(
            destinationProvider.provideNavigationGraphId()
        )
        graph.setStartDestination(destinationProvider.provideStartDestinationId())
        getNavController().graph = graph
    }

    private fun getNavController(): NavController {
        val fragmentManager = requireActivity().supportFragmentManager
        val navHost = fragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        return navHost.navController
    }

    fun launch(destinationId: Int) {
        getNavController().navigate(destinationId)
    }

    private fun requireActivity(): FragmentActivity {
        return activity!!
    }
}