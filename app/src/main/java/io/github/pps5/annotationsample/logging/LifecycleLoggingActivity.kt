package io.github.pps5.annotationsample.logging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.pps5.annotationsample.R

class LifecycleLoggingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_container)

        val lifecycleLogger = LifecycleLogger()
        supportFragmentManager.addFragmentOnAttachListener { _, fragment ->
            fragment.lifecycle.addObserver(lifecycleLogger)
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AllEventFragment())
                .commit()
        }
    }
}
