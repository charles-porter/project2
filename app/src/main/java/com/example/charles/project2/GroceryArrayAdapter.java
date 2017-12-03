package com.example.charles.project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Matthew on 12/2/2017.
 */

public class GroceryArrayAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<String> mDataSource;

    public GroceryArrayAdapter(Context context, ArrayList<String> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return mDataSource.size();
    }
    @Override
    public String getItem(int position) {
        return mDataSource.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.text_cell, parent, false);

        TextView name = (TextView) rowView.findViewById(R.id.grocery_text);
        name.setText(getItem(position));

        return rowView;
    }

    public void add(String item)
    {
        mDataSource.add(item);
    }
    public void delete(int position)
    {
        mDataSource.remove(position);
    }



}
