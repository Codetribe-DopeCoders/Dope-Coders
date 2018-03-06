package com.example.codetribe.palliate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RehabilitationCentres extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<SocialClass> peoplesNames;
    TextView rehabilitationName;
    CircleImageView rehabilitationPic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_work);

        rehabilitationName = (TextView) findViewById(R.id.user_name);
        rehabilitationPic = (CircleImageView) findViewById(R.id.userpic);


        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        peoplesNames = new ArrayList<>();

        initViews();
    }

    public void initViews() {

        peoplesNames.add(new SocialClass("Jabulani Rehab", "Drug Abuse", "Johannesburg", R.drawable.jabulani, "view more","Welcome to CHANGES Treatment Centre known as the best drug rehab center in Johannesburg! beautifully situated in the Northcliff area, North of Gauteng. We are proud to deliver the very best Premier Residential Inpatient, Outpatient, Luxurious Halfway House addiction and substance abuse treatment programs as well as the only long-term drug and alcohol rehab on a farm in Johannesburg.\n" +
                "\n" +
                "We offer personalized care aimed at achieving lasting recovery and sobriety, we provide clear boundaries, love and encouragement and we will guide you on your journey to recovery! Our core focus is ensuring that the person affected receives the best help possible and that the family and love-ones receive guidance during the recovery process. At CHANGES you will find a team of professional experts. Medical Doctors, Clinicians, Counsellors and other trusted professionals. These experts form an extended family for the recovering addicts as they make their way through the rehabilitation process. We understand addiction as well as the consequences and effects that result from this destructive disease. We help our clients build up life skills and we assist them with re-integrating back into society.","0728951364","mmary1477@gmail.com"));
        peoplesNames.add(new SocialClass("support centre name", "support centre occupation", "support centre location", R.drawable.palliate_logo, "view more","bla bla","0728951364","mmary1477@gmail.com"));
        peoplesNames.add(new SocialClass("support centre name", "support centre occupation", "support centre location", R.drawable.palliate_logo, "view more","bla bla","0728951364","mmary1477@gmail.com"));
        peoplesNames.add(new SocialClass("support centre name", "support centre occupation", "support centre location", R.drawable.palliate_logo, "view more","bla bla","0728951364","mmary1477@gmail.com"));

        //Set lists of items to the adapter
        RecyclerView.Adapter adapter = new SocialAdapter(peoplesNames);
        recyclerView.setAdapter(adapter);

        //Handles clicks in Recycler view items
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            //We use gesture detector to detect whether is it a single tap
            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });

            //this methods handle clicks on each item
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && gestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(child);
                    // Toast.makeText(getApplicationContext(), peoplesNames.get(position).getName()+ "  " + peoplesNames.get(position).getOccupation(), Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

    }
}
