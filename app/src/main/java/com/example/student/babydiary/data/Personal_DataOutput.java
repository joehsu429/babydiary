package com.example.student.babydiary.data;

/**
 * Created by user on 2018/1/24.
 */

public class Personal_DataOutput {
    public int personalid;
    String name;
    int gender;
    String birthday;


    public Personal_DataOutput(int personalid,String name, int gender, String birthday)
    {

        this.personalid = personalid;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }
}
