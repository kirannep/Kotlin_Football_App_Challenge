package com.example.kotlinfootballappchallenge.view.footballTeam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinfootballappchallenge.R
import com.example.kotlinfootballappchallenge.model.FootballTeam
import com.example.kotlinfootballappchallenge.model.Teams
import com.example.kotlinfootballappchallenge.presenter.footballTeam.FootballTeamPresenter
import com.example.kotlinfootballappchallenge.presenter.footballTeam.FootballTeamView
import com.example.kotlinfootballappchallenge.view.teamDetails.TeamDetailsActivity
import kotlinx.android.synthetic.main.activity_football_team.*
import kotlinx.android.synthetic.main.recyclerview.*

class FootballTeamActivity : AppCompatActivity(),FootballTeamView {
    val presenter:FootballTeamPresenter = FootballTeamPresenter()
    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showFootballTeamInfo(footballTeam: FootballTeam) {
        val adapter:FootballTeamAdapter = FootballTeamAdapter(footballTeam,object : onTeamClickedListener{
            override fun onTeamClicked(teams: Teams) {
                Log.d("clicked",teams.strTeam)
                var intent:Intent
                intent = Intent(this@FootballTeamActivity,TeamDetailsActivity::class.java)
                intent.putExtra("teamID",teams.idTeam)
                startActivity(intent)
            }

        })
        recyclerView.layoutManager = LinearLayoutManager(this@FootballTeamActivity)
        recyclerView.adapter = adapter

        //tv_team.text = footballTeam.teams[1].strTeam
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview)
        presenter.onViewAttached(this)
    }
}
