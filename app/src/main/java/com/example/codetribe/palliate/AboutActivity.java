package com.example.codetribe.palliate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

    }


    public void FAQ(View view) {
        startActivity(new Intent(this, FaqActivity.class));

    }

    public void Contact(View view) {
        startActivity(new Intent(this, Contact.class));

    }

    public void App(View view) {
        startActivity(new Intent(this, AppActivity.class));



    }
}
