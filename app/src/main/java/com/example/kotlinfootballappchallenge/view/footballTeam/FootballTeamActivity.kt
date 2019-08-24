package com.example.kotlinfootballappchallenge.view.footballTeam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinfootballappchallenge.R
import com.example.kotlinfootballappchallenge.model.FootballTeam
import com.example.kotlinfootballappchallenge.presenter.footballTeam.FootballTeamPresenter
import com.example.kotlinfootballappchallenge.presenter.footballTeam.FootballTeamView
import kotlinx.android.synthetic.main.activity_football_team.*

class FootballTeamActivity : AppCompatActivity(),FootballTeamView {
    val presenter:FootballTeamPresenter = FootballTeamPresenter()
    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showFootballTeamInfo(footballTeam: FootballTeam) {
        tv_team.text = footballTeam.teams[0].strTeam
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_football_team)
        presenter.onViewAttached(this)
    }
}
