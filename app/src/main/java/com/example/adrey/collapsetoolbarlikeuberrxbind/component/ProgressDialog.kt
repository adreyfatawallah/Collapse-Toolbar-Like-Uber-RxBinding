package com.example.adrey.collapsetoolbarlikeuberrxbind.component

import android.content.Context
import android.os.Handler
import com.example.adrey.collapsetoolbarlikeuberrxbind.R
import com.example.adrey.collapsetoolbarlikeuberrxbind.base.BaseDialog
import kotlinx.android.synthetic.main.component_progress_dialog.*

/**
 * Created by Muh Adrey Fatawallah on 2/6/2018.
 */
class ProgressDialog(context: Context, themeResId: Int) : BaseDialog(context, themeResId) {

    override fun setLayout(): Int = R.layout.component_progress_dialog

    override fun codeHere() {
        val handler = Handler()
        val pleaseWaiting = context.resources.getStringArray(R.array.please_waiting)
        var x = 0
        val runnable = object : Runnable {
            override fun run() {
                handler.postDelayed(this, 750)
                if (x < pleaseWaiting.size) {
                    tx_message_progress.text = pleaseWaiting[x]
                    x++
                } else {
                    tx_message_progress.text = context.getString(R.string.please_wait)
                    x = 0
                }
            }
        }
        handler.post(runnable)
    }
}