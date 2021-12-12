package io.github.pps5.annotationsample.statusbar

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import com.google.android.material.appbar.MaterialToolbar
import io.github.pps5.annotationsample.R
import io.github.pps5.annotationsample.statusbar.annotation.StatusBar

@StatusBar(StatusBar.Color.Blue)
class BlueFragment : Fragment(R.layout.fragment_statusbar) {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setBackgroundColor(Color.BLUE)
        toolbar.title = "Blue Fragment"

        val button = view.findViewById<Button>(R.id.button)
        button.text = "Switch to Red"
        button.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, RedFragment())
                .setTransition(TRANSIT_FRAGMENT_OPEN)
                .commit()
        }
    }
}