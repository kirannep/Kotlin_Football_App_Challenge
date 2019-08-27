package com.example.kotlinfootballappchallenge.presenter.asyncTask

import android.os.AsyncTask
import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

class BubbleSortPresenter:BasePresenter<SortView>() {
    override fun onViewAttached(view: SortView) {
        super.onViewAttached(view)
        var numarray:MutableList<Int> = view.inputarray()
        Log.d("firstarray",numarray[0].toString())
        MyAsync(numarray,view).execute()
    }

    inner class MyAsync(val arr:MutableList<Int>,view:View):AsyncTask<Void,Void,MutableList<Int>>(){
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg view: Void?): MutableList<Int> {
            var swap = true
            while(swap){
                swap = false
                for(i in 0 until arr!!.size-1){
                    if(arr!![i] > arr!![i+1]){
                        val temp = arr!![i]
                        arr!![i] = arr!![i+1]
                        arr!![i + 1] = temp
                        swap = true
                    }
                }
            }
            Log.d("sortarray",arr.toString())
            return arr!!
        }

        override fun onPostExecute(result: MutableList<Int>?) {
            super.onPostExecute(result)
            view!!.showLoading(arr)
        }

    }
}

interface SortView:BasePresenter.View{
    fun showLoading(arr:MutableList<Int>)
    fun inputarray():MutableList<Int>
}