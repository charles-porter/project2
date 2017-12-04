package com.example.charles.project2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Charles on 12/4/2017.
 */

public class FavoriteArrayAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Recipe> mDataSource;
    private ArrayList<Recipe> mDataShow;
    private Random r;

    public FavoriteArrayAdapter(Context context, ArrayList<Recipe> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mDataShow = new ArrayList<Recipe>();
        r = new Random();
        mDataShow.add(mDataSource.get(r.nextInt(mDataSource.size())));
        for(int i =0; i < 6; i++)
        {
            boolean check = true;
            Recipe pre;
            do
            {

                pre = mDataSource.get(r.nextInt(mDataSource.size()));
                check = true;
                for (Recipe re : mDataShow) {
                    if (re == pre) {
                        check = false;
                    }
                }
            }while(check ==false);
            mDataShow.add(pre);
        }
    }
    @Override
    public int getCount() {return mDataShow.size();}
    @Override
    public Recipe getItem (int position){return mDataShow.get(position);}
    @Override
    public long getItemId(int position) {return position;}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.recipe_cell, parent, false);

        TextView recipeText = (TextView) rowView.findViewById(R.id.recipe_text);
        TextView timeText = (TextView) rowView.findViewById(R.id.time_text);
        TextView ingredientsText = (TextView) rowView.findViewById(R.id.ingredients_text);
        TextView toolsText = (TextView) rowView.findViewById(R.id.tools_text);
        ImageView foodView = (ImageView) rowView.findViewById(R.id.food_view);

        recipeText.setText(getItem(position).getName());
        timeText.setText(Double.toString(mDataShow.get(position).getTime()));

        StringBuilder sb = new StringBuilder();
        for (String s: getItem(position).getIngredients())
        {
            sb.append(s);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        ingredientsText.setText(sb.toString());

        StringBuilder sb2 = new StringBuilder();
        for (String s: getItem(position).getIngredients())
        {
            sb2.append(s);
            sb2.append(",");
        }
        sb2.deleteCharAt(sb2.length()-1);
        toolsText.setText(sb2.toString());

        if(getItem(position).getImage() != null)
        {
            Bitmap bmp = BitmapFactory.decodeByteArray(getItem(position).getImage(), 0, getItem(position).getImage().length);
            foodView.setImageBitmap(bmp);
        }

        return rowView;
    }


}
