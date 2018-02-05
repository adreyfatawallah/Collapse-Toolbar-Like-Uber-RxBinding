package com.example.adrey.collapsetoolbarlikeuberrxbind.component

import android.content.Context
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.inputmethod.InputMethodManager
import android.widget.RelativeLayout
import com.example.adrey.collapsetoolbarlikeuberrxbind.R
import kotlinx.android.synthetic.main.component_form_login.view.*

/**
 * Created by Muh Adrey Fatawallah on 2/5/2018.
 */
class FormLogin(context: Context, attributeSet: AttributeSet) : RelativeLayout(context, attributeSet) {

    init {
        LayoutInflater.from(context).inflate(R.layout.component_form_login, this, true)
        val values = context.obtainStyledAttributes(attributeSet, R.styleable.FormLogin)

        title.text = values.getString(R.styleable.FormLogin_fl_title)
        val drawble = values.getDrawable(R.styleable.FormLogin_fl_icon)
        icon.setImageDrawable(drawble)
        layout.isPasswordVisibilityToggleEnabled = values.getBoolean(R.styleable.FormLogin_fl_password_toggle, false)
        when (values.getString(R.styleable.FormLogin_fl_input_type)) {
            "text" -> edittext.inputType = InputType.TYPE_CLASS_TEXT
            "email" -> edittext.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            "phone" -> edittext.inputType = InputType.TYPE_CLASS_PHONE
            "password" -> edittext.transformationMethod = PasswordTransformationMethod.getInstance()
        }
        values.recycle()
    }

    fun getText() : String = edittext.text.toString()

    fun lostFocus() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(edittext.windowToken, 0)
    }
}