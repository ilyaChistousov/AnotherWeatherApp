package chistousov.ilya.common

/**
 * Common global variables.
 * Needed to call [Core.init] before any interaction with core
 * Usually used in 'Application.onCreate()'
 */
object Core {

    private lateinit var coreProvider: CoreProvider

    val commonUi: CommonUi
        get() = coreProvider.commonUi

    val resource: Resource
        get() = coreProvider.resource

    fun init(coreProvider: CoreProvider) {
        this.coreProvider = coreProvider
    }
}