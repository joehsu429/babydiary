package com.example.student.babydiary.data;

/**
 * Created by user on 2018/1/27.
 */

public class Outputdata {
    public int id;
    public String date;//日期
    public String time;//時間
    public Double mothermilk;
    public Double formula;
    public Double weaning;
    public double tall;
    public double weight;
    public double headlength;//頭圍
    public String startsleep;
    public String endsleep;
    public String sleeptime;
    public int addtype;

    public Outputdata(int id ,String date,String time, Double mothermilk, Double formula, Double weaning,
                      double tall, double weight, double headlength,String startsleep,String endsleep,String sleeptime,int addtype){
        //String startsleep,String endsleep,String sleeptime
        this.id = id;
        this.date= date;
        this.time=time;
        this.mothermilk = mothermilk;
        this.formula = formula;
        this.weaning = weaning;
        this.tall=tall;
        this.weight=weight;
        this.headlength=headlength;
        this.startsleep = startsleep;
        this.endsleep = endsleep;
        this.sleeptime = sleeptime;
        this.addtype = addtype;
    }
}
