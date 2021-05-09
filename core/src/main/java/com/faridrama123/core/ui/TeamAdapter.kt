package com.faridrama123.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.faridrama123.core.R
import com.faridrama123.core.databinding.ItemListTeamBinding
import com.faridrama123.core.domain.model.Teams
import java.util.ArrayList

class TeamAdapter : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    private var listData = ArrayList<Teams>()
    var onItemClick : ((Teams) -> Unit)? = null

    fun setData(newListData: List<Teams>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }


    inner  class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListTeamBinding.bind(itemView)
        fun bind (data : Teams){
            with(binding){
                Glide.with(itemView.context)
                    .load(data.strTeamBadge)
                    .into(ivItemImage)
                tvItemTitle.text = data.strTeam
                tvItemSubtitle.text = data.strDescriptionEN
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_team, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}