package com.aps.kthalabook.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.aps.kthalabook.R
import com.aps.kthalabook.activity.*
import com.aps.kthalabook.adapter.CategoryAdapter
import com.aps.kthalabook.adapter.ServiceAdapter
import com.aps.kthalabook.adapter.ServiceImagesAdapter
import com.aps.kthalabook.adapter.ServiceListAdapter
import com.aps.kthalabook.callbacks.CommonInterface
import com.aps.kthalabook.model.getCategoryItem
import com.aps.kthalabook.util.Utility
import java.util.ArrayList


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    lateinit var view_c: View
    lateinit var rv_cat: RecyclerView
    lateinit var rv_ser: RecyclerView
    lateinit var rv_deals: RecyclerView
    var c_position = 0
    var list: MutableList<Int> = ArrayList()
    lateinit var view_pager_offers: ViewPager

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view_c = inflater.inflate(R.layout.fragment_home, container, false)
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        c_position = 0
        initViews()
        setCategoryAdapter()
        setServiceAdapter()
        setDealsAdapter()
        manageListener()
        return view_c
    }


    private fun manageListener() {
        view_c!!.findViewById<View>(R.id.txt_view_cat).setOnClickListener { v: View? ->
            startActivity(
                Intent(context, CategoryListActivity::class.java)
            )
        }

        view_c!!.findViewById<View>(R.id.txt_see_deals).setOnClickListener { v: View? ->
            startActivity(Intent(context, ServiceListActivity::class.java))
        }
        view_c!!.findViewById<View>(R.id.txt_popular_see_all).setOnClickListener { v: View? ->
            startActivity(Intent(context, LocationServiceActivity::class.java))
        }
    }

    private fun setServiceAdapter() {

        rv_ser!!.adapter = context?.let {
            ServiceListAdapter(it, object : CommonInterface {
                override fun onItemClicked(type: String, position: Int) {
                    if (type == "root") {
                        startActivity(Intent(context, ServiceDetailActivity::class.java))
                    } else if (type == "rating") {
                        Utility().ratingDialog(activity)
                    } else {
                        startActivity(Intent(context, LocationServiceActivity::class.java))
                    }
                }
            })
        };

    }

    private fun initViews() {
        view_pager_offers = view_c.findViewById(R.id.view_pager_offers)
        rv_cat = view_c.findViewById(R.id.rv_cat)
        rv_ser = view_c.findViewById(R.id.rv_ser)
        rv_deals = view_c.findViewById(R.id.rv_deals)
        rv_cat.layoutManager = (LinearLayoutManager(context, RecyclerView.HORIZONTAL, false))
        rv_ser.layoutManager = (LinearLayoutManager(context))
        rv_deals.layoutManager = (LinearLayoutManager(context, RecyclerView.HORIZONTAL, false))

        list.add(R.drawable.banner)
        list.add(R.drawable.banner)
        list.add(R.drawable.banner)
        val viewPagerAdapter = ServiceImagesAdapter(activity!!, list)
        view_pager_offers.adapter = viewPagerAdapter
        view_pager_offers.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    fun setCategoryAdapter() {
        var list = getCategoryItem()
        rv_cat!!.adapter = CategoryAdapter(
            object : CommonInterface {
                override fun onItemClicked(type: String, position: Int) {
//                startActivity(
//                    Intent(context, CategoryListActivity::class.java)
//                )
                }
            }, "Home", c_position, context = context!!, list.toMutableList())
    }

    private fun setDealsAdapter() {
        rv_deals!!.adapter = ServiceAdapter("HORIZONTAL_MATCH",
            object : CommonInterface {
                override fun onItemClicked(type: String, position: Int) {
                    startActivity(Intent(context, ServiceListActivity::class.java))
                }
            })
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String?, param2: String?): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}