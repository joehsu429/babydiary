package com.example.student.babydiary.data;

/**
 * Created by Student on 2018/1/23.
 */

public class sleep_data {

    public String date;//日期
    public String time;//時間
    double sleeplength;
    int personid;
//    date recordtime;
//    time startsleeptime;
//    time endsleeptime;


    public sleep_data(int sleepnum, double sleeplength, int personid)
    {

        this.sleeplength=sleeplength;
        this.personid=personid;
    }

}
