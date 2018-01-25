package com.example.student.babydiary.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by user on 2018/1/24.
 */

public class Feed_DataDAO {
    Context context;
    SQLiteDatabase db;
    public Feed_DataDAO(Context context)
    {
        this.context = context;
        MyDBHelper myDBHelper = new MyDBHelper(context);
        db = myDBHelper.getWritableDatabase();
    }

    //新增飲食資料
    public boolean addfeed(Feed_Data s)
    {
        ContentValues cv = new ContentValues();

        //cv.put("_feednum",s.feednum);//輸入資料庫的資料不要號碼
        cv.put("date",s.date);
        cv.put("time",s.time);
        cv.put("mothermilk",s.mothermilk);
        cv.put("formula",s.formula);
        cv.put("weaning",s.weaning);
        db.insert("feed_data",null,cv);
        db.close();
        return true;
    }
    //查詢feedDB 資料
    //讀出資料庫用不同的class Feed_DataOutout 因為欄位不一樣
    public ArrayList<Feed_DataOutout> getList() {
        ArrayList<Feed_DataOutout> mylist = new ArrayList<>();
        Cursor c = db.query("feed_data", new String[] {"_feednum", "date","time", "mothermilk","formula","weaning"}, null, null, null, null, null);
        if (c.moveToFirst())
        {
            Feed_DataOutout s1 = new Feed_DataOutout(c.getInt(0),c.getString(1),c.getString(2),c.getInt(3),c.getInt(4),c.getInt(5));

            mylist.add(s1);
            while(c.moveToNext())
            {
                Feed_DataOutout s = new Feed_DataOutout(c.getInt(0),c.getString(1),c.getString(2),c.getInt(3),c.getInt(4),c.getInt(5));
                mylist.add(s);
            }
        }
        return mylist;
    }


    //修改飲食資料
    /*
    public boolean alterfeed(Feed_Data  s)
    {
        ContentValues cv = new ContentValues();
        cv.put("recordtime",s.recordtime);
        cv.put("mothermilk",s.mothermilk);
        cv.put("formula",s.formula);
        cv.put("weaning",s.weaning);

        db.update("feed_data",cv,"_feednum=?",
                new String[]{String.valueOf(s.feednum)});
        return true;
    }
    */
    /*
    //刪除飲食資料
    public boolean deletefeed(int  feednum)
    {
        db.delete("feed_data","_feednum=?",new String[]{String.valueOf(feednum)});
        return true;
    }
    */



}
