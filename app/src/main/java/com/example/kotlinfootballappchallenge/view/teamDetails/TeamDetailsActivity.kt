package com.example.kotlinfootballappchallenge.view.teamDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.example.kolinmoviegithubchallenge.common.loadUrl
import com.example.kotlinfootballappchallenge.R
import com.example.kotlinfootballappchallenge.model.footballTeam.Teams
import com.example.kotlinfootballappchallenge.model.teamDetails.TeamDetails
import com.example.kotlinfootballappchallenge.presenter.teamDetails.TeamDetailsPresenter
import com.example.kotlinfootballappchallenge.presenter.teamDetails.TeamView
import kotlinx.android.synthetic.main.activity_football_team.*
import kotlinx.android.synthetic.main.activity_team_details.*

class TeamDetailsActivity : AppCompatActivity(),TeamView {
    val presenter:TeamDetailsPresenter = TeamDetailsPresenter()

    override fun showLoading():ProgressBar {
        pgbar_teamDetails.visibility = View.VISIBLE
        return pgbar_teamDetails
    }

    override fun showTeamdetailsinfo(footballTeam: TeamDetails) {
        pgbar_teamDetails.visibility = View.GONE
        Thread.sleep(2000)
        tv_teamName.text = footballTeam.teams[0].strTeam
        tv_desc.text = footballTeam.teams[0].strDescriptionEN
        iv_teamDetailsBadge.loadUrl(footballTeam.teams[0].strTeamBadge)
    }

    override fun getID(): Int {
        val teamId:Int = intent.getIntExtra("teamID",0)
        Log.d("retroid",teamId.toString())
        return teamId
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_details)
        presenter.onViewAttached(this)
    }
}
