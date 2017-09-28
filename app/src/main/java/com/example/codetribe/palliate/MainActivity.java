package com.example.codetribe.palliate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonRegister;
    private Button buttonLogin;
    private Button buttonReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            //profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        }

        editTextEmail = (EditText) findViewById(R.id.login_email);
        editTextPassword = (EditText) findViewById(R.id.login_passord);
        buttonRegister = (Button) findViewById(R.id.register1);
        buttonLogin = (Button) findViewById(R.id.login_btn);
        buttonReset = (Button) findViewById(R.id.reset_btn);

        buttonLogin.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);


    }


    public void UserLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            //enter an email address
            Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show();
            //stopping the function execution
            return;
        }
        if (TextUtils.isEmpty(password)) {
            //password is empty
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
            //stopping the function execution
            return;
        }


        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //start profile activity
                    finish();
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                }


            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == buttonLogin) {
            UserLogin();
        }

        if (v == buttonReset) {
            finish();
            startActivity(new Intent(this, ResetActivity.class));
        }
        if (v == buttonRegister) {
            finish();
            startActivity(new Intent(this, RegisterActivity.class));
        }

    }


}
