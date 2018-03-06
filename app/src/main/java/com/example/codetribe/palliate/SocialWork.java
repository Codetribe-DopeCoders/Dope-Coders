package com.example.codetribe.palliate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SocialWork extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<SocialClass> peoplesNames;
    TextView socialworkerName;
    CircleImageView socialworkerPic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_work);

        socialworkerName = (TextView) findViewById(R.id.user_name);
        socialworkerPic = (CircleImageView) findViewById(R.id.userpic);

        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        peoplesNames = new ArrayList<>();

        initViews();
    }

    public void initViews() {

        peoplesNames.add(new SocialClass("Sibusiso Jiyane", "Drug Abuse", "Pretoria", R.drawable.sibusiso, "view more","  I have been in practice as a social worker since 1983 and have worked in the mental health field (including addiction) for many of these.\n" +
                "\n" +
                "My approach to treating addiction is holistic and I believe that involving the family or other significant people is essential. My work is based on Carnes’ task-centered model of treatment which offers a flexible and comprehensive assessment and treatment strategy.\n" +
                "\n" +
                "My Master degree in social work focused on clinical approaches, specifically family therapy and this is an approach that I believe is very useful in working with addiction.\n" +
                "\n" +
                "I completed a PhD in social work (2014) and the research examined the issue of multiple addictions and addiction interaction disorder which seem to be neglected areas in addiction practice.", "0728951364","mmary1477@gmail.com"));

        peoplesNames.add(new SocialClass("Dineo Mafa", "Child Abuse", "Polokwane", R.drawable.palliate_logo, "view more"," I specialize in Addiction, anxiety disorder, bipolar disorder, career assessments, child sexual abuse, chronic medical conditions, depression, developmental disorders, eating disorders, family difficulties, fertility related issues, learning difficulties, life changes, loss/grief, organisational development, personality disorders, relationships, schizophrenia, self development, sexuality and gender, and trauma.\n" +
                "Working in: English, IsiZulu, Sesotho sa Leboa, Sesotho, and Setswana.","0785763759","mmary1477@gmail.com"));

        peoplesNames.add(new SocialClass("social worker name", "social worker occupation", "social worker location", R.drawable.palliate_logo, "view more","bla bla", "0812365478","mmary1477@gmail.com"));
        peoplesNames.add(new SocialClass("social worker name", "social worker occupation", "social worker location", R.drawable.palliate_logo, "view more","bla bla","0719852147","mmary1477@gmail.com"));

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
                 //Toast.makeText(getApplicationContext(), peoplesNames.get(position).getName()+ "  " + peoplesNames.get(position).getOccupation(), Toast.LENGTH_SHORT).show();

                   String name = peoplesNames.get(position).getName();
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
