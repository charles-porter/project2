package com.example.charles.project2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import io.realm.Realm;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {

    private ListView favoritesList;
    private Realm realm;
    public FavoriteFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        ArrayList<Recipes> recipe = new ArrayList<Recipes>();
        favoritesList = (ListView) view.findViewById(R.id.favoritesList);
        return view;
    }

}
