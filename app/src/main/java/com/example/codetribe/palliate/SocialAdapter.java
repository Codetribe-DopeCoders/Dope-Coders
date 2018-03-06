package com.example.codetribe.palliate;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by codetribe on 10/4/2017.
 */

public class SocialAdapter extends RecyclerView.Adapter<SocialAdapter.ViewHolder> {

    private static int currentPosition = 0;
    private ArrayList<SocialClass> socialclass;
    // private Context context;
    private Context context;
    String name1;
    TextView socialworkerName;
    CircleImageView socialworkerPic;

    public SocialAdapter(ArrayList<SocialClass> socialclass) {

        this.socialclass = socialclass;
        //this.context = context;
    }


    @Override
    public SocialAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context = parent.getContext();
        View recycleviewitem = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(recycleviewitem);
    }

    @Override
    public void onBindViewHolder(SocialAdapter.ViewHolder viewholder, final int position) {

        viewholder.name.setText(socialclass.get(position).getName());
        viewholder.occupation.setText(socialclass.get(position).getOccupation());
        viewholder.location.setText(socialclass.get(position).getLocation());
        viewholder.profileImage.setImageResource(socialclass.get(position).getImg_id());
        viewholder.viewMore.setText(socialclass.get(position).getMoreDetails());

        viewholder.viewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog);
                // Custom Android Allert Dialog Title
                dialog.setTitle("Custom Dialog Example");

                Button map = (Button) dialog.findViewById(R.id.map);
                Button email = (Button) dialog.findViewById(R.id.emails);
                Button call = (Button) dialog.findViewById(R.id.call);
                Button info = (Button) dialog.findViewById(R.id.star);
                // Click cancel to dismiss android custom dialog box

                socialworkerName = (TextView) dialog.findViewById(R.id.user_name);
                socialworkerPic = (CircleImageView) dialog.findViewById(R.id.userpic);

                socialworkerName.setText(socialclass.get(position).getName());
                socialworkerPic.setImageResource(socialclass.get(position).getImg_id());


                map.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });


                email.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //dialog.dismiss();
                        Intent emailIntent = new Intent(Intent.ACTION_SEND);
                        emailIntent.setType("*/*");
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, "mmary1477@gmail.com");
                        // intent.putExtra(Intent.EXTRA_SUBJECT, "coffee order for : "+ userName );
                        // intent.putExtra(Intent.EXTRA_TEXT, name );

                    }
                });

                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent callingIntent = new Intent(Intent.ACTION_DIAL);
                        callingIntent.setData(Uri.parse("tel:"+socialclass.get(position).getPhoneNumber()));
                        context.startActivity(callingIntent);
                    }
                });

                // Your android custom dialog ok action
                // Action for custom dialog ok button click
                info.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent inf = new Intent(context, socialWorkerInfo.class);
                        inf.putExtra("information",socialclass.get(position).getInfoDetails());
                        context.startActivity(inf);
                    }
                });

                dialog.show();
            }

        });

    }

    @Override
    public int getItemCount() {

        return socialclass.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        private TextView name;
        private TextView occupation;
        private TextView location;
        private CircleImageView profileImage;
        private TextView viewMore;

        public ViewHolder(View view) {

            super(view);

            name = (TextView) view.findViewById(R.id.name);
            occupation = (TextView) view.findViewById(R.id.occupation);
            location = (TextView) view.findViewById(R.id.location);
            profileImage = (CircleImageView) view.findViewById(R.id.image_view);
            viewMore = (TextView) view.findViewById(R.id.more);
            // linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);


        }
    }
}

