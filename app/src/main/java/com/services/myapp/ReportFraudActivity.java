package com.services.myapp;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReportFraudActivity extends AppCompatActivity {
    EditText Name1, Phone2, ki, Aina;
    Button submit, view;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_fraud);

        submit = findViewById(R.id.btnsub5);
        Name1 = findViewById(R.id.btnfraud1);
        ki = findViewById(R.id.btnfraud3);
        Aina = findViewById(R.id.btnfraud4);
        Phone2 = findViewById(R.id.btnfraud2);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Submiting...");
        dialog.setCancelable(false);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jinai = Name1.getText().toString();
                String kitai = ki.getText().toString();
                String simi = Phone2.getText().toString();
                String aina = Aina.getText().toString();
                if (jinai.isEmpty() || kitai.isEmpty() || simi.isEmpty() || aina.isEmpty()) {
                    Toast.makeText(ReportFraudActivity.this, "", Toast.LENGTH_SHORT).show();
                } else {

                    long time = System.currentTimeMillis();
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("WATU/" + time);
                    item2 y = new item2(jinai, kitai, simi, aina);
                    dialog.show();
                    ref.setValue(y).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            dialog.dismiss();
                            if (task.isSuccessful()) {
                                Toast.makeText(ReportFraudActivity.this, "", Toast.LENGTH_SHORT).show();
                                Name1.setText("");
                                ki.setText("");
                                Phone2.setText("");
                                Aina.setText("");

                            } else {
                                Toast.makeText(ReportFraudActivity.this, "", Toast.LENGTH_SHORT).show();

                            }
                        }

                    });
                }
            }

        });
    }
}











