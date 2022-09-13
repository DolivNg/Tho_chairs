package com.vassagame.twochairs.presenter.gameoption

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.vassagame.twochairs.R
import com.vassagame.twochairs.databinding.PlayerRecycleLoyoutBinding

class OptionGameAdapter(context: Context) : RecyclerView.Adapter<OptionGameViewHolder>(),
    OptionGameViewHolder.CallAdapter {
    private var optionGameViewHolders: ArrayList<OptionGameViewHolder> = ArrayList()
    var nameArray: ArrayList<String> = ArrayList()
    var drawable: Drawable

    init {
        drawable = ContextCompat.getDrawable(context, R.drawable.hp_progresbar)!!;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionGameViewHolder {
        val binding =
            PlayerRecycleLoyoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = OptionGameViewHolder(binding.root, binding, this)

        optionGameViewHolders.add(holder)
        return holder
    }

    override fun onBindViewHolder(holder: OptionGameViewHolder, position: Int) {
        holder.bind(nameArray[position], position)

    }

    fun deleteName() : Int {
        optionGameViewHolders.forEach {
            if (it.binding.textViewName.tag as Int == 1) {
                return it.id
            }
        }
        return -1
    }

    fun deSelectAll() {
        optionGameViewHolders.forEach {
            it.binding.textViewName.tag = 0
            it.binding.textViewName.background = null
        }
    }

    override fun getItemCount(): Int {
        return nameArray.size
    }

    override fun callAdapter(id: Int) {
        optionGameViewHolders.forEach {
            if (it.id != id) {
                it.binding.textViewName.tag = 0
                it.binding.textViewName.background = null
            } else {
                it.binding.textViewName.tag = 1
                it.binding.textViewName.background = drawable
            }
        }
    }
}

class OptionGameViewHolder(
    itemView: View,
    val binding: PlayerRecycleLoyoutBinding,
    val call: CallAdapter
) : RecyclerView.ViewHolder(itemView) {
    var id = 0;
    fun bind(string: String, id: Int) {
        binding.textViewName.text = string
        binding.textViewName.tag = 0
        this.id = id

        binding.textViewName.setOnClickListener {
            if (binding.textViewName.tag as Int == 0) {
                binding.textViewName.tag = 1
                call.callAdapter(id)
            }
        }
    }

    interface CallAdapter {
        fun callAdapter(id: Int) {}
    }

}