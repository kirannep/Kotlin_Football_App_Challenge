package com.example.kotlinfootballappchallenge.network.footballTeam

import com.example.kotlinfootballappchallenge.model.FootballTeam
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FootballTeamRequest {
    @GET("search_all_teams.php")
   fun getTeam(@Query("l") footballTeam:String): Call<FootballTeam>


}