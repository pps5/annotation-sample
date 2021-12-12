package io.github.pps5.annotationsample.logging.annotation

import androidx.lifecycle.Lifecycle

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class LogLifecycleEvent(
    val targetEvents: Array<Lifecycle.Event>
)
