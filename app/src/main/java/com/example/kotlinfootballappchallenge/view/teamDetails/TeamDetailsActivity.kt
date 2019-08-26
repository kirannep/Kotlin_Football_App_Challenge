package com.example.kotlinfootballappchallenge.view.teamDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kotlinfootballappchallenge.R
import com.example.kotlinfootballappchallenge.model.FootballTeam
import com.example.kotlinfootballappchallenge.model.Teams
import com.example.kotlinfootballappchallenge.presenter.teamDetails.TeamDetailsPresenter
import com.example.kotlinfootballappchallenge.presenter.teamDetails.TeamView
import kotlinx.android.synthetic.main.activity_team_details.*

class TeamDetailsActivity : AppCompatActivity(),TeamView {
    override fun showTeamdetailsinfo(footballTeam: Teams) {
        tv_teamName.text = footballTeam.strDescriptionEN
    }

    val presenter:TeamDetailsPresenter = TeamDetailsPresenter()

    override fun getID(): Int {
        val teamId:Int = intent.getIntExtra("teamID",0)
        Log.d("retroid",teamId.toString())
        return teamId
    }

    override fun showLoading() {
        //pgbar_teamDetails.visibility = View.VISIBLE

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_details)
        presenter.onViewAttached(this)
    }
}
