package com.example.kotlinfootballappchallenge.network

import com.example.kotlinfootballappchallenge.model.FootballTeam
import com.example.kotlinfootballappchallenge.model.Teams
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FootballTeamRequest {
    @GET("search_all_teams.php")
   fun getTeam(@Query("l") footballTeam:String): Call<FootballTeam>

    @GET("lookupteam.php")
    fun getTeamInfo(@Query("id") teamId:Int): Call<Teams>

//    @GET("lookupteam.php/{id}")
//    fun getTeamInfo(@Path("id") id:Int) :Call<Teams>
//
 }