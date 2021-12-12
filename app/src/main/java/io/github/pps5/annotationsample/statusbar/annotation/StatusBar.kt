package io.github.pps5.annotationsample.statusbar.annotation

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class StatusBar(
    val color: Color
) {
    enum class Color(val color: Int) {
        Red(android.graphics.Color.RED),
        Blue(android.graphics.Color.BLUE),
    }
}