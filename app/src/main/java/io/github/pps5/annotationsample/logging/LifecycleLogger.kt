package io.github.pps5.annotationsample.logging

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import io.github.pps5.annotationsample.BuildConfig
import io.github.pps5.annotationsample.logging.annotation.LogLifecycleEvent

class LifecycleLogger : LifecycleEventObserver {

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (!BuildConfig.DEBUG) {
            return
        }

        val targetEvents = source::class.java
            .getAnnotation(LogLifecycleEvent::class.java)
            ?.targetEvents
            .orEmpty()

        if (targetEvents.contains(Lifecycle.Event.ON_ANY) ||
            targetEvents.contains(event)
        ) {
            Log.d(source::class.java.canonicalName, "lifecycle event: ${event.name}")
        }
    }
}