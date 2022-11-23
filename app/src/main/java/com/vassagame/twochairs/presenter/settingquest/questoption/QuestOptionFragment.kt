package com.vassagame.twochairs.presenter.settingquest.questoption

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vassagame.twochairs.R

class QuestOptionFragment : Fragment() {

    companion object {
        fun newInstance() = QuestOptionFragment()
    }

    private lateinit var viewModel: QuestOptionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quest_option, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[QuestOptionViewModel::class.java]
        // TODO: Use the ViewModel
    }

}