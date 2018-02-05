package com.example.adrey.collapsetoolbarlikeuberrxbind.main

import android.os.Handler
import android.support.v4.content.res.ResourcesCompat
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.example.adrey.collapsetoolbarlikeuberrxbind.DialogWelcome
import com.example.adrey.collapsetoolbarlikeuberrxbind.R
import com.example.adrey.collapsetoolbarlikeuberrxbind.Utils
import com.example.adrey.collapsetoolbarlikeuberrxbind.base.BaseActivity
import com.example.adrey.collapsetoolbarlikeuberrxbind.component.ProgressDialog
import kotlinx.android.synthetic.main.component_form_login.view.*
import kotlinx.android.synthetic.main.layout_main.*

class MainActivity : BaseActivity(), MainInterface.MainView, View.OnClickListener {

    private val mainPresenter = MainPresenter()
    private var email = false
    private var passwd = false

    override fun setLayout(): Int = R.layout.activity_main

    override fun codeHere() {
        onAttachView()

        title = getString(R.string.please_login)
        setToolbar(2)

        mainPresenter.checkValid("email", fl_user.edittext)
        mainPresenter.checkValid("passwd", fl_pass.edittext)

        bt_login.setOnClickListener(this)
    }

    override fun onAttachView() {
        mainPresenter.onAttach(this, this, composite)
    }

    override fun valid(type: String, valid: Boolean) {
        if (type == "email") {
            email = valid
            Utils.resultValid(this, email, fl_user.edittext)
        }
        else {
            passwd = valid
            Utils.resultValid(this, passwd, fl_pass.edittext)
        }

        bt_login.isEnabled = (email && passwd)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.bt_login -> {
                val progressDialog = ProgressDialog(this, R.style.DialogDefault)
                progressDialog.show()

                Handler().postDelayed({
                    progressDialog.dismiss()

                    val dialog = DialogWelcome(this, R.style.DialogDefault)
                    dialog.window.setGravity(Gravity.CENTER)
                    dialog.window.setBackgroundDrawable(ResourcesCompat.getDrawable(resources, R.drawable.bg_dialog, null))
                    dialog.window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                    dialog.show()
                }, 5000)
            }
        }
    }

    override fun onDetachView() {
        mainPresenter.onDetach()
    }

    override fun setMenu(): Int = 0

    override fun onClickHome() {
        finish()
    }

    override fun onDestroyActivity() {
        onDetachView()
    }
}
