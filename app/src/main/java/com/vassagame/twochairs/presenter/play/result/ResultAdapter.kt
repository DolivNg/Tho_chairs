package com.vassagame.twochairs.presenter.play.result


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vassagame.twochairs.databinding.RessultRecycleLayoutBinding
import com.vassagame.twochairs.domain.entity.OptionGameEntity
import com.vassagame.twochairs.domain.entity.PlayerEntity

class ResultAdapter(val optionGameEntity : OptionGameEntity ) : RecyclerView.Adapter<ResultViewHolder>() {
    private var array = ArrayList<ResultViewHolder>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val binding =
            RessultRecycleLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ResultViewHolder(binding.root, binding)

        array.add(holder)
        return holder
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.bind(optionGameEntity.playerEntity[position])
    }

    override fun getItemCount(): Int {
        return optionGameEntity.playerEntity.size
    }
}

class ResultViewHolder(
    itemView: View, var binding: RessultRecycleLayoutBinding
) : RecyclerView.ViewHolder(itemView) {


    fun bind(playerEntity : PlayerEntity){
        binding.tVDisLikeRes.text = playerEntity.negativeAnswer.toString()
        binding.tVPlayerNameRes.text = playerEntity.namePlayer
        binding.tVLikeRes.text = playerEntity.positiveAnswer.toString()
        binding.tVSkipRes.text = playerEntity.skipQuestion.toString()
    }
}
