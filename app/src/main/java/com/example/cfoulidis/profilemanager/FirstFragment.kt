package com.example.cfoulidis.profilemanager

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_first.*
import okhttp3.*
import java.io.IOException
import kotlin.concurrent.thread


/**
 * A simple [Fragment] subclass.
 */
 class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fetchJson()


    }
    fun fetchJson(){

        println("fecth json")
        val url="https://restcountries.eu/rest/v2/name/greece"
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()
        client.newCall(request)
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                println("error")
            }

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)
                val gson = GsonBuilder().create()

              var countryDetails  = gson.fromJson(body, Array<CountryDetails>::class.java).toList()


               // this@FirstFragment.view?.findViewById<TextView>(R.id.textView2)?.text = ""
                activity.runOnUiThread {
                    textView2.text = countryDetails[0].name
                }
            }



        })}

}
