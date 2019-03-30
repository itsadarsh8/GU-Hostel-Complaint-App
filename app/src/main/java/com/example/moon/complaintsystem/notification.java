package com.example.moon.complaintsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class notification extends AppCompatActivity {

    TextView notificationtext;
    EditText editText;

    public void pushClick(View view){
        String notif=editText.getText().toString();
        notificationtext.setText("You: "+notif);
        Toast.makeText(getApplicationContext(), "Notification updated successfully", Toast.LENGTH_SHORT).show();
    }

    public void deleteClick(View view){
       if(notificationtext.equals("")){}
       else{
           notificationtext.setText("");
           Toast.makeText(getApplicationContext(), "Notification deleted successfully", Toast.LENGTH_SHORT).show();

       }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notificationtext=(TextView)findViewById(R.id.textView2);
        editText=(EditText)findViewById(R.id.editText);


    }
}
