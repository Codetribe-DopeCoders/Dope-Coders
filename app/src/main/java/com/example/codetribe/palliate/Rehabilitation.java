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
public class Rehabilitation extends Fragment {

    SupportAdapter Adapter;


    public Rehabilitation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.support_list, container, false);

        final ArrayList<SupportClass> supportContent = new ArrayList<SupportClass>();

        supportContent.add(new SupportClass(R.drawable.ic_menu_account, "SHARP", "Johannesburg", "Addiction Treatment Centre", "0109003131"));
        supportContent.add(new SupportClass(R.drawable.ic_menu_account, "Door of Hope", "Polokwane", "Abuse Awareness", "0152471142"));
        supportContent.add(new SupportClass(R.drawable.ic_menu_account, "Tough Love", "Ethekwini", "Abused Women Support Group", "0138404399"));
        supportContent.add(new SupportClass(R.drawable.ic_menu_account, "SANCA", "Akasia", "Rehabilitation Centre ", "0125421151"));
        supportContent.add(new SupportClass(R.drawable.ic_menu_account, "Tears Foundation", "Cape Town", "Care Centre", "0434210111"));

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
