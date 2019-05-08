package com.example.cfoulidis.profilemanager

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_second.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SecondFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            // Inflate the layout for this fragment

            return inflater!!.inflate(R.layout.fragment_second, container, false)

         }
    }
class CustomAdapter(val Menulist : ArrayList<String>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
          return 5
     }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
           holder?.itemView?.findViewById<TextView>(R.id.NameOffood)?.text = "Steaks"
           holder?.itemView?.findViewById<TextView>(R.id.Price)?.text = "14$"
           holder?.itemView?.findViewById<TextView>(R.id.NameOffood)?.text = "with fresh potato and ....."
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.mymenu,parent,false)
        return ViewHolder(v)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}