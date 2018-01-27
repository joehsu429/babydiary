package com.example.student.babydiary.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by user on 2018/1/27.
 */

public class AlldataDAO {
    Context context;
    SQLiteDatabase db;
    public AlldataDAO(Context context)
    {
        this.context = context;
        MyDBHelper myDBHelper = new MyDBHelper(context);
        db = myDBHelper.getWritableDatabase();
    }

    public ArrayList<Outputdata> getList() {
        ArrayList<Outputdata> mylist = new ArrayList<>();
        Cursor c = db.query("badydata", new String[] {"_id", "date","time", "mothermilk","formula","weaning","tall","weight","headlength","addtype"}, null, null, null, null, null);
        if (c.moveToFirst())
        {
            Outputdata s1 = new Outputdata(c.getInt(0),c.getString(1),c.getString(2),c.getDouble(3),c.getDouble(4),c.getDouble(5),c.getDouble(6),c.getDouble(7),c.getDouble(8),c.getInt(9));

            mylist.add(s1);
            while(c.moveToNext())
            {
                Outputdata  s = new Outputdata(c.getInt(0),c.getString(1),c.getString(2),c.getDouble(3),c.getDouble(4),c.getDouble(5),c.getDouble(6),c.getDouble(7),c.getDouble(8),c.getInt(9));
                mylist.add(s);
            }
        }
        return mylist;
    }




}
