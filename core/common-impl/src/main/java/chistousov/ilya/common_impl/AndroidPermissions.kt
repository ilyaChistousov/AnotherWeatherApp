package chistousov.ilya.common_impl

import android.content.Context
import android.content.pm.PackageManager
import androidx.fragment.app.FragmentActivity
import chistousov.ilya.common.Permissions

class AndroidPermissions(
    private val appContext: Context
): Permissions, ActivityRequired {

    private var activity: FragmentActivity? = null

    override fun onCreate(activity: FragmentActivity) {
        this.activity = activity
    }

    override fun checkPermission(permission: String): Boolean {
        return appContext.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    override fun requestPermission(permission: String) {
        activity?.requestPermissions(arrayOf((permission)), REQUEST_CODE)
    }

    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        activity?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private companion object {
        const val REQUEST_CODE = 100
    }
}