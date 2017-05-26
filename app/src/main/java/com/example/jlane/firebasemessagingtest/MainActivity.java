package com.example.jlane.firebasemessagingtest;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button btnShowToken = (Button)findViewById(R.id.button_show_token);
        Button btnShowMessage = (Button)findViewById(R.id.button_show_message);
        btnShowToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get the token
                String token = FirebaseInstanceId.getInstance().getToken();
                Log.d(TAG, "Token: " + token);
                Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
            }
        });
        final DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch(which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        Toast.makeText(MainActivity.this,"Yes",Toast.LENGTH_SHORT).show();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        Toast.makeText(MainActivity.this,"No",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        btnShowMessage.setOnClickListener(new View.OnClickListener() {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            @Override
            public void onClick(View v) {


                builder.setMessage(MyFirebaseMessagingService.message).setPositiveButton("Yes", dialogClickListener).setNegativeButton("No",dialogClickListener).show();
                //Toast.makeText(MainActivity.this, MyFirebaseMessagingService.message,Toast.LENGTH_LONG).show();




            }
        });




    }
}
