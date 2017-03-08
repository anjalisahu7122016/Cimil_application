package com.example.anjali.cimil_application;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;

import java.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;


/**
 * Created by Anjali on 01/03/2017.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    EditText DOB ;

    public DatePickerFragment(View view)
    {
        DOB = (EditText)view;
    }

    public  Dialog onCreateDialog(Bundle SavedInstanceState)
    {
       final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity() , this,year,month,day);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {

        String date = day+"-"+(month+1)+"-"+year;
        DOB.setText(date);

    }

}