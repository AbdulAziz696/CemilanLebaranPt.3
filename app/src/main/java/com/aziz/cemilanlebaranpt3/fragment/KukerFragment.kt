package com.aziz.cemilanlebaranpt3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.aziz.cemilanlebaranpt3.*
import com.aziz.cemilanlebaranpt3.databinding.FragmentKukerBinding
import kotlinx.coroutines.launch

class KukerFragment : Fragment() {
    private lateinit var binding: FragmentKukerBinding
    private var kukeradApter = AdapterKuker()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKukerBinding.inflate(inflater, container, false)

        kukeradApter = AdapterKuker()
        binding.recyclerKuker.adapter = kukeradApter
        binding.recyclerKuker.setHasFixedSize(true)
        binding.recyclerKuker.layoutManager = LinearLayoutManager(context)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofitService = RetrovitKue.buildService(InterfaceKue::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            val mintadatakue = retrofitService.getDataKuker()

            if (mintadatakue.isSuccessful) {
                val datakuekering = mintadatakue.body() as List<KuekeringItem>
                kukeradApter.addData(datakuekering)
                kukeradApter.notifyDataSetChanged()

            }
        }
    }
}





