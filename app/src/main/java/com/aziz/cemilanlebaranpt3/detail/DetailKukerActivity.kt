package com.aziz.cemilanlebaranpt3.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aziz.cemilanlebaranpt3.KuebasahItem
import com.aziz.cemilanlebaranpt3.KuekeringItem
import com.aziz.cemilanlebaranpt3.R
import com.aziz.cemilanlebaranpt3.databinding.ActivityDetailKukerBinding
import com.bumptech.glide.Glide

class DetailKukerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailKukerBinding
    companion object{
        const val Data= "a"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailKukerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<KuekeringItem>(Data)

        binding.txtJudulDetailKuker2.text = data?.namakue
        binding.txtDescKuker.text = data?.desc
        binding.txtBahanKuker.text = data?.resep
        binding.txtCaramasakKuker.text = data?.caramasak

// scale(Scale.FILL)
        Glide.with(this)
            .load(data?.gambar).into(binding.imgDetailKuker)

    }
}