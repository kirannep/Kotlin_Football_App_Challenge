package com.example.kotlinfootballappchallenge.view.footballTeam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfootballappchallenge.R
import com.example.kotlinfootballappchallenge.model.FootballTeam
import kotlinx.android.synthetic.main.activity_football_team.view.*

class FootballTeamAdapter(private val footballTeam:FootballTeam):RecyclerView.Adapter<TeamViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_football_team,parent,false))
    }

    override fun getItemCount(): Int {
        return footballTeam.teams.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
       holder.tvTitle.text = footballTeam.teams[position].strTeam
    }


}

class TeamViewHolder(view: View):RecyclerView.ViewHolder(view){
    val tvTitle = view.tv_team
}