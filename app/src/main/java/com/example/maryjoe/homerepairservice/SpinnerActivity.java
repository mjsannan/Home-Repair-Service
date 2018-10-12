package com.example.maryjoe.homerepairservice;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

    Object accountType;

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        accountType = parent.getItemAtPosition(pos);
        
    }

    public void onNothingSelected(AdapterView<?> parent) {}

}