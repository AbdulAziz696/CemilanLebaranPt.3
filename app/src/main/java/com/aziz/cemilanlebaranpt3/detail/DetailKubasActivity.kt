package com.aziz.cemilanlebaranpt3.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aziz.cemilanlebaranpt3.KuebasahItem
import com.aziz.cemilanlebaranpt3.R
import com.aziz.cemilanlebaranpt3.databinding.ActivityDetailKubasBinding
import com.aziz.cemilanlebaranpt3.databinding.ItemKubasBinding
import com.bumptech.glide.Glide

class DetailKubasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailKubasBinding
    companion object {
        const val DATA = "a"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailKubasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<KuebasahItem>(DATA)

        binding.txtJudulDetailKubas.text = data?.namakue
        binding.txtDescKubas.text = data?.desc
        binding.txtBahanKubas.text = data?.resep
        binding.txtCaramasakKubas.text = data?.caramasak

// scale(Scale.FILL)
        Glide.with(this)
            .load(data?.gambar).into(binding.imgDetailKubas)




    }
}