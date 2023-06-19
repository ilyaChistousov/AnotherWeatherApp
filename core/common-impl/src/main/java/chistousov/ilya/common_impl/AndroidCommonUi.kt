package chistousov.ilya.common_impl

import android.content.Context
import android.widget.Toast
import chistousov.ilya.common.CommonUi

class AndroidCommonUi(private val appContext: Context) : CommonUi {

    override fun showToast(message: String) {
        Toast.makeText(appContext, message, Toast.LENGTH_SHORT).show()
    }
}