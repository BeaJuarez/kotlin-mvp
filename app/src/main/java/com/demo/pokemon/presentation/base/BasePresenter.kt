package com.demo.pokemon.presentation.base

/**
 *
 * @param <T> - View class
</T> */
/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the BaseView that
 * can be accessed from the children classes by calling getBaseView().
 */
open class BasePresenter<T : BaseView> : Presenter<T> {

    var view: T? = null
        private set

    override fun attachView(view: T) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    private val isViewAttached: Boolean
        get() = view != null

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }


    private class MvpViewNotAttachedException internal constructor() : RuntimeException("Please call Presenter.attachView(View) before" + " requesting data to the Presenter")

}

