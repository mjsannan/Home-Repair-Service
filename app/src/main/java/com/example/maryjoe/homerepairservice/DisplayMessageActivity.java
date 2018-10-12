package com.example.maryjoe.homerepairservice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.widget.EditText;

import static com.example.maryjoe.homerepairservice.MainActivity.EXTRA_MESSAGE;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Spinner accountChoice = (Spinner) findViewById(R.id.dropdownMenu);

        ArrayAdapter<String> chooseAccountType= new ArrayAdapter<String>(DisplayMessageActivity.this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.accountTypes));
        chooseAccountType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountChoice.setAdapter(chooseAccountType);
    }

    public void sendMessage3(View view) {
    // opens a new activity when you sign up
        Intent intent = new Intent(this, WelcomePage2.class);
        EditText editText = (EditText) findViewById(R.id.nameTextField);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
