package com.vassagame.twochairs.presenter.gameoption

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.vassagame.twochairs.R
import com.vassagame.twochairs.databinding.FragmentOptionGameBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class OptionGameFragment : Fragment(), AddNameDialog.AlertDialogCallback {
    private val KEY = "data"
    private var _binding: FragmentOptionGameBinding? = null
    private val binding get() = _binding!!
    private var bundle = Bundle()

    val viewModel by viewModel<OptionGameViewModel>()
    lateinit var optionGameAdapter: OptionGameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewModel = ViewModelProvider(this)[OptionGameViewModel::class.java]
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentOptionGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        optionGameAdapter = context?.let { OptionGameAdapter(it) }!!
        binding.listView.layoutManager = LinearLayoutManager(context);
        binding.listView.adapter = optionGameAdapter

        viewModel.getData().observe(viewLifecycleOwner) {
            optionGameAdapter.nameArray = it.listNames
            binding.listView.adapter?.notifyDataSetChanged()

            bundle.clear()
            bundle.putParcelable(KEY, it)
        }

        val addNameDialog = AddNameDialog(this)

        binding.imBtnAdd.setOnClickListener {
            addNameDialog.show(parentFragmentManager, "name")
        }
        binding.imageButtonDelete.setOnClickListener {
            viewModel.removeName(optionGameAdapter.deleteName())
            binding.listView.adapter?.notifyDataSetChanged()
            optionGameAdapter.deSelectAll()
        }


        binding.buttonPlayGame.setOnClickListener {
            viewModel.setNumber(binding.editTextNumber.text.toString())
            if (viewModel.getData().value?.listNames?.size!! >= 1)
                if (binding.editTextNumber.text.toString() != "")
                    if (binding.editTextNumber.text.toString().toInt() > 0)
                        findNavController().navigate(
                            R.id.action_optionGameFragment_to_gameFragment,
                            bundle
                        )
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun callFragment(string: String) {
        viewModel.addName(string)
    }
}