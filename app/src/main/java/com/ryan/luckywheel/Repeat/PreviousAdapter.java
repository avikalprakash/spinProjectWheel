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
        TextView detailtxt, detailtxt1, detailtxt2;
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


            convertView.setTag(holder);
        }
        else {

            holder = (ViewHolder) convertView.getTag();
        }


        PojoClass m = movieItems.get(position);
        Log.d("kbbobo",""+movieItems.size());


       // id = m.getItemid();
      //  Log.d("rj123ww",id);
        holder.detailtxt.setText("12:00 pm : "+m.getZero()+", "+"1:00 pm : "+m.getOne()+", "+"2:00 pm : "+
                m.getTwo());
        holder.detailtxt1.setText("3:00 pm : "+m.getThree()+", "
                +"4:00 pm : "+m.getFour()+", "+"5:00 pm : "+m.getFive());
        holder.detailtxt2.setText("6:00 pm : "+m.getSix()+", "
                +"7:00 pm : "+m.getSeven()+", "+"8:00 pm : "+m.getEight());


        return convertView;
    }


}
