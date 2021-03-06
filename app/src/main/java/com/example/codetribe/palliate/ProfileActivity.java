package com.example.codetribe.palliate;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int GALLERY_INTENT = 2;
    DatabaseReference databaseReference;
    UserDetails user;
    private EditText editName;
    private EditText editEmailAddress;
    private EditText editContact;
    private EditText editPassword;
    private EditText editNextOfKin1;
    private EditText editNextOfKin2;
    private Button buttonSubmit;
    private ProgressDialog progressDialog;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;
    private TextView displayName;
    //upload pic
    private FloatingActionButton uploadPic;
    private StorageReference storageReference;
    private CircleImageView userImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        progressDialog = new ProgressDialog(this);
        firebaseDatabase = FirebaseDatabase.getInstance();


        firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        String uid = firebaseUser.getUid();

        databaseReference = firebaseDatabase.getReference().child("User").child(uid);

        editName = (EditText) findViewById(R.id.register_name);
        editEmailAddress = (EditText) findViewById(R.id.register_email);
        editContact = (EditText) findViewById(R.id.register_contact);
        editPassword = (EditText) findViewById(R.id.register_password);
        editNextOfKin1 = (EditText) findViewById(R.id.nexofkin_contact1);
        editNextOfKin2 = (EditText) findViewById(R.id.nexofkin_contact2);
        buttonSubmit = (Button) findViewById(R.id.submit);

        displayName =  (TextView) findViewById(R.id.user_name);
        //upload pic
        uploadPic = (FloatingActionButton) findViewById(R.id.image_camera);
        userImage = (CircleImageView) findViewById(R.id.userpic);
        storageReference = FirebaseStorage.getInstance().getReference();
        buttonSubmit.setOnClickListener(this);
        uploadPic.setOnClickListener(this);

        //extract data

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                user = dataSnapshot.getValue(UserDetails.class);

                editName.setText(user.getmUserName());
                editEmailAddress.setText(user.getmMail());
                editContact.setText(user.getmContactNumber());
                editPassword.setText(user.getmPasswors());
                editNextOfKin1.setText(user.getmLevelOneContacOne());
                editNextOfKin2.setText(user.getmLevelTwoContactTwo());
                displayName.setText(user.getmUserName());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        if(firebaseUser.getPhotoUrl() != null ){

            String url = firebaseUser.getPhotoUrl().toString();
            Glide.with(getApplicationContext()).load(url).into(userImage);
        }
    }


    @Override
    public void onClick(View view) {

        if (view == uploadPic) {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, GALLERY_INTENT);

        }

        String name = editName.getText().toString();
        final String email = editEmailAddress.getText().toString();
        String contact = editContact.getText().toString();
        String password = editPassword.getText().toString();
        String nextOfKin1 = editNextOfKin1.getText().toString();
        String nextOfNext2 = editNextOfKin2.getText().toString();

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(), "please, enter your full name", Toast.LENGTH_SHORT).show();
            return;

        }

        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.matches(emailPattern)) {
            Toast.makeText(getApplicationContext(), "valid email address", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(contact)) {
            Toast.makeText(getApplicationContext(), "please, enter your contact number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(nextOfKin1)) {

            Toast.makeText(getApplicationContext(), "please, enter your first next of kin contacts number", Toast.LENGTH_SHORT).show();
            return;

        }

        if (TextUtils.isEmpty(nextOfNext2)) {

            Toast.makeText(getApplicationContext(), "please, enter your second next of kin contacts number ", Toast.LENGTH_SHORT).show();
            return;

        }

        if (TextUtils.isEmpty(password)) {
            //password is empty
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
            //stopping the function execution
            return;
        }
        if (password.length() < 8) {

            Toast.makeText(getApplicationContext(), "password too short, please enter 8 characters", Toast.LENGTH_SHORT).show();

            return;
        }


        if (view == buttonSubmit) {

            String uid = firebaseUser.getUid();

            databaseReference = databaseReference.getRef().child("User");

            UserDetails userDetails = new UserDetails(name, email, contact, password, nextOfKin1, nextOfNext2);
            Map<String, Object> updateUser = new HashMap<>();

            updateUser.put("mUserName", name);
            updateUser.put("mMail", email);
            updateUser.put("mPasswors", password);
            updateUser.put("mContactNumber", contact);
            updateUser.put("mLevelOneContacOne", nextOfKin1);
            updateUser.put("mLevelTwoContactTwo", nextOfNext2);

            databaseReference.child(uid).updateChildren(updateUser);

            startActivity(new Intent(getApplicationContext(), MainActivity.class));

            Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();


            progressDialog.dismiss();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            progressDialog.setMessage("uploading...");
            progressDialog.show();
            StorageReference filepath = storageReference.child("Userphotos").child(uri.getLastPathSegment());
            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri downloadUri = taskSnapshot.getDownloadUrl();

                    Picasso.with(ProfileActivity.this).load(downloadUri).fit().centerCrop().into(userImage);

                    Toast.makeText(ProfileActivity.this, "Upload done", Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }
            });
        }
    }
}

