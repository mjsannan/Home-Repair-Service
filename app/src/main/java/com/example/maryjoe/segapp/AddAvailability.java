package com.example.maryjoe.segapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.Query;


import android.app.DialogFragment;
import android.widget.DatePicker;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class AddAvailability extends Activity implements View.OnClickListener {

    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime;

    EditText tmpName;

    private int mYear, mMonth, mDay, mHour, mMinute;

    public static DatabaseReference database;
    public static FirebaseDatabase myFirebaseDatabase;

    public static String key;
    public static final String TAG = "GETTING NAME OF USER";


    static ArrayList <String> availabilityList = new ArrayList <String> (1000);;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_availability);

        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnTimePicker = (Button) findViewById(R.id.btn_time);
        txtDate = (EditText) findViewById(R.id.in_date);
        txtTime = (EditText )findViewById(R.id.in_time);
        tmpName = (EditText) findViewById(R.id.nameToGet);

        btnTimePicker.setOnClickListener(this);

        myFirebaseDatabase = FirebaseDatabase.getInstance();
        database = myFirebaseDatabase.getReference();

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize a new date picker dialog fragment
                DialogFragment dFragment = new DatePickerFragment();

                // Show the date picker dialog fragment
                dFragment.show(getFragmentManager(), "Date Picker");
            }
        });

        if (availabilityList.isEmpty()){
            Toast.makeText(this, "No availability set ", Toast.LENGTH_SHORT).show();
        }

        if (availabilityList.size() == 1) {
            TextView day1 = findViewById(R.id.day1);
            if (availabilityList.get(0) != null) {
                day1.setText(availabilityList.get(0));
            }
        }

        if (availabilityList.size() == 2) {

            TextView day1 = findViewById(R.id.day1);
            if (availabilityList.get(0) != null) {
                day1.setText(availabilityList.get(0));
            }

            TextView day2 = findViewById(R.id.day2);
            if (availabilityList.get(1) != null) {
                day2.setText(availabilityList.get(1));
            }

        }

        if (availabilityList.size() == 3) {
            TextView day1 = findViewById(R.id.day1);
            if (availabilityList.get(0) != null) {
                day1.setText(availabilityList.get(0));
            }

            TextView day2 = findViewById(R.id.day2);
            if (availabilityList.get(1) != null) {
                day2.setText(availabilityList.get(1));
            }

            TextView day3 = findViewById(R.id.day3);
            if (availabilityList.get(2) != null) {
                day3.setText(availabilityList.get(2));
            }
        }

        if (availabilityList.size() == 4) {
            TextView day1 = findViewById(R.id.day1);
            if (availabilityList.get(0) != null) {
                day1.setText(availabilityList.get(0));
            }

            TextView day2 = findViewById(R.id.day2);
            if (availabilityList.get(1) != null) {
                day2.setText(availabilityList.get(1));
            }

            TextView day3 = findViewById(R.id.day3);
            if (availabilityList.get(2) != null) {
                day3.setText(availabilityList.get(2));
            }

            TextView day4 = findViewById(R.id.day4);
            if (availabilityList.get(3) != null) {
                day4.setText(availabilityList.get(3));
            }
        }



        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        Query query = rootRef.child("Users").orderByChild("Email").equalTo(SignIn.emailLoggingIn);
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    key = ds.getKey();
                    tmpName.setText(key);
                    Log.d(TAG, key);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        };
        query.addListenerForSingleValueEvent(valueEventListener);
    }

    @Override
    public void onClick(View v) {

        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();

        }
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dpd = new DatePickerDialog(getActivity(),
                    AlertDialog.THEME_HOLO_LIGHT,this,year,month,day);


            calendar.add(Calendar.DATE, 3);

            dpd.getDatePicker().setMaxDate(calendar.getTimeInMillis());

            calendar.add(Calendar.DATE, -6);

            dpd.getDatePicker().setMinDate(calendar.getTimeInMillis());

            return  dpd;
        }

        public void onDateSet(DatePicker view, int year, int month, int day){
            TextView tv = (TextView) getActivity().findViewById(R.id.in_date);

            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(0);
            cal.set(year, month, day, 0, 0, 0);
            Date chosenDate = cal.getTime();

            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
            String formattedDate = df.format(chosenDate);

            tv.setText(formattedDate);
        }
    }

    public void confirmAvail(View v) {

        String newEntry = SignIn.emailLoggingIn;
        newEntry = newEntry.replace(".", ",");

        database.child("Availability").setValue(newEntry);

        database.child("Availability").child(newEntry).child("Time").setValue(txtTime.getText().toString());
        database.child("Availability").child(newEntry).child("Date").setValue(txtDate.getText().toString());

        availabilityList.add(txtTime.getText().toString());
        availabilityList.add(txtDate.getText().toString());

        Toast.makeText(this, "Availability added to profile", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ServiceOptions.class);
        startActivity(intent);
    }

}
