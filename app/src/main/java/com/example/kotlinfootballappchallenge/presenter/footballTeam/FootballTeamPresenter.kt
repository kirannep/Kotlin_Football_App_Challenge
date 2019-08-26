package com.example.kotlinfootballappchallenge.presenter.footballTeam

import android.util.Log
import com.example.kotlinfootballappchallenge.model.footballTeam.FootballTeam
import com.example.kotlinfootballappchallenge.network.FootballTeamRequest
import com.example.kotlinfootballappchallenge.network.RetrofitInstanceTeam
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FootballTeamPresenter: BasePresenter<FootballTeamView>() {

    override fun onViewAttached(view: FootballTeamView) {
        super.onViewAttached(view)
        val teamRequest = RetrofitInstanceTeam().retrofitInstanceTeam.create(
            FootballTeamRequest::class.java)
        val call: Call<FootballTeam> = teamRequest.getTeam("English Premier League")
        call.enqueue(object: Callback<FootballTeam>{
            override fun onFailure(call: Call<FootballTeam>, t: Throwable) {
                Log.d("errormsg: ",t.message)
            }

            override fun onResponse(call: Call<FootballTeam>, response: Response<FootballTeam>) {
                val res = response.body()
                Log.i("myteam", res!!.teams[0].strTeam)
                Log.i("myteam1", res!!.teams[1].strTeam)
                view.showFootballTeamInfo(res!!)
            }
        })
    }
}

interface FootballTeamView:BasePresenter.View{
    fun showLoading()
    fun showFootballTeamInfo(footballTeam: FootballTeam)
}