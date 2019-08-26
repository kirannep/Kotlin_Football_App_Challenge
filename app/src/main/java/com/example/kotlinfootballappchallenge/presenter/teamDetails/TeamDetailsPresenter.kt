package com.example.kotlinfootballappchallenge.presenter.teamDetails

import android.content.Intent
import android.util.Log
import com.example.kotlinfootballappchallenge.model.FootballTeam
import com.example.kotlinfootballappchallenge.model.Teams
import com.example.kotlinfootballappchallenge.network.FootballTeamRequest
import com.example.kotlinfootballappchallenge.network.RetrofitInstanceTeam
import com.example.kotlinfootballappchallenge.view.teamDetails.TeamDetailsActivity
import retrofit2.*

class TeamDetailsPresenter:BasePresenter<TeamView>() {
    override fun onViewAttached(view: TeamView) {
        super.onViewAttached(view)
        val teamRequest = RetrofitInstanceTeam().retrofitInstanceTeam.create(FootballTeamRequest::class.java)
        val TeamId:Int = view.getID()
        Log.d("onviewid",TeamId.toString())
        val call: Call<Teams> = teamRequest.getTeamInfo(TeamId)
        call.enqueue(object:Callback<Teams>{
            override fun onFailure(call: Call<Teams>, t: Throwable) {
                Log.d("errormsg",t.message)
            }

            override fun onResponse(call: Call<Teams>, response: Response<Teams>) {
                val res = response.body()
                Log.d("teamDes", res!!.strDescriptionEN)
                view.showTeamdetailsinfo(res!!)
            }
        })
    }
}

interface TeamView:BasePresenter.View{
  fun showLoading()
  fun showTeamdetailsinfo(footballTeam: Teams)
    fun getID():Int

}