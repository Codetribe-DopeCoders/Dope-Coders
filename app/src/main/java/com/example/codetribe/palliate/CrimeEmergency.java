package com.example.codetribe.palliate;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeEmergency extends Fragment {

    SupportAdapter Adapter;

    public CrimeEmergency() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.support_list, container, false);

        final ArrayList<SupportClass> supportContent = new ArrayList<SupportClass>();

        supportContent.add(new SupportClass("Nationwide Emergency Response", "10111"));
        supportContent.add(new SupportClass("Cellphone Emergency", "112"));
        supportContent.add(new SupportClass("Ambulance Response", "10117"));
        supportContent.add(new SupportClass("Fire Rescue", "10177"));
        supportContent.add(new SupportClass("Childline", "0800055555"));

        Adapter = new SupportAdapter(getActivity(), supportContent);

        ListView listview = (ListView) view.findViewById(R.id.list_view_id);

        listview.setAdapter(Adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                SupportClass supportClass = supportContent.get(position);
                String num1 = supportClass.getmContacts();

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + Uri.encode(num1.trim())));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(callIntent);

            }
        });


        return view;
    }

}
