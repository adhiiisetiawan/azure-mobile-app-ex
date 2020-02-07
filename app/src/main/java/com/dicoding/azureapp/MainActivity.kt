package com.dicoding.azureapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.app.SupportActivity
import android.support.v4.app.SupportActivity.ExtraData
import android.support.v4.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {

    private var heroes: ArrayList<Hero> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCenter.start(
            application, "d20dab3f-c838-489e-9a1e-99ea769ca5a3",
            Analytics::class.java, Crashes::class.java
        )

        heroes.addAll(HeroesData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rv_hero.layoutManager = LinearLayoutManager(this)
        rv_hero.adapter = ListHeroAdapter(heroes)
    }
}
