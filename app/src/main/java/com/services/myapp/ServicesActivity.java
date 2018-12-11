package com.services.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServicesActivity extends AppCompatActivity {

    Button apoint,fraud,tender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        apoint = findViewById(R.id.btn2);
        apoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServicesActivity.this,ApointmenActivity.class);
                startActivity(intent);
            }
        });
        fraud = findViewById(R.id.btn5);
        fraud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServicesActivity.this,ReportFraudActivity.class);
                startActivity(intent);
            }
        });
        tender = findViewById(R.id.btn4);
        tender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServicesActivity.this,TenderDetails.class);
                startActivity(intent);
            }
        });
    }
}
