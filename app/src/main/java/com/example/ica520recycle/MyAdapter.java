package com.example.ica520recycle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * This Class defines the RecyclerView Adapter and ViewHolder for this app.
 * This app is intentionally threadbare, so that I can reference it
 * at a later date, as an example of how to implement a Recycler View,
 * due to the extensive number of steps this process requires.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{

    //This will represent the data to display in the RV
    private final LinkedList<String> mIntList;

    //This is for the LayoutInflator.  This is required to convert
    //*list_item.xml* into the appropriate View items.
    private LayoutInflater mInflater;

    //The constructor for the Adapter
    public MyAdapter(Context context,LinkedList<String> intList){
        mInflater = LayoutInflater.from(context);
        this.mIntList = intList;
    }

    //This is where the layout is inflated, using the layout for just one item.
    @Override
    public MyAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int i) {

        View mItemView = mInflater.inflate(R.layout.list_item,parent,false);

        return new MyHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyHolder myHolder, int i) {
        String mCurrent = mIntList.get(i); //The position of the data list
        myHolder.intItemView.setText(mCurrent);//Sets the text in the view of this item
    }

    @Override
    public int getItemCount() {
        return mIntList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        public final TextView intItemView;
        final MyAdapter mAdapter;

        public MyHolder( View itemView, MyAdapter adapter) {
            super(itemView);
            intItemView = itemView.findViewById(R.id.integer);
            this.mAdapter = adapter;
        }
    }
}
