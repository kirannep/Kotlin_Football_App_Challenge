package com.example.kotlinfootballappchallenge.view.footballTeam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfootballappchallenge.R
import com.example.kotlinfootballappchallenge.model.FootballTeam
import com.example.kotlinfootballappchallenge.model.Teams
import kotlinx.android.synthetic.main.activity_football_team.view.*

class FootballTeamAdapter(private val footballTeam:FootballTeam,private val listener: onTeamClickedListener):RecyclerView.Adapter<TeamViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_football_team,parent,false))
    }

    override fun getItemCount(): Int {
        return footballTeam.teams.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
       holder.tvTitle.text = footballTeam.teams[position].strTeam
       holder.bind(footballTeam.teams[position],listener)
    }


}

class TeamViewHolder(view: View):RecyclerView.ViewHolder(view){
    fun bind(teams: Teams,listener: onTeamClickedListener){
        itemView.setOnClickListener{
            listener.onTeamClicked(teams)
        }
    }
    val tvTitle = view.tv_team
}

interface onTeamClickedListener{
    fun onTeamClicked(teams: Teams)
}