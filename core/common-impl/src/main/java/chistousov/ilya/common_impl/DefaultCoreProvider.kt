package chistousov.ilya.common_impl

import android.content.Context
import chistousov.ilya.common.CommonUi
import chistousov.ilya.common.CoreProvider
import chistousov.ilya.common.Resource

class DefaultCoreProvider(
    private val appContext: Context,
    override val commonUi: CommonUi = AndroidCommonUi(appContext),
    override val resource: Resource = AndroidResource(appContext)
) : CoreProvider