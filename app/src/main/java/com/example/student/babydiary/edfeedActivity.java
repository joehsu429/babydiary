package com.example.student.babydiary;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.student.babydiary.data.Feed_DataOutout;

public class edfeedActivity extends AppCompatActivity {
    EditText edmk,edformu,edwean;
    int feednum;
    Feed_DataOutout s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edfeed);
        edmk = (EditText)findViewById(R.id.edfeed_mkmilk);
        edwean = (EditText)findViewById(R.id.edfeed_edweaning);
        edformu = (EditText)findViewById(R.id.feed_edformula);
        Intent it = getIntent();
        feednum = it.getIntExtra("feednum",0);

    }

    @Override
    protected void onResume() {
        super.onResume();
        s = Main7Activity.dao.getfeed(feednum);
        edmk.setText(String.valueOf(s.mothermilk));
        edformu.setText(String.valueOf(s.formula));
        edwean.setText(String.valueOf(s.weaning));

    }

    //按下修改feed資料
    public void clickalter(View v)
    {
        Feed_DataOutout s1 = new Feed_DataOutout(feednum , s.date,s.time,Integer.valueOf(edmk.getText().toString()),
                Integer.valueOf(edformu.getText().toString()),Integer.valueOf(edwean.getText().toString()));

        Main7Activity.dao.alterfeed(s1);
        finish();
    }

    //按下刪除feed資料
    public void clickdelete(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(edfeedActivity.this);
        builder.setTitle("刪除確認");
        builder.setMessage("確認刪除此筆資料嗎?");
        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Main7Activity.dao.deletefeed(feednum);
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

}
