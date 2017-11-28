package com.example.codetribe.palliate;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
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

    ImageView magicButton3, magicButton1, magicButton2;
    String nextOfKinNo1,nextOfKinNo2;
//new
    FirebaseAuth firebaseAuth;
    //
    ChildEventListener mChildEvLiestiner;
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth.AuthStateListener mAuthListiner;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        magicButton3  = (ImageView) findViewById(R.id.magic_button3);
        magicButton2 = (ImageView) findViewById(R.id.magic_button2);
        magicButton1 = (ImageView) findViewById(R.id.magic_button1);

        firebaseAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("User");
        FirebaseUser user = firebaseAuth.getCurrentUser();
        //FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();

        userID = user.getUid();
        //final String uid = user.getUid();


        // Toast.makeText(getApplicationContext(), "uid " + uid,Toast.LENGTH_LONG).show();
        //  Log.d("UID", uid);

       // mDatabaseReference = FirebaseDatabase.getInstance().getReference("User");

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    UserDetails uDetails = new UserDetails();

                    uDetails.setmLevelOneContacOne(ds.child(userID).getValue(UserDetails.class).getmLevelOneContacOne());
                    uDetails.setmLevelTwoContactTwo(ds.child(userID).getValue(UserDetails.class).getmLevelTwoContactTwo());


                    nextOfKinNo1 = uDetails.getmLevelOneContacOne();
                    nextOfKinNo2 = uDetails.getmLevelTwoContactTwo();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                databaseError.getMessage();
            }
                });

        magicButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.putExtra("address", "0762701174;0793009406");
                i.putExtra("sms_body", "Hello, this is an emergency I need your help. please call me as soon as possible!");
                i.setType("vnd.android-dir/mms-sms");
                startActivity(i);
            }
        });
        magicButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.putExtra("address", "0762701174;0793009406");
                i.putExtra("sms_body", "Hello, this is an emergency I need your help. please call me as soon as possible!" +
                        "");
                i.setType("vnd.android-dir/mms-sms");
                startActivity(i);
            }
        });

        magicButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.putExtra("address", nextOfKinNo1+";"+nextOfKinNo2);
                i.putExtra("sms_body", "Hello, this is an emergency I need your help. please call me as soon as possible!" +
                        "");
                i.setType("vnd.android-dir/mms-sms");
                startActivity(i);
            }
        });
    }

    public void sendLocationSMS(String phoneNumber, String phoneNumber1, Location currentLocation) {
        SmsManager smsManager = SmsManager.getDefault();
        StringBuffer smsBody = new StringBuffer();
        smsBody.append("http://maps.google.com?q=");
        smsBody.append(currentLocation.getLatitude());
        smsBody.append(",");
        smsBody.append(currentLocation.getLongitude());
        smsManager.sendTextMessage(phoneNumber, phoneNumber1, smsBody.toString(), null, null);
    }
}
