package com.example.cfoulidis.profilemanager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    lateinit var countryDetails: List<CountryDetails>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


          recyclerMain.layoutManager = LinearLayoutManager(this)
          recycler2.layoutManager = LinearLayoutManager(this)
          recycler2.adapter = SecondAdapter(this)
        countryDetails = ArrayList<CountryDetails>()
        recyclerMain.adapter = MainAdapter(countryDetails)

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

                val countryDetails : List<CountryDetails> = gson.fromJson(body, Array<CountryDetails>::class.java).toList()
                  runOnUiThread {  recyclerMain.adapter = MainAdapter(countryDetails)
                }

            }



        })}
    }




data class CountryDetails(val name: String?, val topLevelDomain: List<String>?, val alpha2Code: String?, val alpha3Code: String?,
                          val callingCodes: List<String>?, val capital: String?, val altSpellings: List<String>?,
                          val region: String?, val subregion: String?, val population: Number?,
                          val latlng: List<Number>?, val demonym: String?, val area: Number?,
                          val gini: Number?, val timezones: List<String>?, val borders: List<String>?, val nativeName: String?,
                          val numericCode: String?, val currencies: List<Currencies>?,
                          val languages: List<Languages>?, val translations: Translations?,
                          val flag: String?, val regionalBlocs: List<RegionalBlocs>?, val cioc: String?)

data class Currencies(val code: String?, val name: String?, val symbol: String?)

data class Languages(val iso639_1: String?, val iso639_2: String?, val name: String?, val nativeName: String?)

data class RegionalBlocs(val acronym: String?, val name: String?, val otherAcronyms: List<Any>?, val otherNames: List<Any>?)

data class Translations(val de: String?, val es: String?, val fr: String?, val ja: String?, val it: String?,
                        val br: String?, val pt: String?, val nl: String?, val hr: String?, val fa: String?)





