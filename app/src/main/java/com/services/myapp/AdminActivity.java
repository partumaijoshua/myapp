package com.services.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {
    Button appointment,fraud,tenders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        appointment = findViewById(R.id.btn2);
        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this,ViewappointmentsActivity.class);
                startActivity(intent);
            }
        });

        fraud = findViewById(R.id.btn5);
        fraud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this,viewFraudreports.class);
                startActivity(intent);
            }
        });
        tenders = findViewById(R.id.btntender);
        tenders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this,ViewTenders.class);
                startActivity(intent);
            }
        });

    }
}
