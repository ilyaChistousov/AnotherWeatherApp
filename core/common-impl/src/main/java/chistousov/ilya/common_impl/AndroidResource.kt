package chistousov.ilya.common_impl

import android.content.Context
import chistousov.ilya.common.Resource

class AndroidResource(
    private val appContext: Context
) : Resource {

    override fun getString(resId: Int): String {
        return appContext.getString(resId)
    }
}