package com.example.anjali.cimil_application;

import android.app.DatePickerDialog;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class ManuallyRegistrationActivity extends AppCompatActivity {
TextView signIn,header,subheader;
    EditText name,password,phone,DOB,place;
    Button sign_up,reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manually_registration);

        sign_up = (Button) findViewById(R.id.SignUp);
        sign_up.setOnClickListener(signUpListener);
        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(resetListener);
        signIn = (TextView) findViewById(R.id.SignIn);
        header = (TextView) findViewById(R.id.header);
        subheader = (TextView) findViewById(R.id.subheader);
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        phone = (EditText) findViewById(R.id.phone);
        DOB = (EditText) findViewById(R.id.DOB);
        place = (EditText) findViewById(R.id.place);

        Typeface custon_font = Typeface.createFromAsset(getAssets(), "garamond.ttf");

        signIn.setTypeface(custon_font);
        sign_up.setTypeface(custon_font);
        reset.setTypeface(custon_font);
        name.setTypeface(custon_font);
        name.requestFocus();
        password.setTypeface(custon_font);
        phone.setTypeface(custon_font);
        DOB.setTypeface(custon_font);
        place.setTypeface(custon_font);
        header.setTypeface(custon_font);
        subheader.setTypeface(custon_font);


    }

    public  void onStart()
    {
        super.onStart();
        DOB.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus)
                {
                    DatePickerFragment datePickerFragment = new DatePickerFragment(view);
                    datePickerFragment.show(getSupportFragmentManager() , "Pick your date");
                    place.requestFocus();
                }
            }
        });
    }

    View.OnClickListener resetListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            name.setText("");
            password.setText("");
            phone.setText("");
            DOB.setText("");
            place.setText("");
        }
    };

    View.OnClickListener signUpListener = new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {

        }
    };
}


