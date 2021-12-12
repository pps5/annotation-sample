package io.github.pps5.annotationsample.statusbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.pps5.annotationsample.R
import io.github.pps5.annotationsample.statusbar.annotation.StatusBar

class StatusBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status_bar)

        supportFragmentManager.addFragmentOnAttachListener { _, fragment ->
            val statusBarAnnotation = fragment::class.java.getAnnotation(StatusBar::class.java)
            if (statusBarAnnotation != null) {
                window.statusBarColor = statusBarAnnotation.color.color
            }
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RedFragment())
                .commit()
        }
    }

}