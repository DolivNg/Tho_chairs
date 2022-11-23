package com.vassagame.twochairs.presenter.settingquest.packoption

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vassagame.twochairs.R

class QuestionListFragment : Fragment() {

    companion object {
        fun newInstance() = QuestionListFragment()
    }

    private lateinit var viewModel: QuestionListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[QuestionListViewModel::class.java]
        // TODO: Use the ViewModel
    }

}