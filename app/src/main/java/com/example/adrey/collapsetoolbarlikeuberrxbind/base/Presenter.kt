package com.example.adrey.collapsetoolbarlikeuberrxbind.base

import android.content.Context
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Muh Adrey Fatawallah on 2/5/2018.
 */
interface Presenter<in T: View> {

    fun onAttach(view: T, context: Context)

    fun onDetach()
}