package com.vassagame.twochairs.presenter.settingquest.packs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vassagame.twochairs.databinding.PackRecycleLayoutBinding
import com.vassagame.twochairs.domain.entity.dbentity.PackDomEntity



class PackListAdapter : RecyclerView.Adapter<PackListAdapter.PackViewHolder>() {
    private var packViewHolder: ArrayList<PackViewHolder> = ArrayList()
    private var packDomEntity: ArrayList<PackDomEntity> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackViewHolder {
        val binding =
            PackRecycleLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = PackViewHolder(binding.root, binding)
        packViewHolder.add(holder)
        return holder
    }

    override fun onBindViewHolder(holder: PackViewHolder, position: Int) {
        holder.bind( position, packDomEntity[position])
    }

    override fun getItemCount(): Int {
        return packDomEntity.size//TODO
    }

    class PackViewHolder(
        itemView: View,
        private val binding: PackRecycleLayoutBinding
    ) : RecyclerView.ViewHolder(itemView) {
        private var id = 0

        fun bind(id: Int,packDomEntity:PackDomEntity ) {
            binding.tVNamePack.text = packDomEntity.packName
            binding.tVTypePack.text = if (packDomEntity.standard){"Standard"}else{"User's"}
            binding.cBSelectedPack.setOnClickListener {  }
            binding.linerPack.setOnClickListener {  }
            this.id = id
        }
    }
}
