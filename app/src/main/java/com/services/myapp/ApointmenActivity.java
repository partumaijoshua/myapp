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

public class ApointmenActivity extends AppCompatActivity {
    EditText Name,ID,Phone,Reason,Group,Single;
    Button submit,view;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apointmen);
        submit = findViewById(R.id.btnsub);
        Name = findViewById(R.id.btntext8);
        ID = findViewById(R.id.btndetails2);
        Reason = findViewById(R.id.btndetails3);
        Phone = findViewById(R.id.btndetails3);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Submiting...");
        dialog.setCancelable(false);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jin = Name.getText().toString();
                String kita = ID.getText().toString();
                String sim = Phone.getText().toString();
                String sababu = Reason.getText().toString();
                if (jin.isEmpty() || kita.isEmpty() || sim.isEmpty()||sababu.isEmpty()) {
                    Toast.makeText(ApointmenActivity.this, "", Toast.LENGTH_SHORT).show();
                } else {

                    long time = System.currentTimeMillis();
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Details/" + time);
                    Tem y = new Tem(jin, kita, sim, sababu,String.valueOf(time));
                    dialog.show();
                    ref.setValue(y).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            dialog.dismiss();
                            if (task.isSuccessful()){
                            Toast.makeText(ApointmenActivity.this, "Submited...", Toast.LENGTH_SHORT).show();
                            Name.setText("");
                            ID.setText("");
                            Phone.setText("");
                            Reason.setText("");

                        }else{
                            Toast.makeText(ApointmenActivity.this, "Submit Failed", Toast.LENGTH_SHORT).show();
                        }

                        }
                });
            }
        }
    });

}
}
