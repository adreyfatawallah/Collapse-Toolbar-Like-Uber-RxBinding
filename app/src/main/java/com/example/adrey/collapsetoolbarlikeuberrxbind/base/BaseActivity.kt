package com.example.adrey.collapsetoolbarlikeuberrxbind.base

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.WindowManager
import com.example.adrey.collapsetoolbarlikeuberrxbind.R
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Muh Adrey Fatawallah on 2/5/2018.
 */
abstract class BaseActivity : AppCompatActivity() {

    var title = ""
    var composite = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())

        setToolbar(0)

        codeHere()
    }

    open fun setToolbar(int: Int) {
        when(int) {
            1 -> window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
            2 -> {
                val toolbar = findViewById<Toolbar>(R.id.toolbar)
                setSupportActionBar(toolbar)
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                supportActionBar?.setHomeAsUpIndicator(ContextCompat.getDrawable(this, R.drawable.ic_back_red))

                try {
                    val title = title.split("%")
                    toolbar.title = title[0]
                    toolbar.subtitle = title[1]
                } catch (e: Exception) {
                    toolbar.title = title
                }
            }
        }
    }

    abstract fun setLayout(): Int

    abstract fun codeHere()

    abstract fun setMenu() : Int

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onClickHome()
        }
        return super.onOptionsItemSelected(item)
    }

    abstract fun onClickHome()

    override fun onDestroy() {
        super.onDestroy()
        onDestroyActivity()
    }

    abstract fun onDestroyActivity()
}