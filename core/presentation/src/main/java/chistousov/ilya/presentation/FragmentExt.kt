package chistousov.ilya.presentation

import androidx.fragment.app.Fragment

const val BASE_SCREEN_ARGS = "baseScreenArgs"

fun <T : BaseScreenArgs> Fragment.args(): T {
    return requireArguments().getSerializable(BASE_SCREEN_ARGS) as T
        ?: throw IllegalStateException("BaseScreenArgs is null")
}
