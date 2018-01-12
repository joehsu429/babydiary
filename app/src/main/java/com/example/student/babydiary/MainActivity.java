package com.example.student.babydiary;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity{
    TextView tv,tv2,tv3;
    EditText ed,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = new TextView(this);
        TextView tv2 = new TextView(this);
        TextView tv3 = new TextView(this);


    }

}
