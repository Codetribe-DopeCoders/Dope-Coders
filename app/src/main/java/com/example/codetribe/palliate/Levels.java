package com.example.codetribe.palliate;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Levels extends AppCompatActivity {
    Button magicButton, magicButton1, magicButton2;
    private String PhoneNum = "0762701174";

    DatabaseReference mDatabaseReference;

    String num1;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        magicButton  = (Button) findViewById(R.id.magic_button);
        magicButton1 = (Button) findViewById(R.id.magic_button1);
        magicButton2 = (Button) findViewById(R.id.magic_button2);


        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();


        final String uid = user.getUid();


        // Toast.makeText(getApplicationContext(), "uid " + uid,Toast.LENGTH_LONG).show();
        //  Log.d("UID", uid);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference("User").child("User");

        mDatabaseReference.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                num1 = (String) dataSnapshot.child("mSocialNumber").getValue();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                databaseError.getMessage();
            }
        });
/*
        magicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  String phoneNumber = "0820658463";
                String phoneNumber1 = "0795656382";
                Location currentLocation ;
               sendLocationSMS(phoneNumber,phoneNumber1,currentLocation);*/

     /*           Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + Uri.encode(num1.trim())));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(callIntent);
            }
        });
*/
        magicButton.setOnClickListener(new View.OnClickListener() {
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
