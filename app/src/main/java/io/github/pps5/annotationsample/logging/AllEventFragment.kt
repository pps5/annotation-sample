package io.github.pps5.annotationsample.logging

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.google.android.material.appbar.MaterialToolbar
import io.github.pps5.annotationsample.R
import io.github.pps5.annotationsample.logging.annotation.LogLifecycleEvent

@LogLifecycleEvent(targetEvents = [Lifecycle.Event.ON_ANY])
class AllEventFragment : Fragment(R.layout.fragment_logging) {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<MaterialToolbar>(R.id.toolbar).title = "All Event Fragment"

        val button = view.findViewById<Button>(R.id.button)
        button.text = "Switch to OnStart and OnStop Fragment"
        button.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, OnStartAndOnStopFragment())
                .commit()
        }
    }
}