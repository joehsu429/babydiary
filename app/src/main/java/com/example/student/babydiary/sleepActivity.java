package com.example.student.babydiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class sleepActivity extends AppCompatActivity {
    TextView tv6;
    /*声明日期及时间变量*/
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;
    private long   ut1;
    /*聲明声明对象变量*/
    TimePicker tp;
    DatePicker dp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);
        /*取得目前日期与时间*/
        Calendar c=Calendar.getInstance();
        mYear=c.get(Calendar.YEAR);
        mMonth=c.get(Calendar.MONTH);
        mDay=c.get(Calendar.DAY_OF_MONTH);
        mHour=c.get(Calendar.HOUR_OF_DAY);
        mMinute=c.get(Calendar.MINUTE);
        tv6 = (TextView) findViewById(R.id.sleep_showtime);
        updateDisplay();
        dp = new DatePicker(sleepActivity.this);
        dp.init(mYear,mMonth,mDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int  year, int monthOfYear, int dayOfMonth) {
                mYear=year;
                mMonth= monthOfYear;
                mDay=dayOfMonth;
                /*调用updateDisplay()来改变显示日期*/
                updateDisplay();
            }
        });
         /*取得TimePicker对象，并设置为24小时制显示*/
        tp = new TimePicker(sleepActivity.this);
        tp.setIs24HourView(true);
        /*setOnTimeChangedListener，并重写onTimeChanged event*/
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute) {
                mHour=hourOfDay;
                mMinute=minute;
                /*调用updateDisplay()来改变显示时间*/
                updateDisplay();
            }
        });


    }
    /*设置显示日期时间的方法*/
    private void updateDisplay() {
        tv6.setText(
                new StringBuilder().append(mYear).append("/")
                        .append(format(mMonth + 1)).append("/")
                        .append(format(mDay)).append("　")
                        .append(format(mHour)).append(":")
                        .append(format(mMinute)));
    }

    /*日期时间显示两位数的方法*/
    private String format(int x)
    {
        String s=""+x;
        if(s.length()==1) s="0"+s;
        return s;
    }

    public void click_startsleep(View v)
    {
        //先行定義時間格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //取得現在時間
        Date startdt = new Date();
        //透過SimpleDateFormat的format方法將Date轉為字串
        //String dts = sdf.format(dt);
        ut1 =startdt.getTime();

    }
    public void click_endsleep(View v)
    {
        Date enddt = new Date();
        Long ut2=enddt.getTime();

        long diff = ut1 - ut2;
        long days = diff / (1000 * 60 * 60 * 24);
        long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
        long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
        Log.d("TIMMMMME",""+days+"天"+hours+"小时"+minutes+"分");

    }



}