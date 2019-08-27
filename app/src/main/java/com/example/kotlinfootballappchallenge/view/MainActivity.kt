package com.example.kotlinfootballappchallenge.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlinfootballappchallenge.R
import com.example.kotlinfootballappchallenge.view.bubblesort.BubbleSortActivity
import com.example.kotlinfootballappchallenge.view.footballTeam.FootballTeamActivity
import com.example.kotlinfootballappchallenge.view.teamDetails.TeamDetailsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(view: View?) {
        var intent: Intent? = null
        when (view!!.id){
            R.id.btn_team ->{
                intent = Intent(this@MainActivity,FootballTeamActivity::class.java)
            }
            R.id.btn_bubblesort ->{
                intent = Intent(this@MainActivity,BubbleSortActivity::class.java)
            }
        }
        startActivity(intent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_team.setOnClickListener(this)
        btn_bubblesort.setOnClickListener(this)
    }
}
