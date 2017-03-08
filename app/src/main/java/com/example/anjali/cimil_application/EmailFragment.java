package com.example.anjali.cimil_application;


import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class EmailFragment extends Fragment {

    TextView next,header,subheader;
    EditText email;


    public EmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_email, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        next = (TextView)getActivity().findViewById(R.id.next);
        email = (EditText)getActivity().findViewById(R.id.email);
        header = (TextView)getActivity().findViewById(R.id.header);
        subheader = (TextView)getActivity().findViewById(R.id.subheader);
        Typeface custon_font = Typeface.createFromAsset(getActivity().getAssets(), "garamond.ttf");
        subheader.setTypeface(custon_font);
        header.setTypeface(custon_font);
        email.setTypeface(custon_font);
        next.setTypeface(custon_font);

    }


}
