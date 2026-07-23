package com.definelab.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadCastExample: BroadcastReceiver()  {
    override fun onReceive(p0: Context?, p1: Intent?) {


        val isAirplaneMode : Boolean = p1!!.getBooleanExtra("state",false)

        if(isAirplaneMode){
            Toast.makeText(p0,"This device is in airplane mode",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(p0,"This device is not in airplane mode",Toast.LENGTH_LONG).show()
        }


    }
}