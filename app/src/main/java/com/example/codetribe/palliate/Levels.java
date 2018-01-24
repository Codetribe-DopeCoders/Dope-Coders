package com.example.codetribe.palliate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Levels extends AppCompatActivity {

    ImageView socialWorker, counsellor, nextOfKin;
    String nextOfKin1, nextOfKin2;

    FirebaseAuth firebaseAuth;
    ChildEventListener mChildEvLiestiner;
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth.AuthStateListener mAuthListiner;
    private String userID;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        firebaseAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("User");
        firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        userID = firebaseUser.getUid();

        mDatabaseReference = mFirebaseDatabase.getReference().child("User").child(userID);
        socialWorker = (ImageView) findViewById(R.id.button1);
        counsellor = (ImageView) findViewById(R.id.button2);
        nextOfKin = (ImageView) findViewById(R.id.button3);

        mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

               UserDetails user = dataSnapshot.getValue(UserDetails.class);

               nextOfKin1 = user.getmLevelOneContacOne();
               nextOfKin2 = user.getmLevelTwoContactTwo();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        counsellor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        nextOfKin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.putExtra("address", nextOfKin1 + ";" + nextOfKin2);
                i.putExtra("sms_body", "Hello, this is an emergency I need your help. please call me as soon as possible!" +
                        "");
                i.setType("vnd.android-dir/mms-sms");
                startActivity(i);
            }
        });
    }

    public void SocialWorker(View view) {
        Intent intent = new Intent(this, SocialWork.class);
        startActivity(intent);

    }
}
