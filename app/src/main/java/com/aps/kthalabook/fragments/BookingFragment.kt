package com.aps.kthalabook.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.aps.kthalabook.activities.DirectionActivity
import com.aps.kthalabook.adapter.BookingAdapter
import com.aps.kthalabook.callbacks.CommonInterface
import com.google.android.material.tabs.TabLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var view_c: View
    lateinit var tab_layout: TabLayout
    lateinit var rv_ser: RecyclerView

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
        view_c =  inflater.inflate(R.layout.fragment_booking, container, false)

        rv_ser = view_c.findViewById(R.id.rv_ser)
        tab_layout = view_c.findViewById(R.id.tab_layout)
        val firstTab = tab_layout.newTab()
        firstTab.text = "Upcoming"
        tab_layout.addTab(firstTab, 0, true)
        val Finished = tab_layout.newTab()
        Finished.text = "Finished"
        tab_layout.addTab(Finished, 1, false)
        val Canceled = tab_layout.newTab()
        Canceled.text = "Canceled"
        tab_layout.addTab(Canceled, 2, false)
        rv_ser.setLayoutManager(LinearLayoutManager(context))

        rv_ser!!.adapter = BookingAdapter("BOOKING",
            object : CommonInterface {
                override fun onItemClicked(type: String, position: Int) {
                    if (type=="Direction"){
                        startActivity( Intent(context, DirectionActivity::class.java))
                    }

                }
            })





        return view_c
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}