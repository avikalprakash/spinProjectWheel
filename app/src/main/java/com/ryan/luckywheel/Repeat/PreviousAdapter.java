package com.ryan.luckywheel.Repeat;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ryan.luckywheel.R;

import java.util.List;

/**
 * Created by lue on 27-11-2017.
 */

public class PreviousAdapter extends BaseAdapter {
    private Context activity;
    private LayoutInflater inflater;
    private List<PojoClass> movieItems;

    String id ;


    public PreviousAdapter(Context context, List<PojoClass> movie) {

        this.activity = context;
        this.movieItems = movie;

    }


    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    static class ViewHolder {

        ImageView mgridimage;
        TextView detailtxt, detailtxt1, detailtxt2, detailtxt3, detailtxt4, detailtxt5,
                detailtxt6, detailtxt7, detailtxt8, dateText;
        TextView price;
        TextView calrtxt;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            convertView = inflater.inflate(R.layout.menusubitemlayout, null);
            holder = new ViewHolder();

            holder.detailtxt = (TextView) convertView.findViewById(R.id.griddetail_text);
            holder.detailtxt1 = (TextView) convertView.findViewById(R.id.griddetail_text2);
            holder.detailtxt2 = (TextView) convertView.findViewById(R.id.griddetail_text3);
            holder.detailtxt3 = (TextView) convertView.findViewById(R.id.griddetail_text4);
            holder.detailtxt4 = (TextView) convertView.findViewById(R.id.griddetail_text5);
            holder.detailtxt5 = (TextView) convertView.findViewById(R.id.griddetail_text6);
            holder.detailtxt6 = (TextView) convertView.findViewById(R.id.griddetail_text7);
            holder.detailtxt7 = (TextView) convertView.findViewById(R.id.griddetail_text8);
            holder.detailtxt8 = (TextView) convertView.findViewById(R.id.griddetail_text9);
            holder.dateText=(TextView)convertView.findViewById(R.id.dateItem);



            convertView.setTag(holder);
        }
        else {

            holder = (ViewHolder) convertView.getTag();
        }


        PojoClass m = movieItems.get(position);
        Log.d("kbbobo",""+movieItems.size());


       // id = m.getItemid();
      //  Log.d("rj123ww",id);
        holder.detailtxt.setText("12:00 pm    :    "+m.getZero());
        holder.detailtxt1.setText("1:00 pm    :    "+m.getOne());
        holder.detailtxt2.setText("2:00 pm    :    "+m.getTwo());
        holder.detailtxt3.setText("3:00 pm    :    "+m.getThree());
        holder.detailtxt4.setText("4:00 pm    :    "+m.getFour());
        holder.detailtxt5.setText("5:00 pm    :    "+m.getFive());
        holder.detailtxt6.setText("6:00 pm    :    "+m.getSix());
        holder.detailtxt7.setText("7:00 pm    :    "+m.getSeven());
        holder.detailtxt8.setText("8:00 pm    :    "+m.getEight());
          holder.dateText.setText("Date       :    "+m.getDateData());

        return convertView;
    }


}
