package com.example.moon.complaintsystem;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.moon.complaintsystem.MainActivity.furniture;
import static com.example.moon.complaintsystem.MainActivity.laundry;
import static com.example.moon.complaintsystem.MainActivity.userNameDataBase;
import static com.example.moon.complaintsystem.MainActivity.userRoomDataBase;

public class FurnitureActivity extends AppCompatActivity {
    EditText userComplaint,userName,userRoom;
    TextView displayText;
    SharedPreferences prefs5;
    int flag;

    public void onClick(View view){

        try {
            InputMethodManager inputManager = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);

            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
        catch(Exception e){

        }

        if(userComplaint.getText().toString().equals("")||userRoom.getText().toString().equals("")||userName.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter a valid complaint", Toast.LENGTH_SHORT).show();


        }
        else if(userComplaint.getText().toString().equals(prefs5.getString("FurnitureComplaint",null))){
            Toast.makeText(getApplicationContext(), "Already Registered", Toast.LENGTH_SHORT).show();

        }

        else{

            String enteredComplaint = userComplaint.getText().toString();
            Toast.makeText(getApplicationContext(), "Complaint Registered Successfully", Toast.LENGTH_SHORT).show();
            prefs5.edit().putString("FurnitureComplaint", enteredComplaint).apply();
            displayText.setText("Your Registered Complaint - " + enteredComplaint);
            furniture.setValue(enteredComplaint);
            userRoomDataBase.setValue(userRoom.getText().toString());
            userNameDataBase.setValue(userName.getText().toString());
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture);


        userComplaint=(EditText)findViewById(R.id.userComplaint);
        userName=(EditText)findViewById(R.id.userName);
        userRoom=(EditText)findViewById(R.id.roomNo);
        displayText=(TextView)findViewById(R.id.displayText);

        prefs5 = getSharedPreferences("com.example.moon.complaintsystem", MODE_PRIVATE);
        displayText.setText("Your Registered Complaint - "+prefs5.getString("FurnitureComplaint","No Complaints registered"));

    }
}
