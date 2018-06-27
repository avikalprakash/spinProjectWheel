package com.ryan.luckywheel;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ryan.luckywheel.Repeat.AlarmReceiver;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import rubikstudio.library.LuckyWheelView;
import rubikstudio.library.model.LuckyItem;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   static List<LuckyItem> data = new ArrayList<>();
    final public static String ONE_TIME = "onetime";
    TextView liveText;
    LuckyWheelView luckyWheelView;
    ImageView play;
    int i;

    int REQUEST_CODE=0;
    int REQUEST_CODE2=1;
    int REQUEST_CODE3=2;
    int REQUEST_CODE4=3;
    int REQUEST_CODE5=4;
    int REQUEST_CODE6=5;
    int REQUEST_CODE7=6;
    int REQUEST_CODE8=7;
    int REQUEST_CODE9=8;

    int FIRST_TURN_HOUR=12;
    int FIRST_TURN_MINUTE=00;
    int FIRST_TURN_SECOND=01;


    int SECOND_TURN_HOUR=13;
    int SECOND_TURN_MINUTE=00;
    int SECOND_TURN_SECOND=01;

    int THIRD_TURN_HOUR=14;
    int THIRD_TURN_MINUTE=00;
    int THIRD_TURN_SECOND=01;

    int FORTH_TURN_HOUR=15;
    int FORTH_TURN_MINUTE=00;
    int FORTH_TURN_SECOND=01;

    int FIFTH_TURN_HOUR=16;
    int FIFTH_TURN_MINUTE=00;
    int FIFTH_TURN_SECOND=01;

    int SIXTH_TURN_HOUR=17;
    int SIXTH_TURN_MINUTE=00;
    int SIXTH_TURN_SECOND=01;

    int SEVEN_TURN_HOUR=18;
    int SEVEN_TURN_MINUTE=00;
    int SEVEN_TURN_SECOND=01;

    int EIGHT_TURN_HOUR=19;
    int EIGHT_TURN_MINUTE=00;
    int EIGHT_TURN_SECOND=01;

    int NINE_TURN_HOUR=20;
    int NINE_TURN_MINUTE=00;
    int NINE_TURN_SECOND=01;
    Context context;
    String iAlarm="";
    LinearLayout previousList, upcomingList;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    boolean mIsReceiverRegistered = false;
   // MyBroadcastReceiver mReceiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String dateString = sdf.format(new Date());
        Log.d("dateeeeeeeeeeeee",dateString);
        context=this;
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              startActivity(new Intent(getApplicationContext(), Main2Activity.class));
            }
        }, 3000);*/

        liveText=(TextView)findViewById(R.id.live);
        previousList=(LinearLayout)findViewById(R.id.previousList);
        upcomingList=(LinearLayout)findViewById(R.id.upcomingList);
         luckyWheelView = (LuckyWheelView) findViewById(R.id.luckyWheel);
         previousList.setOnClickListener(this);
         upcomingList.setOnClickListener(this);


        java.text.SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy,  hh:mm");
        String mydate = simpleDateFormat.format(new Date());
        TextView time = (TextView)findViewById(R.id.time);
        time.setText(mydate+" am");

         //5,8,2,0

        data.clear();

        int lo=0, l1=9, l2=1, l3=8, l4=2, l5=7, l6=3, l7=6, l8=4, l9=5;

        //zero
        LuckyItem luckyItem0 = new LuckyItem();
        luckyItem0.text = "0";
        //   luckyItem0.icon = R.drawable.test1;
        luckyItem0.color = 0xFFFF9E80;
        data.add(luckyItem0);



        // one
        LuckyItem luckyItem9 = new LuckyItem();
        luckyItem9.text = "9";
        //    luckyItem9.icon = R.drawable.test9;
        // luckyItem9.color = 0xffFFCC80;
        luckyItem9.color = 0xFFFFC400;
        data.add(luckyItem9);


        //two
        LuckyItem luckyItem1 = new LuckyItem();
        luckyItem1.text = "1";
        //  luckyItem1.icon = R.drawable.test1;
        luckyItem1.color = 0xFFDCE775;
        data.add(luckyItem1);

        //three
        LuckyItem luckyItem8 = new LuckyItem();
        luckyItem8.text = "8";
        //    luckyItem8.icon = R.drawable.test8;
        luckyItem8.color = 0xffFFF3E0;
        data.add(luckyItem8);


        //four
        LuckyItem luckyItem2 = new LuckyItem();
        luckyItem2.text = "2";
//      luckyItem2.icon = R.drawable.test2;
        luckyItem2.color = 0xFFFFCDD2;
        data.add(luckyItem2);

        //five
        LuckyItem luckyItem7 = new LuckyItem();
        luckyItem7.text = "7";
        //    luckyItem7.icon = R.drawable.test7;
        luckyItem7.color = 0xFFFF9E80;
        data.add(luckyItem7);


        //six
        LuckyItem luckyItem3 = new LuckyItem();
        luckyItem3.text = "3";
        //   luckyItem3.icon = R.drawable.test3;
        luckyItem3.color = 0xFFFFC400;
        data.add(luckyItem3);


        //seven
        LuckyItem luckyItem6 = new LuckyItem();
        luckyItem6.text = "6";
        //    luckyItem6.icon = R.drawable.test6;
        luckyItem6.color = 0xFFDCE775;
        data.add(luckyItem6);

        //eight
        LuckyItem luckyItem4 = new LuckyItem();
        luckyItem4.text = "4";
        //    luckyItem4.icon = R.drawable.test4;
        luckyItem4.color = 0xffFFF3E0;
        data.add(luckyItem4);


        //nine
        LuckyItem luckyItem5 = new LuckyItem();
        luckyItem5.text = "5";
        //   luckyItem5.icon = R.drawable.test5;
        luckyItem5.color = 0xFFFFCDD2;
        data.add(luckyItem5);


      /*  LuckyItem luckyItem10 = new LuckyItem();
        luckyItem10.text = "1000";
        luckyItem10.icon = R.drawable.test10;
        luckyItem10.color = 0xffFFE0B2;
        data.add(luckyItem10);

        LuckyItem luckyItem11 = new LuckyItem();
        luckyItem11.text = "2000";
        luckyItem11.icon = R.drawable.test10;
        luckyItem11.color = 0xffFFE0B2;
        data.add(luckyItem11);

        LuckyItem luckyItem12 = new LuckyItem();
        luckyItem12.text = "3000";
        luckyItem12.icon = R.drawable.test10;
        luckyItem12.color = 0xffFFE0B2;
        data.add(luckyItem12);*/

        /////////////////////

        luckyWheelView.setData(data);
        luckyWheelView.setRound(getRandomRound());

       /* luckyWheelView.setLuckyWheelBackgrouldColor(0xff0000ff);
        luckyWheelView.setLuckyWheelTextColor(0xffcc0000);*/
        luckyWheelView.setLuckyWheelCenterImage(getResources().getDrawable(R.drawable.round));
        luckyWheelView.setLuckyWheelCursorImage(R.drawable.ic_cursor);

      /*  luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                if (index==0){
                  //  AlertDialog(0);
                    live.setText("Live : " + String.valueOf(0));
                }else {
                  //  AlertDialog(index - 1);
                    live.setText("Live : " + String.valueOf(index - 1));
                }
            }
        });*/
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String live = prefs.getString("live", "");
        if (!live.equals("")|| live!=null){
            liveText.setText("Live : "+live);
        }
       if (getIntent().getStringExtra("key")!=null) {
           iAlarm = getIntent().getStringExtra("key");
           if (iAlarm.equals("alarmData")) {
               //auto play wheel
               Log.d("check1", iAlarm);
               int index = getRandomIndex();
               luckyWheelView.startLuckyWheelWithTargetIndex(index);
           }
       }
           startAlarm(context);

    }



    private static int getRandomIndex() {
        Random rand = new Random();
        return rand.nextInt(data.size() - 1) + 0;
    }

    private int getRandomRound() {
        Random rand = new Random();
        return rand.nextInt(10) + 15;
    }

    public void AlertDialog(int index){
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View subView = inflater.inflate(R.layout.logout_alert, null);
        final TextView ok = (TextView) subView.findViewById(R.id.ok);
        final  TextView text =(TextView)subView.findViewById(R.id.text);


        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setView(subView);
        final AlertDialog alertDialog = builder1.show();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        text.setText("Congratulation You got number : "+String.valueOf(index));
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              alertDialog.dismiss();
            }
        });
    }

   /* public static void updateUI(Intent intent) {
        // Do what you need to do
        int index = getRandomIndex();
        luckyWheelView.startLuckyWheelWithTargetIndex(index);
    }*/

    public void startAlarm(Context context) {

        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiver.class);

        Calendar firstTurn = Calendar.getInstance();
        Calendar secondTurn = Calendar.getInstance();
        Calendar thirdTurn = Calendar.getInstance();
        Calendar forthTurn = Calendar.getInstance();
        Calendar fifthTurn = Calendar.getInstance();
        Calendar sixthTurn = Calendar.getInstance();
        Calendar seventhTurn = Calendar.getInstance();
        Calendar eighthTurn = Calendar.getInstance();
        Calendar nineTurn = Calendar.getInstance();

        // set times
        firstTurn.setTimeInMillis(System.currentTimeMillis());
        firstTurn.set(Calendar.HOUR_OF_DAY, FIRST_TURN_HOUR);
        firstTurn.set(Calendar.MINUTE, FIRST_TURN_MINUTE);
        firstTurn.set(Calendar.SECOND, FIRST_TURN_SECOND);
        firstTurn.set(Calendar.MILLISECOND, FIRST_TURN_SECOND);

        Log.d("hhhhh", "uuuu");
        Log.d("time1", String.valueOf(System.currentTimeMillis()));
        //context.sendBroadcast(intent);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, REQUEST_CODE, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        secondTurn.setTimeInMillis(System.currentTimeMillis());
        secondTurn.set(Calendar.HOUR_OF_DAY, SECOND_TURN_HOUR);
        secondTurn.set(Calendar.MINUTE, SECOND_TURN_MINUTE);
        secondTurn.set(Calendar.SECOND, SECOND_TURN_SECOND);
        secondTurn.set(Calendar.MILLISECOND, SECOND_TURN_SECOND);
        Log.d("ppppp", "iiii");
        PendingIntent alarmIntent2 = PendingIntent.getBroadcast(context, REQUEST_CODE2, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        thirdTurn.setTimeInMillis(System.currentTimeMillis());
        thirdTurn.set(Calendar.HOUR_OF_DAY, THIRD_TURN_HOUR);
        thirdTurn.set(Calendar.MINUTE, THIRD_TURN_MINUTE);
        thirdTurn.set(Calendar.SECOND, THIRD_TURN_SECOND);
        thirdTurn.set(Calendar.MILLISECOND, THIRD_TURN_SECOND);
        Log.d("ssssss", "llll");
        PendingIntent alarmIntent3 = PendingIntent.getBroadcast(context, REQUEST_CODE3, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        forthTurn.setTimeInMillis(System.currentTimeMillis());
        forthTurn.set(Calendar.HOUR_OF_DAY, FORTH_TURN_HOUR);
        forthTurn.set(Calendar.MINUTE, FORTH_TURN_MINUTE);
        forthTurn.set(Calendar.SECOND, FORTH_TURN_SECOND);
        forthTurn.set(Calendar.MILLISECOND, FORTH_TURN_SECOND);

        //context.sendBroadcast(intent);
        PendingIntent alarmIntent4 = PendingIntent.getBroadcast(context, REQUEST_CODE4, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        fifthTurn.setTimeInMillis(System.currentTimeMillis());
        fifthTurn.set(Calendar.HOUR_OF_DAY, FIFTH_TURN_HOUR);
        fifthTurn.set(Calendar.MINUTE, FIFTH_TURN_MINUTE);
        fifthTurn.set(Calendar.SECOND, FIFTH_TURN_SECOND);
        fifthTurn.set(Calendar.MILLISECOND, FIFTH_TURN_SECOND);

        PendingIntent alarmIntent5 = PendingIntent.getBroadcast(context, REQUEST_CODE5, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        sixthTurn.setTimeInMillis(System.currentTimeMillis());
        sixthTurn.set(Calendar.HOUR_OF_DAY, SIXTH_TURN_HOUR);
        sixthTurn.set(Calendar.MINUTE, SIXTH_TURN_MINUTE);
        sixthTurn.set(Calendar.SECOND, SIXTH_TURN_SECOND);
        sixthTurn.set(Calendar.MILLISECOND, SIXTH_TURN_SECOND);

        PendingIntent alarmIntent6 = PendingIntent.getBroadcast(context, REQUEST_CODE6, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        seventhTurn.setTimeInMillis(System.currentTimeMillis());
        seventhTurn.set(Calendar.HOUR_OF_DAY, SEVEN_TURN_HOUR);
        seventhTurn.set(Calendar.MINUTE, SEVEN_TURN_MINUTE);
        seventhTurn.set(Calendar.SECOND, SEVEN_TURN_SECOND);
        seventhTurn.set(Calendar.MILLISECOND, SEVEN_TURN_SECOND);

        PendingIntent alarmIntent7 = PendingIntent.getBroadcast(context, REQUEST_CODE7, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        eighthTurn.setTimeInMillis(System.currentTimeMillis());
        eighthTurn.set(Calendar.HOUR_OF_DAY, EIGHT_TURN_HOUR);
        eighthTurn.set(Calendar.MINUTE, EIGHT_TURN_MINUTE);
        eighthTurn.set(Calendar.SECOND, EIGHT_TURN_SECOND);
        eighthTurn.set(Calendar.MILLISECOND, EIGHT_TURN_SECOND);

        PendingIntent alarmIntent8 = PendingIntent.getBroadcast(context, REQUEST_CODE8, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        nineTurn.setTimeInMillis(System.currentTimeMillis());
        nineTurn.set(Calendar.HOUR_OF_DAY, NINE_TURN_HOUR);
        nineTurn.set(Calendar.MINUTE, NINE_TURN_MINUTE);
        nineTurn.set(Calendar.SECOND, NINE_TURN_SECOND);
        nineTurn.set(Calendar.MILLISECOND, NINE_TURN_SECOND);


        PendingIntent alarmIntent9 = PendingIntent.getBroadcast(context, REQUEST_CODE9, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        alarmMgr.cancel(alarmIntent);
        alarmMgr.cancel(alarmIntent2);
        alarmMgr.cancel(alarmIntent3);
        alarmMgr.cancel(alarmIntent4);
        alarmMgr.cancel(alarmIntent5);
        alarmMgr.cancel(alarmIntent6);
        alarmMgr.cancel(alarmIntent7);
        alarmMgr.cancel(alarmIntent8);
        alarmMgr.cancel(alarmIntent9);
        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstTurn.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);
        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, secondTurn.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent2);
        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, thirdTurn.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent3);
        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, forthTurn.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent4);
        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, fifthTurn.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent5);
        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, sixthTurn.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent6);
        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, seventhTurn.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent7);
        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, eighthTurn.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent8);
        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, nineTurn.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent9);

/*
        boolean alarmUp = (alarmIntent9 != null);
        boolean alarmUp2 = (alarmIntent9 != null);
        boolean alarmUp3 = (alarmIntent9 != null);
        boolean alarmUp4 = (alarmIntent9 != null);
        boolean alarmUp5 = (alarmIntent9 != null);
        boolean alarmUp6 = (alarmIntent9 != null);
        boolean alarmUp7 = (alarmIntent9 != null);
        boolean alarmUp8 = (alarmIntent9 != null);
        boolean alarmUp9 = (alarmIntent9 != null);

        if (alarmUp) {
            Log.d("myTag", "Alarm is already active");
        }
        if (alarmUp2) {
            Log.d("myTag2", "Alarm is already active2");
        }
        if (alarmUp3) {
            Log.d("myTag3", "Alarm is already active3");
        }
        if (alarmUp4) {
            Log.d("myTag4", "Alarm is already active4");
        }
        if (alarmUp5) {
            Log.d("myTag5", "Alarm is already active5");
        }
        if (alarmUp6) {
            Log.d("myTag6", "Alarm is already active6");
        }
        if (alarmUp7) {
            Log.d("myTag7", "Alarm is already active7");
        }
        if (alarmUp8) {
            Log.d("myTag8", "Alarm is already active8");
        }
        if (alarmUp9) {
            Log.d("myTag9", "Alarm is already active8");
        }*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.previousList:
                startActivity(new Intent(getApplicationContext(), PreviousActivity.class));
                break;

            case R.id.upcomingList:
                startActivity(new Intent(getApplicationContext(), UpcomingActivity.class));
                break;
        }
    }

  /*  private class MyBroadcastReceiver extends BroadcastReceiver {
        String i="alarmData";

        @Override
        public void onReceive(Context context, Intent intent) {
            updateUI(intent);
            Log.d("hgh", i);
        }
    }*/
}
