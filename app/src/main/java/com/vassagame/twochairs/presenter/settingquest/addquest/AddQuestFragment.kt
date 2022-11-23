package com.vassagame.twochairs.presenter.settingquest.addquest

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vassagame.twochairs.R

class AddQuestFragment : Fragment() {

    companion object {
        fun newInstance() = AddQuestFragment()
    }

    private lateinit var viewModel: AddQuestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_quest, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddQuestViewModel::class.java)
        // TODO: Use the ViewModel
    }

}