package com.example.student.babydiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FeedActivity extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence>  adapter = ArrayAdapter.createFromResource(FeedActivity.this,
                R.array.feedfood,android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

    }

    public void clickadd(View v)
    {

    }
}
