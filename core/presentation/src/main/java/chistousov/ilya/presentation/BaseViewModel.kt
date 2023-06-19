package chistousov.ilya.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

open class BaseViewModel : ViewModel() {

    protected fun <T> flowValue(value: T): FlowValue<T> {
        return MutableFlowValue(MutableStateFlow(value))
    }

    protected var <T>FlowValue<T>.value: T
        get() = this.getValue()
        set(value) {
            (this as MutableFlowValue).setValue(value)
        }
}