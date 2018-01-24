package com.example.student.babydiary;

/**
 * Created by Student on 2018/1/23.
 */

public class sleep_data {
    int sleepnum;
    double sleeplength;
    String recordtime;
    String startsleeptime;
    String endsleeptime;


    public sleep_data(int sleepnum, double sleeplength,String recordtime,
            String startsleeptime, String endsleeptime)
    {
        this.sleepnum=sleepnum;
        this.sleeplength=sleeplength;
        this.recordtime=recordtime;
        this.startsleeptime=startsleeptime;
        this.endsleeptime=endsleeptime;
    }

}
