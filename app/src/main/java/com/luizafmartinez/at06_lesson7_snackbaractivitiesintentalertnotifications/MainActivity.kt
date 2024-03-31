package com.luizafmartinez.at06_lesson7_snackbaractivitiesintentalertnotifications

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.luizafmartinez.at06_lesson7_snackbaractivitiesintentalertnotifications.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun MgSnack(view: View) {
        Snackbar.make(
            findViewById(R.id.sendMessage),
            "Your email has been sent succesfully",
            Snackbar.LENGTH_LONG
        )
            .setAction("OK") { }.setActionTextColor(Color.RED).show()
    }

    override fun onStart() {
        super.onStart()
        Snackbar.make(
            findViewById(R.id.sendMessage),
            "onStart method is running now",
            Snackbar.LENGTH_LONG
        ).show()
    }

    fun shutDown(view: View) {
        onDestroy()
    }
}