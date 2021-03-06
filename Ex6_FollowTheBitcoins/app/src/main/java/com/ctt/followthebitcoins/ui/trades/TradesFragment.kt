package com.ctt.followthebitcoins.ui.trades

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ctt.followthebitcoins.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TradesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TradesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trades, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TradesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TradesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}


//val statusList = mutableListOf<Status>(
//    Status(picture = null, name = "Giulia", time = "20 minutes ago"),
//    Status(picture = null, name = "Henrique", time = "25 minutes ago"),
//    Status(picture = null, name = "Afonso", time = "40 minutes ago"),
//    Status(picture = null, name = "Cristina", time = "1h ago"),
//    Status(picture = null, name = "Daniel", time = "5h ago"),
//)
//
//val rvStatus = view.findViewById<RecyclerView>(R.id.statusList)
//
//val adapterStatus = StatusAdapter(statusList)
//rvStatus.adapter = adapterStatus
//rvStatus.layoutManager = LinearLayoutManager(requireContext())