package com.vassagame.twochairs.presenter.result

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vassagame.twochairs.databinding.PlayerRecycleLoyoutBinding
import com.vassagame.twochairs.databinding.RessultRecycleLayoutBinding
import com.vassagame.twochairs.presenter.gameoption.OptionGameViewHolder

class ResultAdapter : RecyclerView.Adapter<ResultViewHolder>() {
    var array = ArrayList<ResultViewHolder>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val binding =
            RessultRecycleLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ResultViewHolder(binding.root, binding)

        array.add(holder)
        return holder
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.bind(nameArray[position], position)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}

class ResultViewHolder(
    itemView: View,var binding : RessultRecycleLayoutBinding
    ) : RecyclerView.ViewHolder(itemView) {
        init{}
    fun bind()
}