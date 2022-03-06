package com.aelsayed.wunder.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewbinding.ViewBinding
import android.content.Intent
import com.aelsayed.wunder.R


/**
 * BaseActivity acts out as a base class for all activities
 */
abstract class BaseActivity<B : ViewBinding> : AppCompatActivity() {
    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setUpViews()
    }

    abstract fun getViewBinding(): B
    open fun setUpViews() {

    }


    override fun finish() {
        super.finish()
        onLeaveThisActivity()
    }

    // handling animations between activities
    protected open fun onLeaveThisActivity() {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        onStartNewActivity()
    }

    override fun startActivity(intent: Intent?, options: Bundle?) {
        super.startActivity(intent, options)
        onStartNewActivity()
    }


    protected open fun onStartNewActivity() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }




}