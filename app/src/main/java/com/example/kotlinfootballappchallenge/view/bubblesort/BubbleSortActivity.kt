package com.example.kotlinfootballappchallenge.view.bubblesort

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kotlinfootballappchallenge.R
import com.example.kotlinfootballappchallenge.common.toIntList
import com.example.kotlinfootballappchallenge.presenter.asyncTask.BubbleSortPresenter
import com.example.kotlinfootballappchallenge.presenter.asyncTask.SortView
import kotlinx.android.synthetic.main.activity_bubble_sort.*
import java.util.*
import kotlin.collections.ArrayList

class BubbleSortActivity : AppCompatActivity(),SortView, View.OnClickListener {
    val presenter:BubbleSortPresenter = BubbleSortPresenter()

    override fun onClick(p0: View?) {
        when (p0!!.id){
            R.id.btn_sort ->{
                presenter.onViewAttached(this)
            }
        }
    }

    override fun showLoading(arr:MutableList<Int>) {
        tv_resultArray.text = arr.toString()
        Log.d("displaysortedarray",arr.toString())
    }

    override fun inputarray(): MutableList<Int> {
        var inputnum = et_array.text.toString().split(",").toIntList()
        Log.d("inputnum",inputnum.toString())
        return inputnum
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bubble_sort)
        btn_sort.setOnClickListener(this)
    }
}
