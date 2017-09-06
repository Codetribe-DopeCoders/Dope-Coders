package com.example.codetribe.palliate;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by codetribe on 9/1/2017.
 */

public class SupportAdapter extends ArrayAdapter<SupportClass> {


    public SupportAdapter(Activity context, ArrayList<SupportClass> supportContent) {

        super(context, 0, supportContent);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.support_list_item, parent, false);
        }
        SupportClass currentWord = getItem(position);

        TextView supportName = (TextView) listItemView.findViewById(R.id.support_name);
        supportName.setText(currentWord.getmName());

        TextView supportLocation = (TextView) listItemView.findViewById(R.id.support_location);
        supportLocation.setText(currentWord.getmLocation());

        TextView supportOccupation = (TextView) listItemView.findViewById(R.id.support_occupation);
        supportOccupation.setText(currentWord.getmOccupation());

        TextView supportContacts = (TextView) listItemView.findViewById(R.id.support_contacts);
        supportContacts.setText(currentWord.getmContacts());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_display);
        imageView.setImageResource(currentWord.getPhoto());

        return listItemView;
    }

}


