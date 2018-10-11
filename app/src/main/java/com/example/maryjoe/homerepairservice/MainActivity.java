package com.example.maryjoe.homerepairservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.HomeRepairService.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        // opens a new activity when the sign up button is pushed
        Intent intent = new Intent(this, DisplayMessageActivity.class);
<<<<<<< HEAD
        EditText editText = (EditText) findViewById(R.id.editText3); //not sure about editText3
=======
        EditText editText = (EditText) findViewById(R.id.editText3);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void sendMessage2(View view) {
     // opens a new activity when the sign in button is pushed
        Intent intent = new Intent(this, WelcomePage.class);
        EditText editText = (EditText) findViewById(R.id.editText3);
>>>>>>> 2b31c3d04bfb75af064787c142143739a628b53b
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
