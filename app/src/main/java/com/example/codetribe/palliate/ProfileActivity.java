package com.example.codetribe.palliate;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editName;
    private EditText editEmailAddress;
    private EditText editContact;
    private EditText editPassword;
    private EditText editNextOfKin1;
    private EditText editNextOfKin2;
    private Button buttonSubmit;
    private ProgressDialog progressDialog;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        progressDialog = new ProgressDialog(this);
        firebaseDatabase = FirebaseDatabase.getInstance();


        databaseReference = firebaseDatabase.getReference().child("User");


        editName = (EditText) findViewById(R.id.register_name);
        editEmailAddress = (EditText) findViewById(R.id.register_email);
        editContact = (EditText) findViewById(R.id.register_contact);
        editPassword = (EditText) findViewById(R.id.register_password);
        editNextOfKin1 = (EditText) findViewById(R.id.nexofkin_contact1);
        editNextOfKin2 = (EditText) findViewById(R.id.nexofkin_contact2);
        buttonSubmit = (Button) findViewById(R.id.submit);

        buttonSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        String name = editName.getText().toString();
        final String email = editEmailAddress.getText().toString();
        String contact = editContact.getText().toString();
        String password = editPassword.getText().toString();
        String nextOfKin1 = editNextOfKin1.getText().toString();
        String nextOfNext2 = editNextOfKin2.getText().toString();

        if (TextUtils.isEmpty(name)) {

            Toast.makeText(getApplicationContext(), "please, enter your full name", Toast.LENGTH_SHORT).show();
            return;

        }

        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.matches(emailPattern)) {
            Toast.makeText(getApplicationContext(), "valid email address", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(contact)) {

            Toast.makeText(getApplicationContext(), "please, enter your contact number", Toast.LENGTH_SHORT).show();
            return;

        }

        if (TextUtils.isEmpty(nextOfKin1)) {

            Toast.makeText(getApplicationContext(), "please, enter your first next of kin contacts number", Toast.LENGTH_SHORT).show();
            return;

        }

        if (TextUtils.isEmpty(nextOfNext2)) {

            Toast.makeText(getApplicationContext(), "please, enter your second next of kin contacts number ", Toast.LENGTH_SHORT).show();
            return;

        }

        if (TextUtils.isEmpty(password)) {
            //password is empty
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
            //stopping the function execution
            return;
        }
        if (password.length() < 8) {

            Toast.makeText(getApplicationContext(), "password too short, please enter 8 characters", Toast.LENGTH_SHORT).show();

            return;
        }


        if (view == buttonSubmit) {

            // (String firstName, String lastName, String emailAddress, String location, String identity, String gender, String password, String confirmPassword
            UserDetails userDetails = new UserDetails(name, email, contact, password, nextOfKin1, nextOfNext2);
            databaseReference.setValue(userDetails);

            startActivity(new Intent(getApplicationContext(), MainActivity.class));

            Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();


            progressDialog.dismiss();
        }


    }
}
