package com.example.student.babydiary;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.student.babydiary.data.Grow_DataOutput;
import com.example.student.babydiary.data.Sleep_DataOutput;

public class edsleepActivity extends AppCompatActivity {
    EditText edsleeptime;
    Sleep_DataOutput s;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edsleep);
        Intent it = getIntent();
        id = it.getIntExtra("id",0);
        edsleeptime = (EditText)findViewById(R.id.sleeptime);

    }

    public void clickdelete(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(edsleepActivity.this);
        builder.setTitle("刪除確認");
        builder.setMessage("確認刪除此筆資料嗎?");
        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Main7Activity.dao.deletesleep(id);
                finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();

    }

    //按下修改feed資料
    public void clickalter(View v)
    {
        Sleep_DataOutput s1 = new Sleep_DataOutput(id , s.date,s.time,s.startsleep,
                s.endsleep,edsleeptime.getText().toString(),s.addtype);

        Main7Activity.dao.altersleep(s1);
        finish();
    }
}
