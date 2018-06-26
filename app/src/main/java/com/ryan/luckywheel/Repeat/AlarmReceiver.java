package com.ryan.luckywheel.Repeat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.ryan.luckywheel.Main2Activity;
import com.ryan.luckywheel.MainActivity;
import com.ryan.luckywheel.Splash;

public class AlarmReceiver extends BroadcastReceiver {
     String i="alarmData";
     MainActivity ma;


    @Override
    public void onReceive(Context arg0, Intent arg1) {
        // For our recurring task, we'll just display a message
       // Toast.makeText(arg0, "I'm running", Toast.LENGTH_SHORT).show();
      //  arg0.startActivity(new Intent(arg0, MainActivity.class));

        Intent showadintnt = new Intent(arg0, Main2Activity.class);
        showadintnt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        showadintnt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        showadintnt.putExtra("key",i);
        arg0.startActivity(showadintnt);
       // updateUI(intent);
       /* ma.updateUI(arg1);
        Log.d("Alarm","On receive called");*/
    }
}
