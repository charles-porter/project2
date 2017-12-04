package com.example.charles.project2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {

    private ListView mFavoritesList;
    private EditText mRecipeName;
    private Button mAddButton;
    private MainActivity mainActivity;

    public FavoriteFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        mFavoritesList = (ListView) view.findViewById(R.id.favoritesList);
        mainActivity = (MainActivity) this.getActivity();

        final FavoriteArrayAdapter mAdapter = new FavoriteArrayAdapter(this.getActivity(), getRecipes());
        mFavoritesList.setAdapter(mAdapter);


        return view;
    }

    @Override
    public void onResume()
    {
        super.onResume();

        FavoriteArrayAdapter adapter = new FavoriteArrayAdapter(this.getActivity(), getRecipes());
        mFavoritesList.setAdapter(adapter);
    }

    public ArrayList<Recipe> getRecipes(){

        return mainActivity.recipies;
    }

}
