package com.demo.pokemon.presentation.widget

interface SpinnerLoading {
    fun show()
    fun show(listener: SpinnerLoadingListener)

    fun dismiss()
    fun dismiss(listener: SpinnerLoadingListener)
}
