package com.example.student.babydiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Student on 2018/1/24.
 */

public class sleep_dataDAO {
    Context context;
    SQLiteDatabase db;


    public sleep_dataDAO(Context context)
    {
        this.context = context;
        MyDBHelper myDBHelper = new MyDBHelper(context);
        db = myDBHelper.getWritableDatabase();
    }

    //新增睡覺時間
    public boolean addsleep(sleep_data s)
    {
        ContentValues cv = new ContentValues();

        cv.put("_sleepnum",s.sleepnum);
        cv.put("recordtime",s.recordtime);
        cv.put("sleeplength",s.sleeplength);
        cv.put("startsleeptime",s.startsleeptime);
        cv.put("endsleeptime",s.endsleeptime);
        db.insert("sleep_data",null,cv);
        db.close();
        return true;
    }

    //修改睡覺時間
    public boolean altersleep(sleep_data  s)
    {
        ContentValues cv = new ContentValues();
        cv.put("recordtime",s.recordtime);
        cv.put("sleeplength",s.sleeplength);
        cv.put("startsleeptime",s.startsleeptime);
        cv.put("endsleeptime",s.endsleeptime);
        db.update("sleep_data",cv,"_sleepnum=?",
                new String[]{String.valueOf(s.sleepnum)});
        return true;
    }

    //刪除睡覺資料
    public boolean deletesleep(int  sleepnum)
    {
        db.delete("sleep_data","_sleepnum=?",new String[]{String.valueOf(sleepnum)});
        return true;
    }
}

