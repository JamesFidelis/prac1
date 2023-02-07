package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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



    }

    int Addition(int n1,int n2){
        return n1+n2;
    }
}