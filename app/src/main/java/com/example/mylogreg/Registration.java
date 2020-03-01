package com.example.mylogreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registration extends AppCompatActivity {
    EditText username,password,email,phone;
    Button signup;
    TextView signin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username = (EditText) findViewById(R.id.uname1);
        email = (EditText)findViewById(R.id.uemail1);
        password = (EditText)findViewById(R.id.upass1);
        phone = (EditText)findViewById(R.id.uphone1);
        signup = (Button)findViewById(R.id.signup1);
        signin = (TextView)findViewById(R.id.signin1);

        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        signin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent l2 = new Intent(Registration.this,MainActivity.class);
                startActivity(l2);
            }
        });

    }
}
