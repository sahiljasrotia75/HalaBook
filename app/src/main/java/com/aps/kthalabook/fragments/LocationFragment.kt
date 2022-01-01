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
import com.aps.kthalabook.activity.MyCartActivity
import com.aps.kthalabook.adapter.ServiceAdapter
import com.aps.kthalabook.callbacks.CommonInterface

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LocationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LocationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var view_c: View

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
        view_c =  inflater.inflate(R.layout.fragment_location, container, false)
        initViews()
        setServiceAdapter()
        return  view_c
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LocationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LocationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    private fun setServiceAdapter() {

        rv_ser!!.adapter = ServiceAdapter("HORIZONTAL",
            object : CommonInterface {
                override fun onItemClicked(type: String, position: Int) {
                    if (type == "btn_book") {
                        startActivity(Intent(context, MyCartActivity::class.java))

                    }

                }
            })


    }

    private fun initViews() {
        rv_ser = view_c.findViewById(R.id.rv_ser)
        rv_ser.setLayoutManager(LinearLayoutManager(context))
    }

}