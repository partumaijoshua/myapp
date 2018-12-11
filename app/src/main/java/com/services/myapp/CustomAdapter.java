package com.services.myapp;


//CustomAdapter
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Tem> details;//modify here

    public CustomAdapter(Context mContext, ArrayList<Tem> details) {
        this.mContext = mContext;
        this.details = details;
    }

    @Override
    public int getCount() {
        return details.size();// # of items in your arraylist
    }
    @Override
    public Object getItem(int position) {
        return details.get(position);// get the actual item
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
            convertView = inflater.inflate(R.layout.activity_details, parent,false);//modify here
            viewHolder = new ViewHolder();
            //modify this block of code
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.btntext8);
            viewHolder.tvID = (TextView) convertView.findViewById(R.id.btndetails1);
            viewHolder.tvPhone = (TextView) convertView.findViewById(R.id.btndetails2);
            viewHolder.tvReason = (TextView) convertView.findViewById(R.id.btndetails3);
            viewHolder.Decline = convertView.findViewById(R.id.btndecline);
            viewHolder.Approve = convertView.findViewById(R.id.btnapprove);
            //Up to here
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //MODIFY THIS BLOCK OF CODE
        final Tem person = details.get(position);//modify here
        viewHolder.tvName.setText(person.getName());//modify here
        viewHolder.tvID.setText(person.getID());//modify here
        viewHolder.tvPhone.setText(person.getPhone());//modify here
        viewHolder.tvReason.setText(person.getReason());//modify here
        viewHolder.Decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Details/"+person.getKey());
                if (reference.removeValue().isSuccessful()){
                    Toast.makeText(mContext, "Decline Approved", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(mContext, "Decline Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        viewHolder.Approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long time = System.currentTimeMillis();
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Approved/"+time);
                Tem x= new Tem(person.getName(),person.getID(),person.getReason(),person.getPhone(),person.getKey());
                reference.setValue(x).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(mContext, "Appointment Approved", Toast.LENGTH_SHORT).show();
                            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Details/"+person.getKey());
                            reference.removeValue();
                        }else {
                            Toast.makeText(mContext, "Approval Declined", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        return convertView;

    }
    static class ViewHolder {
        TextView tvName;
        TextView tvID;
        TextView tvPhone;
        TextView tvReason;
        Button Decline;
        Button Approve;

    }

}