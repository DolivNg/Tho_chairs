package com.vassagame.twochairs.presenter.game

import android.widget.TextView

class ViewGameAnimation {
    fun startNameAnimation(textView : TextView, text : String) {
        textView.text = text
        textView.translationX =-1000F

        textView.scaleX = 1.4F
        textView.scaleY = 1.4F

        textView.animate()
            .translationX(0F)
            .setDuration(300).withEndAction {
                textView.animate()
                    .scaleX(1.0F)
                    .scaleY(1.0F)
                    .setDuration(150)
                    .start()
            }.start()
    }

    fun startQuestionAnimation(textView : TextView, text : String) {
        textView.text = text
        textView.translationY = 2000F

        textView.animate()
            .translationY(0F)
            .setDuration(450)
            .start()
    }

    fun changeNameAnimation(textView : TextView, text : String) {
        textView.animate()
            .scaleX(1.4F)
            .scaleY(1.4F)
            .setDuration(150).withEndAction {
                textView.animate().translationX(1000F)
                    .setDuration(300).withEndAction {

                        textView.translationX = -1000F
                        textView.text = text

                        textView.animate()
                            .translationX(0F)
                            .setDuration(300).withEndAction {
                                textView.animate()
                                    .scaleX(1.0F)
                                    .scaleY(1.0F)
                                    .setDuration(150)
                                    .start()
                            }.start()
                    }.start()
            }.start()
    }

     fun changeQuestionAnimation(textView : TextView, text : String) {

        textView.animate()
            .translationY(-40F)
            .setDuration(150).withEndAction {
                textView.animate()
                    .translationY(2000F)
                    .setDuration(300).withEndAction {
                        textView.text = text
                        textView.animate()
                            .translationY(0F)
                            .setDuration(300).withEndAction {

                            }.start()
                    }.start()  }
            .start()
    }

}