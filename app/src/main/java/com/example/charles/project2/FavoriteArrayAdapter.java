package com.example.charles.project2;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Charles on 12/4/2017.
 */

public class FavoriteArrayAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<String> mDataSource;

    public FavoriteArrayAdapter(Context context, ArrayList<String> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {return mDataSource.size();}
    @Override
    public String getItem (int position){return mDataSource.get(position);}
    @Override
    public long getItemId(int position) {return position;}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.text_cell, parent, false);

        TextView recipe = (TextView) rowView.findViewById(R.id.grocery_text);
        recipe.setText(getItem(position));

        return rowView;
    }

    public void add(String item) {mDataSource.add(item);}
    public void delete(int position, View view){
        mDataSource.remove(position);
    }
}
