package com.example.codetribe.palliate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class socialWorkerInfo extends AppCompatActivity {

    TextView socialInfo;
    TextView rehabilitationInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_worker_info);

        socialInfo = (TextView) findViewById(R.id.txt_socialworker);
        Intent aboutSocial = getIntent();
        socialInfo.setText(aboutSocial.getStringExtra("information"));

        rehabilitationInfo = (TextView) findViewById(R.id.txt_socialworker);
        Intent aboutRehabilitation = getIntent();
        rehabilitationInfo.setText(aboutRehabilitation.getStringExtra("information"));


    }
}
