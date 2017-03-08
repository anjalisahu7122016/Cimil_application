package com.example.anjali.cimil_application;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneFragment extends Fragment {
    TextView submit,header,subheader;
    EditText phone;


    public PhoneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_phone, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        submit = (TextView)getActivity().findViewById(R.id.submit);
        header = (TextView)getActivity().findViewById(R.id.header);
        subheader = (TextView)getActivity().findViewById(R.id.subheader);
        phone = (EditText)getActivity().findViewById(R.id.phone);
        Typeface custon_font = Typeface.createFromAsset(getActivity().getAssets(), "garamond.ttf");
        phone.setTypeface(custon_font);
        subheader.setTypeface(custon_font);
        header.setTypeface(custon_font);
        submit.setTypeface(custon_font);
    }

}
