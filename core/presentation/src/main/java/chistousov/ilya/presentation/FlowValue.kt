package chistousov.ilya.presentation

import androidx.lifecycle.LifecycleOwner

/**
 * Wrapper over [StateFlow] to avoid duplication if [ViewModel]
 */
interface FlowValue <T> {

    fun collect(lifecycleOwner: LifecycleOwner, block: (T) -> Unit)

    fun getValue(): T
}