package com.example.ryeclerviewexchangerate

//Pengerjaan terakhir : 20/05/2025 18.55
//NIM                 : 10122334
//NAMA                : Berry Abdul Ghany
//KELAS               : PA-4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ryeclerviewexchangerate.adapter.ListHeroAdapter
import com.example.ryeclerviewexchangerate.model.Hero
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }

    private fun getListHeroes(): ArrayList<Hero> {
        val dataCountry = resources.getStringArray(R.array.country)
        val dataBuy = resources.getStringArray(R.array.buy)
        val dataSell = resources.getStringArray(R.array.sell)
        val dataFlag = resources.obtainTypedArray(R.array.flag)
        val listHero = ArrayList<Hero>()

        val minLength = minOf(dataCountry.size, dataBuy.size, dataSell.size, dataFlag.length())

        for (i in 0 until minLength) {
            val flagResId = dataFlag.getResourceId(i, -1)
            if (flagResId != -1) {
                val hero = Hero(
                    country = dataCountry[i],
                    buy = dataBuy[i].toDoubleOrNull() ?: 0.0,
                    sell = dataSell[i].toDoubleOrNull() ?: 0.0,
                    flag = flagResId
                )
                listHero.add(hero)
            }
        }
        dataFlag.recycle()
        return listHero
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list) { hero ->
            Toast.makeText(this, "Kamu memilih: ${hero.country}", Toast.LENGTH_SHORT).show()
        }
        rvHeroes.adapter = listHeroAdapter
    }
}
