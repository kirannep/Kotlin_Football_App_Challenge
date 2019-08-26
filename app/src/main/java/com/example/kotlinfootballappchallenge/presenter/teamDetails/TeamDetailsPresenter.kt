package com.example.kotlinfootballappchallenge.presenter.teamDetails

import android.util.Log
import android.widget.ProgressBar
import com.example.kotlinfootballappchallenge.model.footballTeam.FootballTeam
import com.example.kotlinfootballappchallenge.model.teamDetails.TeamDetails
import com.example.kotlinfootballappchallenge.network.FootballTeamRequest
import com.example.kotlinfootballappchallenge.network.RetrofitInstanceTeam
import retrofit2.*

class TeamDetailsPresenter:BasePresenter<TeamView>() {

    override fun onViewAttached(view: TeamView) {
        super.onViewAttached(view)
        val teamRequest = RetrofitInstanceTeam().retrofitInstanceTeam.create(FootballTeamRequest::class.java)
        val TeamId:Int = view.getID()
        Log.d("onviewid",TeamId.toString())
        view.showLoading()
        val call: Call<TeamDetails> = teamRequest.getTeamInfo(TeamId)
        call.enqueue(object:Callback<TeamDetails>{
            override fun onFailure(call: Call<TeamDetails>, t: Throwable) {
                Log.d("errormsg",t.message)
            }

            override fun onResponse(call: Call<TeamDetails>, response: Response<TeamDetails>) {
                val res = response.body()
                Log.d("res",res.toString())
                Log.d("teamDes", ""+res!!.teams[0].strDescriptionEN)
//                Log.d("teamName",""+res!!.strTeam)
//                Log.d("teamStadium",""+res!!.strStadium)
//                Log.d("teamid",""+res!!.idTeam)
                view.showTeamdetailsinfo(res!!)
            }
        })
    }
}

interface TeamView:BasePresenter.View{
  fun showLoading():ProgressBar
  fun showTeamdetailsinfo(footballTeam: TeamDetails)
    fun getID():Int

}