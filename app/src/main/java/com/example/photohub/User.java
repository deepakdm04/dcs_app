package com.example.photohub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;

public class User extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;

    private TextView banner,registerUser;
    private EditText editTextfullname, editTextage,editTextemail,editTextpassword;
    private Button register;
    private Calendar FirebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        banner = (TextView) findViewById(R.id.banner);
banner.setOnClickListener(this);

registerUser =(Button) findViewById(R.id.register);
registerUser.setOnClickListener(this);

        editTextfullname = (EditText) findViewById(R.id.fullname);
        editTextage = (EditText) findViewById(R.id.age);
        editTextemail = (EditText) findViewById(R.id.email);
        editTextpassword = (EditText) findViewById(R.id.password);

    }


    @Override
    public void onClick(View view) {
        Intent i = new Intent(User.this,Register.class);
        startActivity(i);
    }
    private void registerUser()
    {
        String email = editTextemail.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();
        String fullName = editTextfullname.getText().toString().trim();
        String age = editTextage.getText().toString().trim();

        if(fullName.isEmpty())
        {
            editTextfullname.setError("FULL NAME IS REQUIRED");
            editTextfullname.requestFocus();
            return;
        }
        if(age.isEmpty()) {
            editTextage.setError("AGE IS REQUIRED");
            editTextage.requestFocus();
            return;
        }
        if(email.isEmpty())
        {
            editTextemail.setError("EMAIL IS MANDATORY");
            editTextemail.requestFocus();
            return;
    }
       if (password.isEmpty())
       {
           editTextpassword.setError("PASSWORD IS REQUIRED!");
           editTextpassword.requestFocus();
       }
       if (password.length()<8) {
           editTextpassword.setError("MIN PASSWORD LENGTH SHOULD BE 8 CHARACTERS");
           editTextpassword.requestFocus();
           return;
       }

       mAuth.createUserWithEmailAndPassword(email,password);
       }
        }
