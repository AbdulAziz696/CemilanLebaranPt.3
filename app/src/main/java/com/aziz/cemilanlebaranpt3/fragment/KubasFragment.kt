package com.aziz.cemilanlebaranpt3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.aziz.cemilanlebaranpt3.*
import com.aziz.cemilanlebaranpt3.databinding.FragmentKubasBinding
import kotlinx.coroutines.launch


class KubasFragment : Fragment() {

    private lateinit var binding: FragmentKubasBinding
    private var kubasahdApter = AdapterKubas()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKubasBinding.inflate(inflater, container, false)

        kubasahdApter = AdapterKubas()
        binding.recyclerKubas.adapter = kubasahdApter
        binding.recyclerKubas.setHasFixedSize(true)
        binding.recyclerKubas.layoutManager = LinearLayoutManager(context)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        va dataitemKubas=


        val retrofitService = RetrovitKue.buildService(InterfaceKue::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            val mintadatakue = retrofitService.getDataKubas()

            if (mintadatakue.isSuccessful) {
                val datakuebasah = mintadatakue.body() as List<KuebasahItem>
                kubasahdApter.addData(datakuebasah)
                kubasahdApter.notifyDataSetChanged()

            }
        }
    }
}