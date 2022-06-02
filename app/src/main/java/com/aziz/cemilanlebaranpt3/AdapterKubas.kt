package com.aziz.cemilanlebaranpt3

import android.content.Intent
import android.provider.ContactsContract.Intents.Insert.DATA
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aziz.cemilanlebaranpt3.databinding.ItemKubasBinding
import com.aziz.cemilanlebaranpt3.detail.DetailKubasActivity
import com.bumptech.glide.Glide

class AdapterKubas : RecyclerView.Adapter<AdapterKubas.KuBasViewHolder>()  {
    private var listitemKubas= arrayListOf<KuebasahItem>()

    fun addData(item: List<KuebasahItem>){
        listitemKubas.addAll(item)
    }

    class KuBasViewHolder(val kubasbinding: ItemKubasBinding): RecyclerView.ViewHolder(kubasbinding.root) {
        fun bindview(item:KuebasahItem){
            itemView.run {
                kubasbinding.txtJudulKubas.text= item.namakue
                kubasbinding.txtDescKubas.text= item.desc
                Glide.with(this).load(item.gambar).into(kubasbinding.imgKubas)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KuBasViewHolder {
        val listKubas = ItemKubasBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return KuBasViewHolder(listKubas)
    }

    override fun onBindViewHolder(holder: KuBasViewHolder, position: Int) {
        val data = listitemKubas[position]
        holder.bindview(data)
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context,DetailKubasActivity::class.java)
            intent.putExtra(DetailKubasActivity.DATA, data)
            it.context.startActivity(intent)
        }
    }



    override fun getItemCount(): Int {
        return listitemKubas.size
    }
}