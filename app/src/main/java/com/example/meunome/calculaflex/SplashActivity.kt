package com.example.meunome.calculaflex

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        preferences = getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
        val isFirstOpen = preferences.getBoolean("open_fisrt", true)

        if(isFirstOpen) {
            markAppAlReadyOpen()
            load()
        } else {
            showMain()
        }

        load()
    }

    private fun markAppAlReadyOpen() {
        val editor = preferences.edit()
        editor.putBoolean("open_fisrt", false)
        editor.apply()
    }

    private fun load() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.splash)
        animation.reset()
        ivLogo.startAnimation(animation)

        Handler().postDelayed({
            showMain()
        }, 3500L)
    }

    private fun showMain() {
        startActivity(Intent(this, FormActivity::class.java))
        finish()
    }
}
