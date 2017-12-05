package com.example.codetribe.palliate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class SocialWork extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<SocialClass> peoplesNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_work);


        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        peoplesNames = new ArrayList<>();

        initViews();
    }

    public void initViews() {

        peoplesNames.add(new SocialClass("social worker name", "social worker occupation", "social worker location", R.drawable.palliate_logo, "view more"));
        peoplesNames.add(new SocialClass("social worker name", "social worker occupation", "social worker location", R.drawable.palliate_logo, "view more"));
        peoplesNames.add(new SocialClass("social worker name", "social worker occupation", "social worker location", R.drawable.palliate_logo, "view more"));
        peoplesNames.add(new SocialClass("social worker name", "social worker occupation", "social worker location", R.drawable.palliate_logo, "view more"));
        peoplesNames.add(new SocialClass("social worker name", "social worker occupation", "social worker location", R.drawable.palliate_logo, "view more"));
        peoplesNames.add(new SocialClass("social worker name", "social worker occupation", "social worker location", R.drawable.palliate_logo, "view more"));
        peoplesNames.add(new SocialClass("social worker name", "social worker occupation", "social worker location", R.drawable.palliate_logo, "view more"));

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
