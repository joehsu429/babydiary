package com.example.student.babydiary.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

        cv.put("_feednum",s.feednum);
        cv.put("recordtime",s.recordtime);
        cv.put("mothermilk",s.mothermilk);
        cv.put("formula",s.formula);
        cv.put("weaning",s.weaning);
        db.insert("feed_data",null,cv);
        db.close();
        return true;
    }

    //修改飲食資料
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

    //刪除飲食資料
    public boolean deletefeed(int  feednum)
    {
        db.delete("feed_data","_feednum=?",new String[]{String.valueOf(feednum)});
        return true;
    }
}
