package com.ryan.luckywheel;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ryan.luckywheel.Repeat.PojoClass;
import com.ryan.luckywheel.Repeat.PreviousAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreviousActivity extends AppCompatActivity {
    ImageView back;
    PreviousAdapter adapter;
    List<PojoClass> pojoClasses = new ArrayList<>();
    ProgressDialog pDialog;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous);
        back=(ImageView)findViewById(R.id.back);
        list=(ListView)findViewById(R.id.list);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        populatedata();
    }

    public void populatedata(){

        pDialog = new ProgressDialog(PreviousActivity.this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        Map<String, String> postParam= new HashMap<String, String>();
        // postParam.put("session_id", sessionid);
        postParam.put("rest_id", "1");


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                "http://condoassist2u.com/casinofun/api/recentresult.php", new JSONObject(postParam),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject objone)
                    {
                        pDialog.dismiss();
                        Log.d("tag", objone.toString());
                        try {
                            // JSONObject objone = new JSONObject(response);
                            boolean error = objone.getBoolean("error");

                            if(error){

                            }else{

                              /*  {
                                    "0": "0",
                                        "1": "6",
                                        "2": "3",
                                        "3": "5",
                                        "4": "9",
                                        "5": "9",
                                        "6": "6",
                                        "7": "2",
                                        "8": "5",
                                        "lrid": "18",
                                        "date": "2018-06-22",
                                        "live_result": null,
                                        "created_at": "2018-06-22 23:50:23"
                                }*/

                                JSONArray jsonArray = objone.getJSONArray("recent");
                                for (int i = 0; i < jsonArray.length(); i++) {

                                    JSONObject obj = jsonArray.getJSONObject(i);
                                    PojoClass movie = new PojoClass();
                                    movie.setZero(obj.getString("0"));
                                    movie.setOne(obj.getString("1"));
                                    movie.setTwo(obj.getString("2"));
                                    movie.setThree(obj.getString("3"));
                                    movie.setFour(obj.getString("4"));
                                    movie.setFive(obj.getString("5"));
                                    movie.setSix(obj.getString("6"));
                                    movie.setSeven(obj.getString("7"));
                                    movie.setEight(obj.getString("8"));
                                    movie.setDateData(obj.getString("date"));
                                    Log.d("eight", obj.getString("8"));
                                    Log.d("eeeeeee", obj.getString("date"));
                                    pojoClasses.add(movie);

                                }
                                adapter = new PreviousAdapter(PreviousActivity.this,pojoClasses);
                                list.setAdapter(adapter);
                                adapter.notifyDataSetChanged();
                            }

                            //  adapter.notifyDataSetChanged();

                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                pDialog.dismiss();
                VolleyLog.d("tag", "Error: " + error.getMessage());
                //  hideProgressDialog();
            }
        }) {

            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }

        };

        jsonObjReq.setTag("tag");
        // Adding request to request queue
        RequestQueue queue = Volley.newRequestQueue(PreviousActivity.this);
        queue.add(jsonObjReq);

    }
}
