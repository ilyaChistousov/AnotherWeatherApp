package chistousov.ilya.presentation

import androidx.lifecycle.ViewModel
import chistousov.ilya.common.CommonUi
import chistousov.ilya.common.Core
import chistousov.ilya.common.Resource
import kotlinx.coroutines.flow.MutableStateFlow

open class BaseViewModel : ViewModel() {

    protected val resource: Resource = Core.resource

    protected  val commonUi: CommonUi = Core.commonUi
    protected fun <T> flowValue(value: T): FlowValue<T> {
        return MutableFlowValue(MutableStateFlow(value))
    }

    protected var <T>FlowValue<T>.value: T
        get() = this.getValue()
        set(value) {
            (this as MutableFlowValue).setValue(value)
        }

    protected fun showToast(message: String) {
        commonUi.showToast(message)
    }
}