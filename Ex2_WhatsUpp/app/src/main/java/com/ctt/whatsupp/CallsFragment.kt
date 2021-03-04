package com.ctt.whatsupp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.whatsupp.model.Call
import com.ctt.whatsupp.model.Contato

class CallsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val callsList = mutableListOf<Call>(
            Call(picture = null, name = "Giulia", time = "27 minutes ago"),
            Call(picture = null, name = "Henrique", time = "28 minutes ago"),
            Call(picture = null, name = "Henrique", time = "29 minutes ago"),
            Call(picture = null, name = "Afonso", time = "29 minutes ago"),
            Call(picture = null, name = "Cristina", time = "30 minutes ago"),
            Call(picture = null, name = "Henrique", time = "32 minutes ago"),
            Call(picture = null, name = "Henrique", time = "1h ago"),
            Call(picture = null, name = "Daniel", time = "2h ago"),
        )

        val rvCalls = view.findViewById<RecyclerView>(R.id.rvCallsList)
        val adapterCalls = CallsAdapter(callsList)
        rvCalls.adapter = adapterCalls
        rvCalls.layoutManager = LinearLayoutManager(requireContext())
    }
}
