package com.example.student.babydiary.data;

/**
 * Created by user on 2018/1/24.
 */

public class Feed_DataOutout {
    int feednum;
    String recordtime;
    int mothermilk;
    int formula;
    int weaning;
    public  Feed_DataOutout(int feednum ,String recordtime, int mothermilk, int formula, int weaning)
    {
        this.feednum = feednum;
        this.recordtime = recordtime;
        this.mothermilk = mothermilk;
        this.formula = formula;
        this.weaning = weaning;

    }
}
