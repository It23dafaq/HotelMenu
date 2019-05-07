package com.example.cfoulidis.profilemanager

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*


/**
 * Created by cfoulidis on 4/22/2019.
 */
class MainAdapter(val countryDetails: List<CountryDetails>): RecyclerView.Adapter<MainAdapter.CustomViewHolder>(){
    //number of items
    override fun getItemCount(): Int {

        return countryDetails.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent,false)
      return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        holder?.v?.viewTextView?.text = countryDetails[position].name;
        println(countryDetails[0].flag)
        Picasso.get().load("https://www.google.com/search?q=asta&rlz=1C1GCEU_enGR843GR843&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjPkd_5xubhAhU7wMQBHRDuBbwQ_AUIDigB&biw=1366&bih=608#imgdii=2KTkq-_-oG5ynM:&imgrc=mQK-ujTbYhBwcM:").into(holder?.v?.imageView?.imageView)
    }


    class CustomViewHolder(val v:View): RecyclerView.ViewHolder(v){

    }
}