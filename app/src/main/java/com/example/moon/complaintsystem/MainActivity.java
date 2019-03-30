package com.example.moon.complaintsystem;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
   static FirebaseDatabase database;
   static  DatabaseReference furniture,sanitary,laundry,electricity,mess,others,userRoomDataBase,userNameDataBase;

  static  CardView electricityButton,sanitaryButton,messButton,laundryButton,furnitureButton,otherButton;

    private GestureDetectorCompat gestureDetectorCompat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gestureDetectorCompat = new GestureDetectorCompat(this, new MyGestureListener());




         database = FirebaseDatabase.getInstance();

         furniture = database.getReference("furniture");
         sanitary = database.getReference("sanitary");
         laundry = database.getReference("laundry");
         electricity= database.getReference("electricity");
         mess = database.getReference("mess");
         others=database.getReference("other complaints");

         userRoomDataBase=database.getReference("Student RoomNo: ");
         userNameDataBase=database.getReference("Student Name: ");

         electricityButton=(CardView)findViewById(R.id.electricity);
         sanitaryButton=(CardView)findViewById(R.id.sanitaryButton);
         messButton=(CardView)findViewById(R.id.messButton);
         laundryButton=(CardView)findViewById(R.id.laundaryButton);
         furnitureButton=(CardView)findViewById(R.id.furnitureButton);
         otherButton=(CardView)findViewById(R.id.otherButton);

         electricityButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent myIntent=new Intent(MainActivity.this,electricityActivity.class);
                 startActivity(myIntent);

             }
         });
         sanitaryButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent myIntent=new Intent(MainActivity.this,sanitaryActivity.class);
                 startActivity(myIntent);
             }
         });

        messButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(MainActivity.this,MessActivity.class);
                startActivity(myIntent);
            }
        });
        laundryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(MainActivity.this,LaundaryActivity.class);
                startActivity(myIntent);

            }
        });
        furnitureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(MainActivity.this,FurnitureActivity.class);
                startActivity(myIntent);
            }
        });
        otherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(MainActivity.this,OtherActivity.class);
                startActivity(myIntent);
            }
        });








}
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        //handle 'swipe left' action only

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {

         /*
         Toast.makeText(getBaseContext(),
          event1.toString() + "\n\n" +event2.toString(),
          Toast.LENGTH_SHORT).show();
         */

            if(event2.getX() < event1.getX()){


                //switch another activity
                Intent intent = new Intent(
                        MainActivity.this, notification.class);
                startActivity(intent);
            }

            return true;
        }
    }
}
