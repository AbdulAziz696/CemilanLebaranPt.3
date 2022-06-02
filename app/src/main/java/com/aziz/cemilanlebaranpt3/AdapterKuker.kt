package com.aziz.cemilanlebaranpt3

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aziz.cemilanlebaranpt3.databinding.ItemKukerBinding
import com.aziz.cemilanlebaranpt3.detail.DetailKubasActivity
import com.aziz.cemilanlebaranpt3.detail.DetailKukerActivity
import com.bumptech.glide.Glide

class AdapterKuker : RecyclerView.Adapter<AdapterKuker.KuKerViewHolder>() {
    private var listitemKuker= arrayListOf<KuekeringItem>()

    fun addData(item: List<KuekeringItem>){
        listitemKuker.addAll(item)
    }

    class KuKerViewHolder(val kukerbinding: ItemKukerBinding): RecyclerView.ViewHolder(kukerbinding.root){
        fun bindview(item:KuekeringItem){
            itemView.run {
                kukerbinding.txtJudulKuker.text= item.namakue
                kukerbinding.txtDescKuker.text= item.desc
                Glide.with(this).load(item.gambar).into(kukerbinding.imgKuker)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KuKerViewHolder {
        val listKuker = ItemKukerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return KuKerViewHolder(listKuker)
    }

    override fun onBindViewHolder(holder: KuKerViewHolder, position: Int) {
        val data = listitemKuker[position]
        holder.bindview(data)
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailKukerActivity::class.java)
            intent.putExtra(DetailKukerActivity.Data, data)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listitemKuker.size
    }
}
