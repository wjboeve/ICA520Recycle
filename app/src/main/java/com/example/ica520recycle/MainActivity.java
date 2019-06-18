package com.example.ica520recycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mIntList = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //populate the list
        for(int i = 0; i<20; i++){
            mIntList.addLast(Integer.toString(i));
        }

        //Get a handle (or reference name, like a Trucker) to the RV
        //In this case, recycler is the @+id of my RV in activity_main.xml
        mRecyclerView = findViewById(R.id.recycler);
        //Create an adapter and give it the data to display
        mAdapter = new MyAdapter(this,mIntList);
        //Connect the RV and the adapter
        mRecyclerView.setAdapter(mAdapter);
        //Set a default layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
