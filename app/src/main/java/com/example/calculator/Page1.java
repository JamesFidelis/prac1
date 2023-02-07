package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Page1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        //TODO: HERE NIMERECEIVE THE DATA
        String one = getIntent().getStringExtra("firstval");
        String two =getIntent().getStringExtra("secondval");
        String ans = String.valueOf(getIntent().getIntExtra("resultval",0));
        final TextView first =(TextView) findViewById(R.id.first_number);
        final TextView second =(TextView) findViewById(R.id.second_number);
        final TextView result_val =(TextView) findViewById(R.id.result_value);



        first.setText(one);
        second.setText(two);
        result_val.setText(ans);


    }
}