package com.demo.pokemon.presentation.widget

import android.app.Activity
import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.support.v4.content.ContextCompat
import android.widget.ProgressBar
import com.demo.pokemon.R

 class SpinnerLoadingImpl (var context: Activity): SpinnerLoading {


    private lateinit var progressDialog: ProgressDialog
    private lateinit var progressBar: ProgressBar

     init {
        progressDialog = ProgressDialog(this.context)
        progressDialog.isIndeterminate = true
        progressDialog.setCancelable(false)
        progressDialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        progressBar = ProgressBar(context)
        progressBar.id = R.id.spinnerProgress
        progressBar.isIndeterminate = true
        progressBar.indeterminateDrawable.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimary), PorterDuff.Mode.SRC_IN)
        progressBar.setBackgroundResource(android.R.color.transparent)
    }

     override fun show() {
        if (!progressDialog.isShowing) {
            progressDialog.show()
            progressDialog.setContentView(progressBar!!)
        }
    }

     override  fun show(listener: SpinnerLoadingListener) {
        progressDialog.setOnShowListener { listener.onFinishAction() }
        this.show()
    }

     override fun dismiss() {
        if (progressDialog.isShowing)
            progressDialog.dismiss()
    }

    override  fun dismiss(listener: SpinnerLoadingListener) {
        progressDialog!!.setOnDismissListener { listener.onFinishAction() }
        this.dismiss()
    }
}

