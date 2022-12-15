package com.vassagame.twochairs.presenter.settingquest.packoption

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vassagame.twochairs.databinding.QuestionRecycleLayoutBinding
import com.vassagame.twochairs.domain.entity.dbentity.QuestionDomEntity

class QuestionListAdapter : RecyclerView.Adapter<QuestionListAdapter.QuestionViewHolder>(){
    private var packViewHolder: ArrayList<QuestionViewHolder> = ArrayList()
    private var questionDomEntity: ArrayList<QuestionDomEntity> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding =
            QuestionRecycleLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = QuestionViewHolder(binding.root, binding)
        packViewHolder.add(holder)
        return holder
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind( position, questionDomEntity[position])
    }

    override fun getItemCount(): Int {
        return questionDomEntity.size//TODO
    }

    class QuestionViewHolder(
        itemView: View,
        private val binding: QuestionRecycleLayoutBinding
    ) : RecyclerView.ViewHolder(itemView) {
        private var id = 0

        fun bind(id: Int, questionDomEntity: QuestionDomEntity) {
            //binding.tVQuestionList.text = questionDomEntity.packId//TODO
            binding.tVtypeQuestion.text = if (questionDomEntity.standard){"Standard"}else{"User's"}
            binding.cBQuestion.setOnClickListener {  }
            binding.linerQuestion.setOnClickListener {  }
            this.id = id
        }
    }
}