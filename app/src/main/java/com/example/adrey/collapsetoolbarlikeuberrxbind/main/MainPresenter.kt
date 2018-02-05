package com.example.adrey.collapsetoolbarlikeuberrxbind.main

import android.widget.EditText
import com.example.adrey.collapsetoolbarlikeuberrxbind.Utils
import com.example.adrey.collapsetoolbarlikeuberrxbind.base.BasePresenter
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Muh Adrey Fatawallah on 2/5/2018.
 */
class MainPresenter : BasePresenter<MainInterface.MainView>(),
        MainInterface.MainPresenter {

    override fun checkValid(type: String, editText: EditText) {
        getComposite().add(RxTextView.textChanges(editText)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .filter { it.isNotEmpty() }
                .map {
                    if (type == "email")
                        Utils.authEmail(it.toString())
                    else
                        it.length > 6}
                .subscribe { getView()!!.valid(type, it) })
    }
}