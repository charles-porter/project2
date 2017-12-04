package com.example.charles.project2;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private EditText searchText;
    private ListView searchView;
    private Button searchButton;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        searchText = (EditText) view.findViewById(R.id.search_text);
        searchView = (ListView) view.findViewById(R.id.search_view);
        searchButton = (Button) view.findViewById(R.id.search_button);

        final SearchArrayAdapter mAdapter = new SearchArrayAdapter(this.getActivity(), getSearchList());
        searchView.setAdapter(mAdapter);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = searchText.getText().toString();
                List<String> tokens = Arrays.asList(search.split("\\s+"));


            }
        });

        return view;
    }

    public ArrayList<Recipe> getSearchList()
    {
        ArrayList<Recipe> recipies =  new ArrayList<Recipe>();
        return recipies;
    }

}
