package com.example.kotlinfootballappchallenge.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.squareup.picasso.Picasso

fun ViewGroup.inflate(@LayoutRes layoutRes:Int,attachToRoot:Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes,this,attachToRoot)
}

fun ImageView.loadUrl(url:String){
    return Picasso.get()
        .load(url)
        .into(this)
}

fun List<String>.toIntList():MutableList<Int>{
    var list : MutableList<Int> = mutableListOf()
    for(item in this){
        list.add(item.toInt())
    }
    return list
}

//The below two works similarly, equal sign works as returning value
//fun String.removeFirstLetter() : String{
//                                          return this.substring(1)
//                                      }
//fun String.removeFirstLetter() : String =   this.substring(1)