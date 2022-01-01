package com.aps.kthalabook.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aps.kthalabook.R
import com.aps.kthalabook.adapter.NotificationAapter
import com.google.android.material.tabs.TabLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NotificationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotificationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var view_c: View
    lateinit var tab_layout: TabLayout
    lateinit var rv_notification: RecyclerView


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
        view_c = inflater.inflate(R.layout.fragment_notification, container, false)

        rv_notification = view_c.findViewById(R.id.rv_notification)
        tab_layout = view_c.findViewById(R.id.tab_layout)
        val firstTab = tab_layout.newTab()
        firstTab.text = "Important"
        tab_layout.addTab(firstTab, 0, true)
        val firstTab2 = tab_layout.newTab()
        firstTab2.text = "Promotion"
        tab_layout.addTab(firstTab2, 1, false)
        rv_notification.setLayoutManager(LinearLayoutManager(context))
        rv_notification.setAdapter(NotificationAapter())

        return  view_c ;
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotificationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}