package com.qburst.boilerplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_basic.*

class BasicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)

        loader_button.setOnClickListener {
            //
            if (progress_circular_frame.isVisible)
                progress_circular_frame.visibility = View.GONE
            else
                progress_circular_frame.visibility = View.VISIBLE
            //
        }
    }
}
