package com.services.myapp;


//CustomAdapter
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdpterFraud extends BaseAdapter {
    Context mContext;
    ArrayList<item2> watu;//modify here

    public CustomAdpterFraud(Context mContext, ArrayList<item2> watu) {
        this.mContext = mContext;
        this.watu = watu;
    }

    @Override
    public int getCount() {
        return watu.size();// # of items in your arraylist
    }
    @Override
    public Object getItem(int position) {
        return watu.get(position);// get the actual item
    }
    @Override
    public long getItemId(int id) {
        return id;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.activity_report_fraud, parent,false);//modify here
            viewHolder = new ViewHolder();
            //modify this block of code
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.btnfraud1);
            viewHolder.tvID = (TextView) convertView.findViewById(R.id.btnfraud2);
            viewHolder.tvPhone = (TextView) convertView.findViewById(R.id.btnfraud3);
            viewHolder.tvReason = (TextView) convertView.findViewById(R.id.btnfraud4);
            //Up to here
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //MODIFY THIS BLOCK OF CODE
        item2 person = watu.get(position);//modify here
        viewHolder.tvName.setText(person.getName1());//modify here
        viewHolder.tvID.setText(person.getKi());//modify here
        viewHolder.tvPhone.setText(person.getPhone2());//modify here
        viewHolder.tvReason.setText(person.getAina());//modify here
        return convertView;

    }
    static class ViewHolder {
        TextView tvName;
        TextView tvID;
        TextView tvPhone;
        TextView tvReason;

    }

}
