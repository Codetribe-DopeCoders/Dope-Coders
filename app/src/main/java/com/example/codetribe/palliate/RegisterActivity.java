package com.example.codetribe.palliate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    // variables declaration
    private EditText registerName;
    private EditText registerEmail;
    private EditText registerPassword;
    private EditText contactNumber;
    private EditText socialNumber;
    private EditText levelOneContacOne;
    private EditText levelTwoContactTwo;
    private EditText leve2OneContacOne;
    private Button createAnAccount;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    //private Database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //variables instantiation

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
//        if (firebaseAuth.getCurrentUser() == null){
//
//            finish();
//            startActivity(new Intent(getApplicationContext(),MainActivity.class));
//        }

        databaseReference = firebaseDatabase.getReference().child("User");

        //user details
        registerName = (EditText) findViewById(R.id.register_name);
        registerEmail = (EditText) findViewById(R.id.register_email);
        registerPassword = (EditText) findViewById(R.id.register_password);
        contactNumber = (EditText) findViewById(R.id.register_contact);
        socialNumber = (EditText) findViewById(R.id.register_social_worker);
        levelOneContacOne = (EditText) findViewById(R.id.register_contact1);
        levelTwoContactTwo = (EditText) findViewById(R.id.register_contact2);
        leve2OneContacOne = (EditText) findViewById(R.id.register_contact1cpf);


        //clickable button
        createAnAccount = (Button) findViewById(R.id.create_an_account);

        createAnAccount.setOnClickListener(this);

    }

    public void RegisterUser() {

        String userNamE = registerName.getText().toString().trim();

        //email validation

        final String email = registerEmail.getEditableText().toString().trim();
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        registerEmail.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (email.matches(emailPattern) && s.length() > 0) {
                    // Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // other stuffs
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // other stuffs
            }
        });


        String password = registerPassword.getText().toString().trim();
        String userNumber = contactNumber.getText().toString().trim();
        String socialContacts = socialNumber.getText().toString().trim();
        String contact1level = levelOneContacOne.getText().toString().trim();
        String contact2level = levelTwoContactTwo.getText().toString().trim();
        String contact1levelcpf = leve2OneContacOne.getText().toString().trim();

        // validate user input

        if (TextUtils.isEmpty(userNamE)) {

            Toast.makeText(getApplicationContext(), "please, enter your name", Toast.LENGTH_LONG).show();
            return;

        }

        if (TextUtils.isEmpty(email)) {

            Toast.makeText(getApplicationContext(), "please, enter your email", Toast.LENGTH_LONG).show();
            return;

        }

        if (TextUtils.isEmpty(password)) {

            Toast.makeText(getApplicationContext(), "please, enter password", Toast.LENGTH_SHORT).show();

            return;
        }
        if (password.length() < 8) {

            Toast.makeText(getApplicationContext(), "password too short, please enter 8 characters", Toast.LENGTH_SHORT).show();

            return;
        }


        if (TextUtils.isEmpty(userNumber)) {

            Toast.makeText(getApplicationContext(), "please, enter your number", Toast.LENGTH_LONG).show();
            return;

        }
        if (TextUtils.isEmpty(socialContacts)) {

            Toast.makeText(getApplicationContext(), "please, enter social wo number", Toast.LENGTH_LONG).show();
            return;

        }
        if (TextUtils.isEmpty(contact1level)) {

            Toast.makeText(getApplicationContext(), "please, enter contact one in next of kin", Toast.LENGTH_LONG).show();
            return;

        }

        if (TextUtils.isEmpty(contact2level)) {

            Toast.makeText(getApplicationContext(), "please, enter contact two in next of kin", Toast.LENGTH_LONG).show();
            return;

        }

        if (TextUtils.isEmpty(contact1levelcpf)) {

            Toast.makeText(getApplicationContext(), "please, enter contact one in cpf numbers", Toast.LENGTH_LONG).show();
            return;

        }


        //create user account
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    finish();

                    //users details

                    String userNamE = registerName.getText().toString().trim();
                    String email = registerEmail.getText().toString().trim();
                    String password = registerPassword.getText().toString().trim();
                    String userNumber = contactNumber.getText().toString().trim();
                    String socialContacts = socialNumber.getText().toString().trim();
                    String contact1level = levelOneContacOne.getText().toString().trim();
                    String contact2level = levelTwoContactTwo.getText().toString().trim();
                    String contact1levelcpf = leve2OneContacOne.getText().toString().trim();


                    String id = task.getResult().getUser().getUid();

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                    Toast.makeText(getApplicationContext(), "registered successfully", Toast.LENGTH_SHORT).show();

                    databaseReference = databaseReference.getRef().child("User");
                    UserDetails userDetails = new UserDetails(userNamE, email, password, userNumber, socialContacts, contact1level, contact2level, contact1levelcpf);
                    databaseReference.child(id).setValue(userDetails);
                } else {
                    Toast.makeText(getApplicationContext(), "failed to register user, please register again", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view == createAnAccount) {
            RegisterUser();
        }
    }
}
