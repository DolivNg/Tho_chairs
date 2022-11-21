package com.vassagame.twochairs.presenter.play.gameoption


import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import com.vassagame.twochairs.R


class AddNameDialog(val callback: AlertDialogCallback) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val input = EditText(context)
            val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            input.layoutParams = lp


            val builder = AlertDialog.Builder(it)
            builder.setTitle(getString(R.string.player_name))
                .setView(input)
                .setPositiveButton("ОК") { dialog, id ->
                    run {
                        callback.callFragment(input.text.toString())
                        dialog.cancel()
                    }
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    interface AlertDialogCallback {
        fun callFragment(string: String)
    }

}