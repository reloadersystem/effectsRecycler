package com.example.silvia.transitionlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView NewsRecyclerview;
    NewsAdapter newsAdapter;
    List<NewsItems> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewsRecyclerview = findViewById(R.id.news_rv);
        mData = new ArrayList<>();

        //fill list news with data
        //just for testing purpose i will the news list with random data
        //you may get your data from an api/ firebase or sqlite database

        mData.add(new NewsItems("Quimica", "just for testing purpose i will the news list with random data","6 July 2018", R.drawable.data1));
        mData.add(new NewsItems("Fisica", "just for testing purpose i will the news list with random data","7 July 2018", R.drawable.data2));
        mData.add(new NewsItems("Matematica", "just for testing purpose i will the news list with random data","8 July 2018", R.drawable.data3));
        mData.add(new NewsItems("Algebra", "just for testing purpose i will the news list with random data","9 July 2018", R.drawable.data4));
        mData.add(new NewsItems("Trigonometría", "just for testing purpose i will the news list with random data","10 July 2018", R.drawable.data5));

//adapter ini and setup

        newsAdapter= new NewsAdapter(this, mData);
        NewsRecyclerview.setAdapter(newsAdapter);
        NewsRecyclerview.setLayoutManager(new LinearLayoutManager(this));


    }
}
