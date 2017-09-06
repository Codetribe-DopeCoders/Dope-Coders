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
public class SocialWorker extends Fragment {
    SupportAdapter Adapter;


    public SocialWorker() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.support_list, container, false);

        final ArrayList<SupportClass> supportContent = new ArrayList<SupportClass>();

        supportContent.add(new SupportClass(R.drawable.ic_menu_account, "Dineo Mafa", "Lotus Gardens", "Family Therapy", "+27 82 755 5096"));
        supportContent.add(new SupportClass(R.drawable.ic_menu_account, "Dorision Ngoepe", "Johannesburg", "Psychologist", "+27 76 270 1174"));
        supportContent.add(new SupportClass(R.drawable.ic_menu_account, "Dikeledi Makofane", "Pretoria 012", "Couples Counsellor", "+27 79 300 9406"));
        supportContent.add(new SupportClass(R.drawable.ic_menu_account, "Sibusiso Jiyane", "Soshanguve", "Rape Counsellor ", "+27 72 895 1364"));
        supportContent.add(new SupportClass(R.drawable.ic_menu_account, "Tercy Mathebula", "Polokwane", "Drug Counsellor", "+27 82 065 8534"));

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






