package com.example.harrypotterapp.ui

import android.view.View
import android.widget.ProgressBar

fun showLoading(progressBar: ProgressBar, contentView: View) {
    progressBar.visibility = View.VISIBLE
    contentView.visibility = View.GONE
}

fun hideLoading(progressBar: ProgressBar, contentView: View) {
    progressBar.visibility = View.GONE
    contentView.visibility = View.VISIBLE
}