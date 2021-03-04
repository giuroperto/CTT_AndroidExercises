package com.ctt.whatsupp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.whatsupp.model.Contato
import com.ctt.whatsupp.model.Status

class StatusFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val statusList = mutableListOf<Status>(
            Status(picture = null, name = "Giulia", time = "20 minutes ago"),
            Status(picture = null, name = "Henrique", time = "25 minutes ago"),
            Status(picture = null, name = "Afonso", time = "40 minutes ago"),
            Status(picture = null, name = "Cristina", time = "1h ago"),
            Status(picture = null, name = "Daniel", time = "5h ago"),
        )

        val rvStatus = view.findViewById<RecyclerView>(R.id.statusList)

        val adapterStatus = StatusAdapter(statusList)
        rvStatus.adapter = adapterStatus
        rvStatus.layoutManager = LinearLayoutManager(requireContext())
    }

}
