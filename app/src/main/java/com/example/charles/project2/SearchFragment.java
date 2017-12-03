package com.example.charles.project2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private EditText searchText;
    private Button searchButton;
    private ListView searchList;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        searchButton = (Button) view.findViewById(R.id.search_button);
        searchText = (EditText) view.findViewById(R.id.search_text);
        searchList = (ListView) view.findViewById(R.id.search_list);


        return view;
    }

}
