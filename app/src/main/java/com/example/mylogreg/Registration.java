package com.example.mylogreg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Registration extends AppCompatActivity {
    EditText username,password,email,phone;
    Button signup;
    TextView signin;
    FirebaseAuth firebaseAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        firebaseAuth=FirebaseAuth.getInstance();

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
                String uname1=username.getText().toString().trim();
                String uemail1=email.getText().toString().trim();
                String upass1=password.getText().toString().trim();


                if (TextUtils.isEmpty(uemail1)){
                    email.setError("Recquired Field...");
                    return;
                }
                if (TextUtils.isEmpty(upass1)){
                    password.setError("Recquired Field");
                    return;

                }

                firebaseAuth.createUserWithEmailAndPassword(uemail1,upass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(),Users.class));
                            Toast.makeText(getApplicationContext(),"Successfull",Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();                        }
                    }
                });



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
