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
        recipies.add(new Recipe("Cheese", "Good Cheese", Arrays.asList("Cheese Mexican Tortalini".split("\\s+")), Arrays.asList("Bowl Heat Magic".split("\\s+")), 20));
        recipies.add(new Recipe("test", "testing", Arrays.asList("Code Working Please".split("\\s+")), Arrays.asList("Computer Miracle".split("\\s+")), 200));
        recipies.add(new Recipe("null", "null", Arrays.asList("null".split("\\s+")), Arrays.asList("null".split("\\s+")), 2000));
        recipies.add(new Recipe("Cooking App", "this", Arrays.asList("Programmers,Graphics Students,Journalist ".split(",")), Arrays.asList("Time Computers Ideas Recipies".split("\\s+")), 9001));
        recipies.add(new Recipe("Look", "cool", Arrays.asList("Programmers,Graphics Students,Journalist ".split(",")), Arrays.asList("Time Computers Ideas Recipies".split("\\s+")), 9001));
        recipies.add(new Recipe("At", "things", Arrays.asList("Programmers,Graphics Students,Journalist ".split(",")), Arrays.asList("Time Computers Ideas Recipies".split("\\s+")), 9001));
        recipies.add(new Recipe("This", "are", Arrays.asList("Programmers,Graphics Students,Journalist ".split(",")), Arrays.asList("Time Computers Ideas Recipies".split("\\s+")), 9001));
        recipies.add(new Recipe("App", "around", Arrays.asList("Programmers,Graphics Students,Journalist ".split(",")), Arrays.asList("Time Computers Ideas Recipies".split("\\s+")), 9001));
        recipies.add(new Recipe("Man", "the", Arrays.asList("Programmers,Graphics Students,Journalist ".split(",")), Arrays.asList("Time Computers Ideas Recipies".split("\\s+")), 9001));
        recipies.add(new Recipe("Cool", "corner", Arrays.asList("Programmers,Graphics Students,Journalist ".split(",")), Arrays.asList("Time Computers Ideas Recipies".split("\\s+")), 9001));
        return recipies;
    }

}
