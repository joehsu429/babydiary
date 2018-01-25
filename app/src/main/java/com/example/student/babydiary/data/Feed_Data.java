package com.example.student.babydiary.data;

/**
 * Created by user on 2018/1/24.
 */

public class Feed_Data {
    //public int feednum;//輸入資料庫的資料不要號碼
    public String date;//日期
    public String time;//時間
    public int mothermilk;
    public int formula;
    public int weaning;
    public  Feed_Data(String date,String time, int mothermilk, int formula, int weaning)
    {

        this.time = time;
        this.date = date;
        this.mothermilk = mothermilk;
        this.formula = formula;
        this.weaning = weaning;

    }
}
