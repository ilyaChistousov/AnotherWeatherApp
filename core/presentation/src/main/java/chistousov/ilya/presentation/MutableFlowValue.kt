package chistousov.ilya.presentation

import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.flow.MutableStateFlow

class MutableFlowValue<T>(
    private val flow: MutableStateFlow<T>
) : FlowValue<T> {

    override fun collect(lifecycleOwner: LifecycleOwner, block: (T) -> Unit) {
        this.flow.launchWhenStarted(lifecycleOwner, block)
    }

    override fun  getValue(): T {
        return this.flow.value
    }

    fun setValue(value: T) {
        this.flow.value = value
    }
}