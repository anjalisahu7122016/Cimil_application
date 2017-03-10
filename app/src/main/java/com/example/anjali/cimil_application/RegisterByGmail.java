package com.example.anjali.cimil_application;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterByGmail extends AppCompatActivity {
    private TextView header,message,Sign_Up;
    private EditText user_name,user_phone,user_password;
    String myValue ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_by_gmail);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"garamond.ttf");
        header = (TextView)findViewById(R.id.header);
        message = (TextView)findViewById(R.id.subheader);
        Sign_Up = (TextView)findViewById(R.id.next);
        user_name = (EditText)findViewById(R.id.name);
        user_phone = (EditText)findViewById(R.id.phone);
        user_password = (EditText)findViewById(R.id.password);
        header.setTypeface(custom_font);
        message.setTypeface(custom_font);
        Sign_Up.setTypeface(custom_font);
        user_name.setTypeface(custom_font);
        user_phone.setTypeface(custom_font);
        user_password.setTypeface(custom_font);
        Intent intent = getIntent();
        if(intent.hasExtra("gmail_name"))
            myValue = intent.getStringExtra("gmail_name");
        user_name.setText(myValue);

    }
}
