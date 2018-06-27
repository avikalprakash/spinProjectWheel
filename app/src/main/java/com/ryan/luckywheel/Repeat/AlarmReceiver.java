package com.ryan.luckywheel.Repeat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import com.ryan.luckywheel.Main2Activity;
import com.ryan.luckywheel.MainActivity;
import com.ryan.luckywheel.Splash;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class AlarmReceiver extends BroadcastReceiver {
     String i="alarmData";
     MainActivity ma;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onReceive(Context arg0, Intent arg1) {



        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String dateString = sdf.format(new Date());


        Log.d("ttttttimmm", dateString);

        if(dateString.equals("12:00")||dateString.equals("12:01")) {
            Intent showadintnt = new Intent(arg0, Main2Activity.class);
            showadintnt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            showadintnt.addFlags(FLAG_ACTIVITY_CLEAR_TASK | FLAG_ACTIVITY_NEW_TASK);
            showadintnt.putExtra("key", i);
            arg0.startActivity(showadintnt);
        }else if(dateString.equals("13:00")||dateString.equals("13:01")) {
            Intent showadintnt = new Intent(arg0, Main2Activity.class);
            showadintnt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | FLAG_ACTIVITY_NEW_TASK);
            showadintnt.addFlags(FLAG_ACTIVITY_CLEAR_TASK);
            showadintnt.putExtra("key", i);
            arg0.startActivity(showadintnt);
        }else if(dateString.equals("14:00")||dateString.equals("14:01")) {
            Intent showadintnt = new Intent(arg0, Main2Activity.class);
            showadintnt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | FLAG_ACTIVITY_NEW_TASK);
            showadintnt.addFlags(FLAG_ACTIVITY_CLEAR_TASK);
            showadintnt.putExtra("key", i);
            arg0.startActivity(showadintnt);
        }else if(dateString.equals("15:00")||dateString.equals("15:01")) {
            Intent showadintnt = new Intent(arg0, Main2Activity.class);
            showadintnt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | FLAG_ACTIVITY_NEW_TASK );
            showadintnt.addFlags(FLAG_ACTIVITY_CLEAR_TASK);
            showadintnt.putExtra("key", i);
            arg0.startActivity(showadintnt);
        }else if(dateString.equals("16:00")||dateString.equals("16:01")) {
            Intent showadintnt = new Intent(arg0, Main2Activity.class);
            showadintnt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | FLAG_ACTIVITY_NEW_TASK);
            showadintnt.addFlags(FLAG_ACTIVITY_CLEAR_TASK);
            showadintnt.putExtra("key", i);
            arg0.startActivity(showadintnt);
        }else if(dateString.equals("17:00")||dateString.equals("17:01")) {
            Intent showadintnt = new Intent(arg0, Main2Activity.class);
            showadintnt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | FLAG_ACTIVITY_NEW_TASK );
            showadintnt.setFlags(FLAG_ACTIVITY_CLEAR_TASK);
            showadintnt.putExtra("key", i);
            arg0.startActivity(showadintnt);
        }else if(dateString.equals("18:00")||dateString.equals("18:01")) {
            Intent showadintnt = new Intent(arg0, Main2Activity.class);
            showadintnt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | FLAG_ACTIVITY_NEW_TASK );
            showadintnt.addFlags(FLAG_ACTIVITY_CLEAR_TASK);
            showadintnt.putExtra("key", i);
            arg0.startActivity(showadintnt);
        }else if(dateString.equals("19:00")||dateString.equals("19:01")) {
            Intent showadintnt = new Intent(arg0, Main2Activity.class);
            showadintnt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | FLAG_ACTIVITY_NEW_TASK );
            showadintnt.addFlags(FLAG_ACTIVITY_CLEAR_TASK);
            showadintnt.putExtra("key", i);
            arg0.startActivity(showadintnt);
        }else if(dateString.equals("20:00")||dateString.equals("20:01")) {
            Intent showadintnt = new Intent(arg0, Main2Activity.class);
            showadintnt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | FLAG_ACTIVITY_NEW_TASK );
            showadintnt.addFlags(FLAG_ACTIVITY_CLEAR_TASK);
            showadintnt.putExtra("key", i);
            arg0.startActivity(showadintnt);
        }


       // updateUI(intent);
       /* ma.updateUI(arg1);
        Log.d("Alarm","On receive called");*/
    }
}
