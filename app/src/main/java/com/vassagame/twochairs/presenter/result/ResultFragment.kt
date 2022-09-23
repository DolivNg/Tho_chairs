package com.vassagame.twochairs.presenter.result

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.vassagame.twochairs.R
import com.vassagame.twochairs.databinding.FragmentOptionGameBinding
import com.vassagame.twochairs.databinding.FragmentResultBinding
import com.vassagame.twochairs.domain.entity.OptionGameEntity


class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val KEY = "data"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var optionGameEntity = OptionGameEntity()
        if (arguments != null)
            optionGameEntity = arguments?.get(KEY) as OptionGameEntity
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        ResultAdapter(optionGameEntity).also { binding.recyclerView.adapter = it }
        binding.recyclerView.adapter?.notifyDataSetChanged()

        val bundle = Bundle()
        bundle.putParcelable(KEY,optionGameEntity)

        binding.bttnChangePlayer.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_optionGameFragment,bundle)}
        binding.bttnBackMenu.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_menuFragment)}
        binding.bttnPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_gameFragment,bundle)}
    }
}