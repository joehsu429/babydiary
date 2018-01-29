package com.example.student.babydiary.data;

/**
 * Created by Student on 2018/1/23.
 */

public class Sleep_Data {

    public String date;//日期
    public String time;//時間
    public String startsleep;
    public String endsleep;
    public String sleeptime;
    public int addtype;


    public Sleep_Data(String date, String time, String startsleep, String endsleep, String sleeptime)
    {

        this.time = time;
        this.date = date;
        this.startsleep = startsleep;
        this.endsleep = endsleep;
        this.sleeptime = sleeptime;
        this.addtype = 3;
    }

}
