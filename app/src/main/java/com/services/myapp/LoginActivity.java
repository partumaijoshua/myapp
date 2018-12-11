package com.services.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText Name;
    private  EditText password;
    private  Button Login;
    private  TextView Info;
    private  int counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText)findViewById(R.id.btnfraud2);
        password = (EditText)findViewById(R.id.btnpass);
        Login= (Button) findViewById(R.id.btnlog);
        Info = (TextView) findViewById(R.id.tvInfo);

        Info.setText("No of trials remaing is 5.");

        Login .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),password.getText().toString());
            }
        });

    }
    private  void validate (String Username,String UserPassword){
        if (Username.equals("Holiness") && UserPassword.equals("123456")){
            Intent intent = new Intent(LoginActivity.this,AdminActivity.class);
            startActivity(intent);

        } else {
            counter--;
            Info.setText("No of trials remaing is:" +(counter));

            if (counter==0){
                Login.setEnabled(false);

            }


        }
    }
}
