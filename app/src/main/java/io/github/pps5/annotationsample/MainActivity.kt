package io.github.pps5.annotationsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import io.github.pps5.annotationsample.logging.LifecycleLoggingActivity
import io.github.pps5.annotationsample.statusbar.StatusBarActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.status_bar).setOnClickListener {
            startActivity(Intent(this, StatusBarActivity::class.java))
        }
        findViewById<Button>(R.id.lifecycle_logging).setOnClickListener {
            startActivity(Intent(this, LifecycleLoggingActivity::class.java))
        }
    }
}