package com.example.student.babydiary.data;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/23.
 */

public interface sleepDAO {
    public boolean add(sleep_data s);
    public ArrayList<sleep_data> getList();
    public sleep_data getsleep_data(int id);
    public boolean update(sleep_data s);
    public boolean delete(int id);
}
