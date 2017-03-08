package com.example.anjali.cimil_application;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;


public class FacebookLogin extends AppCompatActivity {
    private ProfilePictureView profilePictureView ;
    private String dataToShow="";
    TextView txtUserName,txtUserGender,txtUserAge,txtUserCurrentAddress,txtUserHomeTown,txtUserRelationStatus,txtUserReligion,txtUserBioGraphy,email;
     Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_facebook_login);
        profilePictureView=(ProfilePictureView)findViewById(R.id.profile_picture);
        logout = (Button)findViewById(R.id.logout);
        logout.setOnClickListener(logoutbyFB);
        txtUserName = (TextView)findViewById(R.id.txt_user_name);
        email = (TextView)findViewById(R.id.about_user_data);
        txtUserAge = (TextView)findViewById(R.id.txt_user_age);
        txtUserGender = (TextView)findViewById(R.id.txt_user_gender);
        txtUserCurrentAddress = (TextView)findViewById(R.id.txt_user_current_loc);
        txtUserHomeTown = (TextView)findViewById(R.id.txt_user_hometown);
        txtUserRelationStatus=(TextView)findViewById(R.id.user_relationship_status);
        txtUserReligion=(TextView)findViewById(R.id.about_user_religion);
        txtUserBioGraphy=(TextView)findViewById(R.id.about_user_data);
        Intent intent = getIntent();
        if(intent.hasExtra("name")) {
            String username = intent.getStringExtra("name");
            String usergender = intent.getStringExtra("gender");
            String age = intent.getStringExtra("age");
//            String current_address = intent.getStringExtra("current_location");
//            String home = intent.getStringExtra("home");
//            String religion = intent.getStringExtra("religion");
//            String status = intent.getStringExtra("status");
            String id = intent.getStringExtra("pic_id");
            String email_user = intent.getStringExtra("email");
            txtUserName.setText(username);
//            txtUserAge.setText(age);
            txtUserGender.setText(usergender);
//            txtUserCurrentAddress.setText(current_address);
//            txtUserHomeTown.setText(home);
//            txtUserRelationStatus.setText(status);
//            txtUserReligion.setText(religion);
            profilePictureView.setProfileId(id);
            email.setText(email_user);

        }
    }
  View.OnClickListener logoutbyFB = new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          LoginManager.getInstance().logOut();
          startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
      }
  };

}

