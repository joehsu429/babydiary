package com.example.student.babydiary;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.student.babydiary.data.Feed_DataDAO;
import com.example.student.babydiary.data.Feed_DataOutout;
import com.example.student.babydiary.data.Personal_Data;
import com.example.student.babydiary.data.Personal_DataDAO;

import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity{
    TextView tv,tv2,tv3,tv4;
    EditText ed,ed2;
    Spinner sp;
    Calendar c;
    RadioGroup radioGroup_sex;
    int gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Feed_DataDAO feed_dataDAO = new Feed_DataDAO(MainActivity.this);
        ArrayList<Feed_DataOutout> s;
        s = feed_dataDAO.getList();
        for (int i = 0;i < s.size();i++)
        {
            Log.d("DDDDMMMMM",s.get(i).feednum + s.get(i).date +" " + s.get(i).time);
        }


        //宣告radioGrop
        radioGroup_sex = (RadioGroup)findViewById(R.id.radioGroup_sex);

        ed = (EditText)findViewById(R.id.editText_name);
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


        //radiobutton確認選項


        radioGroup_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(RadioGroup radioGroup, int checkedId ) {
                   switch (checkedId)
                   {
                       case R.id.radioButton_boy:
                           gender = 1;
                           //Toast.makeText(MainActivity.this,"boy" + gender,Toast.LENGTH_SHORT).show();
                            break;
                       case R.id.radioButton_girl:
                           gender = 0;
                           //Toast.makeText(MainActivity.this,"girl" + gender,Toast.LENGTH_SHORT).show();
                           break;
                   }
               }
           });

    }





    //按確定會把寶寶資料存到DB
    public void click1(View v)
    {
        Intent it = new Intent(this,Main2Activity.class);//跳第2頁
        startActivity(it);

        Personal_DataDAO dao = new Personal_DataDAO(MainActivity.this);

        //ID,姓名,性別代號,生日
        int personalid = 1;
        Personal_Data personal_data = new Personal_Data(personalid++,ed.getText().toString(),gender,ed2.getText().toString());
        //加入資料庫
        dao.addbaby(personal_data);
        //ed2 Birthday
        //ed 姓名
        //Personal_DataDAO dao = new Personal_DataDAO(MainActivity.this);
        //Personal_Data personal_data = new Personal_Data(111,"CHANG",1,"2016/05/9");
        //dao.addbaby(personal_data);
    }

}
