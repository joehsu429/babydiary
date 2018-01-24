package com.example.student.babydiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Student on 2018/1/24.
 */

public class grow_dataDAO {
    Context context;
    SQLiteDatabase db;


    public grow_dataDAO(Context context)
    {
        this.context = context;
        MyDBHelper myDBHelper = new MyDBHelper(context);
        db = myDBHelper.getWritableDatabase();
    }

    //新增成長資料
    public boolean addgrow(grow_data s)
    {
        ContentValues cv = new ContentValues();

        cv.put("_grownum",s.grownum);
        cv.put("recordtime",s.recordtime);
        cv.put("tall",s.tall);
        cv.put("weight",s.weight);
        cv.put("headlegth",s.headlegth);
        db.insert("grow_data",null,cv);
        db.close();
        return true;
    }

    //修改成長資料
    public boolean altergrow(grow_data  s)
    {
        ContentValues cv = new ContentValues();
        cv.put("recordtime",s.recordtime);
        cv.put("tall",s.tall);
        cv.put("weight",s.weight);
        cv.put("headlegth",s.headlegth);
        db.update("grow_data",cv,"_grownum=?",
                new String[]{String.valueOf(s.grownum)});
        return true;
    }

    //刪除成長資料
    public boolean deletegrow(int  grownum)
    {
        db.delete("grow_data","_grownum=?",new String[]{String.valueOf(grownum)});
        return true;
    }
}
