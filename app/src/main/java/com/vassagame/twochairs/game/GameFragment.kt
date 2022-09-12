package com.vassagame.twochairs.game

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.vassagame.twochairs.R
import com.vassagame.twochairs.databinding.FragmentGameBinding
import com.vassagame.twochairs.databinding.FragmentMenuBinding
import com.vassagame.twochairs.domain.entity.OptionGameEntity
import com.vassagame.twochairs.domain.usecase.game.GameUseCase
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameFragment : Fragment(), GameUseCase.OnEventGameCallBack {
    private val KEY = "data"
    companion object {
        fun newInstance() = GameFragment()
    }

    private var viewGameAnimation = ViewGameAnimation()
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<GameViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewModel = ViewModelProvider(this)[GameViewModel::class.java]
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null)
            viewModel.setData(arguments?.get(KEY) as OptionGameEntity)

        viewModel.getNum().observe(viewLifecycleOwner) {
            binding.tVQuewstionLost.text = "$it"
        }

        viewModel.startGame(this)
        binding.bttnSkip.setOnClickListener {viewModel.skipQuestionClick()  }
        binding.imVPositive.setOnClickListener { viewModel.changeQuestionClick(1) }
        binding.imVNegative.setOnClickListener { viewModel.changeQuestionClick(-1) }
    }

    override fun changePlayer(name: String) {
        viewGameAnimation.changeNameAnimation(binding.tVNamePlayer,name)
    }

    override fun changeQuestion(question: String) {
        viewGameAnimation.changeQuestionAnimation(binding.tVQuestion,question)
    }

    override fun startGame(name: String, question: String) {
        viewGameAnimation.startQuestionAnimation(binding.tVQuestion,question)
        viewGameAnimation.startNameAnimation(binding.tVNamePlayer,name)
    }


    override fun endGame() {
        findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
    }
}