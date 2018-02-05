package com.example.adrey.collapsetoolbarlikeuberrxbind

import android.content.Context
import android.support.v4.content.ContextCompat
import android.widget.EditText
import java.util.regex.Pattern

/**
 * Created by Muh Adrey Fatawallah on 2/5/2018.
 */
object Utils {

    fun authEmail(email: String): Boolean {
        val patternEmail = Pattern.compile("^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")
        val matcherEmail = patternEmail.matcher(email)
        return matcherEmail.matches()
    }

    fun resultValid(context: Context, boolean: Boolean, editText: EditText) {
        if (boolean) {
            editText.setTextColor(ContextCompat.getColor(context, R.color.black))
            editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_success, 0)
        } else {
            editText.setTextColor(ContextCompat.getColor(context, R.color.red))
            editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_warning, 0)
        }
    }
}