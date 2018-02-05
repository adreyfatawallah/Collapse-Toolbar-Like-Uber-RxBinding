package com.example.adrey.collapsetoolbarlikeuberrxbind.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle

/**
 * Created by Muh Adrey Fatawallah on 2/5/2018.
 */
abstract class BaseDialog(context: Context, themeResId: Int) : Dialog(context, themeResId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())

        setCancelable(false)
        setCanceledOnTouchOutside(false)

        codeHere()
    }

    abstract fun setLayout(): Int

    abstract fun codeHere()
}