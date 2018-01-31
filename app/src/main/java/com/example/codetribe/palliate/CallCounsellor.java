package com.example.codetribe.palliate;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.net.Uri;
import android.widget.Toast;

public class CallCounsellor extends AppCompatActivity {

    GridView grid;
    String[] web = {"SAPS",
            "ChildLine",
            "LifeLine",
            "Social Development Substance Abuse Line",
            "Police and Trauma Line",
            "Suicide Crisis Line",
            "The South African Depression and Anxiety Group",
            "Cell phone emergency",
            "FAMSA – The Family and Marriage Association of South Africa",
            "Ambulance response"};

    int imageId[] = {R.drawable.ic_phone,
            R.drawable.ic_phone,
            R.drawable.ic_phone,
            R.drawable.ic_phone,
            R.drawable.ic_phone,
            R.drawable.ic_phone,
            R.drawable.ic_phone,
            R.drawable.ic_phone,
            R.drawable.ic_phone,
            R.drawable.ic_phone};

    String[] callInfo = { "10111",
            "08000555555",
            "0861322322",
            "0800567567",
            "0800205026",
            "0800567567",
            "0800121314",
            "112",
            "0119757106",
            "10117"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_counsellor);

        CustomGrid adapter = new CustomGrid(CallCounsellor.this, web, imageId, callInfo);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Toast.makeText(CallCounsellor.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+callInfo[position]));
                startActivity(callIntent);
            }
        });

    }

}
