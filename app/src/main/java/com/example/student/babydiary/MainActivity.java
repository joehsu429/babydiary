package com.example.student.babydiary;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity{
    TextView tv,tv2,tv3,tv4;
    EditText ed,ed2;
    Spinner sp;
    Calendar c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = new TextView(this);
        tv2 = new TextView(this);
        tv3 = new TextView(this);
        tv4 = new TextView(this);
        ed2 = (EditText) findViewById(R.id.editText_Birthday);
        ed2.setInputType(InputType.TYPE_NULL);

        ed2.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    c=Calendar.getInstance();
                    new DatePickerDialog(MainActivity.this,android.R.style.Theme_Holo_Dialog, new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                            ed2.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                        }
                    }, c.get(c.YEAR), c.get(c.MONTH), c.get(c.DAY_OF_MONTH)).show();

                }
            }
        });

        ed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c = Calendar.getInstance();
                new DatePickerDialog(MainActivity.this,android.R.style.Theme_Holo_Light_Dialog, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        ed2.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                    }
                }, c.get(c.YEAR), c.get(c.MONTH), c.get(c.DAY_OF_MONTH)).show();

            }
        });
    }

    public void click1(View v)
    {
        Intent it = new Intent(this,Main2Activity.class);//跳第2頁
        startActivity(it);
    }

}
