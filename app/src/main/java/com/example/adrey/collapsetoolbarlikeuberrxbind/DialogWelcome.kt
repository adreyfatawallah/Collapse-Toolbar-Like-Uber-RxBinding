package com.example.adrey.collapsetoolbarlikeuberrxbind

import android.content.Context
import com.example.adrey.collapsetoolbarlikeuberrxbind.base.BaseDialog
import kotlinx.android.synthetic.main.dialog_welcome.*

/**
 * Created by Muh Adrey Fatawallah on 2/6/2018.
 */
class DialogWelcome(context: Context, themeResId: Int) : BaseDialog(context, themeResId) {

    override fun setLayout(): Int = R.layout.dialog_welcome

    override fun codeHere() {
        bt_welcome.setOnClickListener { dismiss() }
    }
}