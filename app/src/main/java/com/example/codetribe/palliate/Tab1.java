package com.example.codetribe.palliate;

/**
 * Created by CodeTribe on 11/20/2017.
 */
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Tab1 extends android.support.v4.app.Fragment {

    Context context;
    TextView description;
    TextView section_label;
    ImageView image;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pager, container, false);
        //topic
        section_label = rootView.findViewById(R.id.section_label);
        section_label.setText(R.string.topic_one);

        //image
        image = rootView.findViewById(R.id.image_topic);
        image.setImageResource(R.drawable.palliate_logo);

        // description
        description = rootView.findViewById(R.id.description);
        description.setText(R.string.one_description);

        return rootView;
    }

}

