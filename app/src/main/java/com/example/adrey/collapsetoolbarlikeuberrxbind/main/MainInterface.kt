package com.example.adrey.collapsetoolbarlikeuberrxbind.main

import android.widget.EditText
import com.example.adrey.collapsetoolbarlikeuberrxbind.base.View

/**
 * Created by Muh Adrey Fatawallah on 2/5/2018.
 */
interface MainInterface {

    interface MainView : View {

        fun valid(type: String, valid: Boolean)
    }

    interface MainPresenter {

        fun checkValid(type: String, editText: EditText)
    }
}