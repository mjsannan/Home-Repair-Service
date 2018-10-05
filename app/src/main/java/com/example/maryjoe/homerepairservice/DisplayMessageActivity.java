package com.example.maryjoe.homerepairservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.signUp);
        textView.setText(message);

        Spinner accountChoice = (Spinner) findViewById(R.id.dropdownMenu);

        ArrayAdapter<String> chooseAccountType= new ArrayAdapter<String>(DisplayMessageActivity.this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.accountTypes));
        chooseAccountType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountChoice.setAdapter(chooseAccountType);
    }


}
