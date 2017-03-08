package com.example.anjali.cimil_application;

import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.graphics.Typeface;

import android.service.textservice.SpellCheckerService;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class RegistrationActivity extends AppCompatActivity {
    private TextView textView, footer;
    private Button create_an_account, sign_up_by_facebook, sign_up_by_google;
    private CallbackManager callbackManager;
    private String  userName,userGender,userAgeRange,userRelationStatus,userReligion,userHometown,userCurrentAddress,imageurl,id,email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_registration);
        textView = (TextView) findViewById(R.id.textMessage);
        footer = (TextView) findViewById(R.id.SignIn);
        create_an_account = (Button) findViewById(R.id.create_an_account);
        create_an_account.setOnClickListener(sign_in_manually);
        sign_up_by_facebook = (Button)findViewById(R.id.sign_up_by_facebook);
        sign_up_by_facebook.setOnClickListener(facebooklogin);
        sign_up_by_google = (Button) findViewById(R.id.sign_up_by_gmail);
        sign_up_by_google.setOnClickListener(signUpByGoogle);
        Typeface custum_font = Typeface.createFromAsset(getAssets(), "garamond.ttf");
        textView.setTypeface(custum_font);
        footer.setTypeface(custum_font);
        create_an_account.setTypeface(custum_font);
        sign_up_by_facebook.setTypeface(custum_font);
        sign_up_by_google.setTypeface(custum_font);
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = loginResult.getAccessToken();
                Profile profile = Profile.getCurrentProfile();
                GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        System.out.println(object);
                        loadDataFromFaceBook(object);
                    }
                });
                Bundle parameters=new Bundle();
                parameters.putString("fields", "id,name,gender,picture,link,about,age_range,birthday,email,location,hometown,relationship_status,religion");
                request.setParameters(parameters);
                request.executeAsync();
//                displayMessage(profile);
            }
            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });


    }


    @Override
    public void onResume() {
        super.onResume();
        Profile profile = Profile.getCurrentProfile();
        displayMessage(profile);
    }

    private void displayMessage(Profile profile) {
        if (profile !=null){
            Toast.makeText(this, ""+profile.getName(), Toast.LENGTH_SHORT).show();
        }
    }
    View.OnClickListener facebooklogin = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            LoginManager.getInstance().logInWithReadPermissions(RegistrationActivity.this, Arrays.asList( "public_profile","user_friends","email","user_location","user_birthday","user_about_me","user_hometown","user_relationships","user_religion_politics"));


        }
    };
    @Override
    protected void onActivityResult(int requestCode, int responseCode,
                                    Intent data) {
        callbackManager.onActivityResult(requestCode,responseCode,data);


//        if (responseCode == RESULT_OK)
//        {
//            System.out.println("inside success");
//            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
//
//        }LoginManager.getInstance().logOut();

}

    View.OnClickListener sign_in_manually = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(RegistrationActivity.this, ManuallyRegistrationActivity.class));
        }
    };

    View.OnClickListener signUpByGoogle = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            EmailFragment  emailFragment = new EmailFragment();
            ft.add(android.R.id.content,emailFragment);
            ft.commit();
        }
    };
    private void loadDataFromFaceBook(JSONObject object) {
        try
        {
            userName = object.getString("name");
            userGender = object.getString("gender");
            userAgeRange=object.getString("age_range");
//            JSONObject locationObject=(object.getJSONObject("location"));
//            userCurrentAddress = locationObject.getString("name");
//            locationObject = object.getJSONObject("hometown");
//            userHometown = locationObject.getString("name");
//            JSONObject imageObject=object.getJSONObject("picture");
//            JSONObject data=imageObject.getJSONObject("data");
//            imageurl = data.getString("url");
            email = object.getString("email");
//            userRelationStatus = object.getString("relationship_status");
//            userReligion = object.getString("religion");
            id = object.getString("id");
            startActivity(new Intent(getApplicationContext(),FacebookLogin.class)
                    .putExtra("name",userName)
                    .putExtra("gender",userGender)
                    .putExtra("age",userAgeRange)
//                    .putExtra("current_location",userCurrentAddress)
//                    .putExtra("home",userHometown)
                    .putExtra("pic_id",id)
                    .putExtra("email",email)
//                    .putExtra("status",userRelationStatus)
//                    .putExtra("religion",userReligion)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
