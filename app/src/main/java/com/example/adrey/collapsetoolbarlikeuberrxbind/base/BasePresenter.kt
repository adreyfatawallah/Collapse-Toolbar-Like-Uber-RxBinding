package com.example.adrey.collapsetoolbarlikeuberrxbind.base

import android.content.Context
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Muh Adrey Fatawallah on 2/5/2018.
 */
abstract class BasePresenter<T: View> : Presenter<T> {

    private var view: T? = null
    private var context: Context? = null
    private var composite: CompositeDisposable = CompositeDisposable()

    override fun onAttach(view: T, context: Context) {
        this.view = view
        this.context = context
    }

    override fun onDetach() {
        view = null
        context = null
        composite.clear()
    }

    fun getView(): T? = view

    fun getContext(): Context? = context

    fun getComposite(): CompositeDisposable = composite
}