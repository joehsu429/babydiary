package com.example.student.babydiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.student.babydiary.data.Feed_DataDAO;

public class Main7Activity extends AppCompatActivity {
    ListView listView;
    Myadapter adapter;
    Feed_DataDAO dao;
    TextView settime,setcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        listView = (ListView)findViewById(R.id.listView);
        dao = new Feed_DataDAO(Main7Activity.this);
        adapter = new Myadapter();
        listView.setAdapter(adapter);


    }

    public String setfeedcpntext(int i)
    {
        String contextstr;
        contextstr = "母奶 " + dao.getList().get(i).mothermilk + "CC" + "\n" +
                "配方奶 " + dao.getList().get(i).formula +  "CC" + "\n" +
                "副食品 " + dao.getList().get(i).weaning +  "CC";
        return contextstr;
    }

    //自訂baseadapter 給listview用
    class Myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return dao.getList().size() ;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = LayoutInflater.from(Main7Activity.this);
            //解出自訂的layout
            View v = inflater.inflate(R.layout.diarylayout,null);
            //找到自訂layout上面的textview

            settime = v.findViewById(R.id.settime);
            setcontext = v.findViewById(R.id.setcontext);

            settime.setText(String.valueOf(dao.getList().get(i).time));
            setcontext.setText(setfeedcpntext(i));


            return v;
        }
    }
}
