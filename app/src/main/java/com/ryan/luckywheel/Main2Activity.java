package com.ryan.luckywheel;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import rubikstudio.library.LuckyWheelView;
import rubikstudio.library.model.LuckyItem;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    List<LuckyItem> data = new ArrayList<>();
    final public static String ONE_TIME = "onetime";
    TextView liveText;
    LuckyWheelView luckyWheelView;
    ImageView play;
    int i;
    private PendingIntent pendingIntent;
    private AlarmManager manager;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    int checkEntry = 0;

    private ProgressDialog pDialog;
    Context context;
    String iAlarm = "";
    int key=0;
    int lo=0, l1=9, l2=1, l3=8, l4=2, l5=7, l6=3, l7=6, l8=4, l9=5;
    int nn=0;
    SharedPreferences.Editor editor;
    SharedPreferences prefs2;

    LinearLayout previousList, upcomingList;
    int iNumber;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.righttoleft, R.anim.stable);
        context = this;

        liveText = (TextView) findViewById(R.id.live);
        previousList = (LinearLayout) findViewById(R.id.previousList);
        upcomingList=(LinearLayout)findViewById(R.id.upcomingList);
        luckyWheelView = (LuckyWheelView) findViewById(R.id.luckyWheel);
        previousList.setOnClickListener(this);
        upcomingList.setOnClickListener(this);

        String mydate = java.text.DateFormat.getDateTimeInstance().format(java.util.Calendar.getInstance().getTime());
        TextView time = (TextView)findViewById(R.id.time);
        time.setText(mydate);


        //5,8,2,0
        data.clear();

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


        prefs2 = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String live = prefs2.getString("live", "");
        if (!live.equals("")|| live!=null){
            liveText.setText("Live : "+live);
        }


        //prefs2.edit().clear().commit();


        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        key = prefs.getInt("idName", 0); //0 is the default value.


       // Login();
      //  new SendData().execute();
        Log.d("keyCheck", String.valueOf(key));

        if (getIntent().getStringExtra("key") != null) {
            iAlarm = getIntent().getStringExtra("key");
            if (iAlarm.equals("alarmData")) {
                //auto play wheel
                new SendData().execute();
                Log.d("check1", iAlarm);
                // int index = getRandomIndex();

            }
        }

        if(key<8){
            key++;
            SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
            editor.putInt("idName", key);
            editor.apply();
        }else if (key==8){
            SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
            editor.putInt("idName", key);
            editor.apply();
        }
        else if (key>8){
            key=0;
            SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
            editor.putInt("idName", key);
            editor.apply();
        }




        luckyWheelView.setData(data);
        luckyWheelView.setRound(getRandomRound());


        luckyWheelView.setLuckyWheelCenterImage(getResources().getDrawable(R.drawable.round));
        luckyWheelView.setLuckyWheelCursorImage(R.drawable.ic_cursor);




    }
    private int getRandomIndex() {
        Random rand = new Random();
        return rand.nextInt(data.size() - 1) + 0;
    }

    private int getRandomRound() {
        Random rand = new Random();
        return rand.nextInt(10) + 15;
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


    @RequiresApi(api = Build.VERSION_CODES.N)
    class SendData extends AsyncTask<String, Void, String> {

        private ProgressDialog pDialog;
        //get Current date
        Date c = Calendar.getInstance().getTime();


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c);




        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Main2Activity.this);
            pDialog.setMessage("Please Wait ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected String doInBackground(String... args) {
            String s = "";


            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://condoassist2u.com/casinofun/api/liveResult.php");
                httpPost.setHeader("Content-type", "application/json");
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("date", formattedDate);
                jsonObject.accumulate("key", key);
                StringEntity stringEntity = new StringEntity(jsonObject.toString());
                httpPost.setEntity(stringEntity);
                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                s = readadsResponse(httpResponse);
                Log.d("tag1", " " + s);
            } catch (Exception exception) {
                exception.printStackTrace();

                Log.d("espone",exception.toString());

            }

            return s;

        }
        @Override
        protected void onPostExecute(String json) {
            super.onPostExecute(json);
            pDialog.dismiss();
            try {
                JSONObject objone = new JSONObject(json);
                boolean check  = objone.getBoolean("error");
                if(!check) {
                  String live = objone.getString("live");
                  String message= objone.getString("message");
                  Log.d("live_number", live);
                  if (!live.equals("")&& !live.equals("null")) {
                      iNumber = Integer.parseInt(live);
                  }
//Add the bundle to the intent
                    int lo=0, l1=9, l2=1, l3=8, l4=2, l5=7, l6=3, l7=6, l8=4, l9=5;
                    //need to add +1 number suppose you want 9 num the you need to call l1+1(1+1)
                    //suppose you want 7 num the you need to call l5+1(5+1)
                    if (iNumber==0){
                        luckyWheelView.startLuckyWheelWithTargetIndex(0);
                        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
                            @Override
                            public void LuckyRoundItemSelected(int index) {
                                liveText.setText("Live : " +String.valueOf(0));
                                 editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                editor.putString("live", String.valueOf(0));
                                editor.apply();

                            }
                        });
                       //
                    }else if (iNumber==1){
                        luckyWheelView.startLuckyWheelWithTargetIndex(3);
                        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
                            @Override
                            public void LuckyRoundItemSelected(int index) {
                                liveText.setText("Live : " +String.valueOf(1));
                                 editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                editor.putString("live", String.valueOf(1));
                                editor.apply();

                            }
                        });
                    }else if (iNumber==2){
                        luckyWheelView.startLuckyWheelWithTargetIndex(5);
                        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
                            @Override
                            public void LuckyRoundItemSelected(int index) {
                                liveText.setText("Live : " +String.valueOf(2));
                                editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                editor.putString("live", String.valueOf(2));
                                editor.apply();

                            }
                        });
                    }else if (iNumber==3){
                        luckyWheelView.startLuckyWheelWithTargetIndex(7);
                        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
                            @Override
                            public void LuckyRoundItemSelected(int index) {
                                liveText.setText("Live : " +String.valueOf(3));
                                 editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                editor.putString("live", String.valueOf(3));
                                editor.apply();

                            }
                        });
                    }else if (iNumber==4){
                        luckyWheelView.startLuckyWheelWithTargetIndex(9);
                        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
                            @Override
                            public void LuckyRoundItemSelected(int index) {
                                liveText.setText("Live : " +String.valueOf(4));
                                 editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                editor.putString("live", String.valueOf(4));
                                editor.apply();

                            }
                        });
                    }else if (iNumber==5){
                        luckyWheelView.startLuckyWheelWithTargetIndex(10);
                        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
                            @Override
                            public void LuckyRoundItemSelected(int index) {
                                liveText.setText("Live : " +String.valueOf(5));
                                 editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                editor.putString("live", String.valueOf(5));
                                editor.apply();

                            }
                        });
                    }else if (iNumber==6){
                        luckyWheelView.startLuckyWheelWithTargetIndex(8);
                        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
                            @Override
                            public void LuckyRoundItemSelected(int index) {
                                liveText.setText("Live : " +String.valueOf(6));
                                 editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                editor.putString("live", String.valueOf(6));
                                editor.apply();

                            }
                        });
                    }else if (iNumber==7){
                        luckyWheelView.startLuckyWheelWithTargetIndex(6);
                        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
                            @Override
                            public void LuckyRoundItemSelected(int index) {
                                liveText.setText("Live : " +String.valueOf(7));
                                 editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                editor.putString("live", String.valueOf(7));
                                editor.apply();

                            }
                        });
                    }else if (iNumber==8){
                        luckyWheelView.startLuckyWheelWithTargetIndex(4);
                        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
                            @Override
                            public void LuckyRoundItemSelected(int index) {
                                liveText.setText("Live : " +String.valueOf(8));
                                 editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                editor.putString("live", String.valueOf(8));
                                editor.apply();

                            }
                        });
                    }else if (iNumber==9){
                        luckyWheelView.startLuckyWheelWithTargetIndex(2);
                        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
                            @Override
                            public void LuckyRoundItemSelected(int index) {
                                liveText.setText("Live : " +String.valueOf(9));
                                editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                editor.putString("live", String.valueOf(9));
                                editor.apply();

                            }
                        });
                    }
                    nn=1;
                   // luckyWheelView.startLuckyWheelWithTargetIndex(Integer.parseInt(live));
                   // Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    if (key==8) {
                        key++;
                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putInt("idName", key);
                        editor.apply();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                    }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    private String readadsResponse(HttpResponse httpResponse) {

        InputStream is = null;
        String return_text = "";
        try {
            is = httpResponse.getEntity().getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            StringBuffer sb = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return_text = sb.toString();
            Log.d("return1230", "" + return_text);
        } catch (Exception e) {

        }
        return return_text;
    }
}
