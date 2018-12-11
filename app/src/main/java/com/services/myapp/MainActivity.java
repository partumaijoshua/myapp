package com.services.myapp;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {
    EditText Email,Date,Phone,Constituency,kitambulisho,Jina;
    Button save,view,proceed,Admin;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        proceed = findViewById(R.id.btnnext);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ServicesActivity.class);
                startActivity(intent);

            }
        });
        Admin = findViewById(R.id.btn6);
        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

        Email = findViewById(R.id.tvmail);
        Date = findViewById(R.id.tvname);
        Phone = findViewById(R.id.btnnum);
        Constituency = findViewById(R.id.btnconst);
        kitambulisho = findViewById(R.id.btnnumber);
        Jina = findViewById(R.id.tvphone);
        save= findViewById(R.id.btnsave);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Saving...");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Arafa = Email.getText().toString();
                String Tarehe = Date.getText().toString();
                String Simu = Phone.getText().toString();
                String Jiji = Constituency.getText().toString();
                String Miaka = kitambulisho.getText().toString();
                String Jinaa = Jina.getText().toString();
                if (Arafa.isEmpty()||Simu.isEmpty()||Jiji.isEmpty()||Miaka.isEmpty()||Jinaa.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please fill All inputs", Toast.LENGTH_SHORT).show();
                } else{
                    long time = System.currentTimeMillis();
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("DATA/" + time);
                    Item x = new Item(Jinaa,Simu,Tarehe,Jiji,Miaka,Arafa);
                    dialog.show();
                    ref.setValue(x).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            dialog.dismiss();
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Saved successfully", Toast.LENGTH_SHORT).show();
                                Email.setText("");
                                Date.setText("");
                                Phone.setText("");
                                Constituency.setText("");
                                kitambulisho.setText("");
                                Jina.setText("");
                            } else {
                                Toast.makeText(MainActivity.this, "Saving failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                    }

            }
        });

    }
}
