package com.example.cfoulidis.profilemanager

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.commend_row.view.*
import kotlinx.android.synthetic.main.video_row.view.*
import java.util.zip.Inflater
import android.content.Context;
import android.graphics.Color
import android.os.Build
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.widget.PopupWindow
import kotlinx.android.synthetic.main.popup.view.*

/**
 * Created by cfoulidis on 4/22/2019.
 */
class SecondAdapter(var context :Context): RecyclerView.Adapter<CustomViewHolder2>() {

    override fun getItemCount(): Int {
        return 3
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder2 {

        val LayoutInflater = LayoutInflater.from(context)
        val cellForRow = LayoutInflater.inflate(R.layout.commend_row, parent, false)

        return CustomViewHolder2(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder2?, position: Int) {
        holder?.itemView?.likeButon?.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, FindPlace::class.java)

            context.startActivity(intent)

        }
        holder?.itemView?.dilike?.setOnClickListener {


        }
    }
}
class CustomViewHolder2(v: View): RecyclerView.ViewHolder(v){

}