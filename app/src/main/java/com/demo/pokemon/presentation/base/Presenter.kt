package com.demo.pokemon.presentation.base

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the BaseView type that wants to be attached with.
 */
interface Presenter<in V : BaseView> {

    fun attachView(view: V)

    fun detachView()
}
