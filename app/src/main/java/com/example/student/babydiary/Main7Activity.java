package com.example.student.babydiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.student.babydiary.data.AlldataDAO;
import com.example.student.babydiary.data.Feed_DataDAO;
import com.example.student.babydiary.data.Grow_DataDAO;

public class Main7Activity extends AppCompatActivity {
    ListView listView;
    Myadapter adapter;

    TextView settime,setcontext;
    public static AlldataDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        listView = (ListView)findViewById(R.id.listView);
        //設定dao看資料是哪一張表
        dao = new AlldataDAO(Main7Activity.this);
        adapter = new Myadapter();
        listView.setAdapter(adapter);
        //讓listview item可以被點選,然後跳到修改的那一頁
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (dao.getList().get(i).addtype == 1)
                {
                    Intent it = new Intent(Main7Activity.this,edfeedActivity.class);
                    //用putExtra把資料送出到edfeedactivity
                    it.putExtra("feednum",dao.getList().get(i).id);
                    startActivity(it);
                }
                else if (dao.getList().get(i).addtype == 2)
                {
                    Intent it = new Intent(Main7Activity.this,edgrowActivity.class);
                    startActivity(it);
                }


            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    //設定feed的顯示內容
    public String setfeedcontext(int i)
    {
        String contextstr;
        contextstr = "母奶 " + dao.getList().get(i).mothermilk + "CC" + "\n" +
                "配方奶 " + dao.getList().get(i).formula +  "CC" + "\n" +
                "副食品 " + dao.getList().get(i).weaning +  "CC";
        return contextstr;
    }


    //設定grow的顯示內容
    public String setgrowcontext(int i)
    {
        String contextstr;
        contextstr = "身高 " + dao.getList().get(i).tall + "公分" + "\n" +
                "體重 " + dao.getList().get(i).weight +  "公斤" + "\n" +
                "頭圍 " + dao.getList().get(i).headlength +  "公分";
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
            if (dao.getList().get(i).addtype == 1)
            {
                setcontext.setText(setfeedcontext(i));
            }
            else if (dao.getList().get(i).addtype == 2)
            {
                setcontext.setText(setgrowcontext(i));
            }


            return v;
        }
    }
}
