package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final EditText number1= findViewById(R.id.number_one);
       final EditText number2= findViewById(R.id.number_two);
       final TextView result = findViewById(R.id.result);
       final Button add = findViewById(R.id.addition);
       final Button start = findViewById(R.id.startService);
       final Button stop = findViewById(R.id.stopService);


        //TODO: THIS WILL CARRY OU THE CALCULATIONS AND DISPLAY THE RESULTS ON THE NEXT PAGE
       add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int results = Addition(Integer.parseInt(number1.getText().toString()), Integer.parseInt(number2.getText().toString()));
               Intent nextPage = new Intent(MainActivity.this,Page1.class);
//               Intent nextPage = new Intent();
               //TODO: Concept ya put extra ndo hii ambayo ukingalia Page1.java utaona nimezipokea izo data
               nextPage.putExtra("firstval",number1.getText().toString());
               nextPage.putExtra("secondval",number2.getText().toString());
               nextPage.putExtra("resultval",results);
               startActivity(nextPage);
//               nextPage.setAction("android.CUSTOM_INTENT");
//               sendBroadcast(nextPage);
//               MyReceiver receiver = new MyReceiver();
//               receiver.onReceive(MainActivity.this,nextPage);

//               if(TextUtils.isEmpty(number1.getText().toString())||TextUtils.isEmpty(number2.getText().toString())){
//                   Toast.makeText(MainActivity.this, "A number must be entered", Toast.LENGTH_SHORT).show();
//               }else {

//                   result.setText("Result is " + results);
//               }


           }
       });


       //TODO: THIS WILL BE USED TO START THE SERVICE
       start.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent services = new Intent(getBaseContext(), MyService.class);

               startService(services);
           }
       });

       //TODO: THIS WILL BE USED TO STOP THE SERVICE
       stop.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent services = new Intent(getBaseContext(), MyService.class);

               stopService(services);
           }
       });



    }



    int Addition(int n1,int n2){
        return n1+n2;
    }


    //TODO: THIS IS THE CODE USED TO SEND AN SMS
    void sendSMS(){
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
        smsIntent.setData(Uri.parse("smsto:0718321566"));
        smsIntent.putExtra("sms_body", "This is the message that will be sent");
        startActivity(smsIntent);
    }

    //TODO: THIS IS THE CODE USED TO MAKE A CALL
    void callPhone(){
        Intent smsIntent = new Intent(Intent.ACTION_DIAL);
        smsIntent.setData(Uri.parse("tel:0718321566"));
        startActivity(smsIntent);
    }

}