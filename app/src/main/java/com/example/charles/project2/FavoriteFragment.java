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



/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {

    private ListView mFavoritesList;
    private EditText mRecipeName;
    private Button mAddButton;
    public FavoriteFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        mFavoritesList = (ListView) view.findViewById(R.id.favoritesList);
        mRecipeName = (EditText) view.findViewById(R.id.recipe_name);
        mAddButton = (Button) view.findViewById(R.id.add_button);
        final FavoriteArrayAdapter mAdapter = new FavoriteArrayAdapter(this.getActivity(), getRecipes());
        mFavoritesList.setAdapter(mAdapter);
        mAddButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = mRecipeName.getText().toString();
                mAdapter.add(name);
                mAdapter.notifyDataSetChanged();
                mRecipeName.setText("");
            }
        });
        mFavoritesList.setOnClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                mFavoritesList.setSelection(position);
                mAdapter.delete(position, View view);
                mAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    public ArrayList<String> getRecipes(){
        ArrayList<String> recipes = new ArrayList<String>();
        return recipes;
    }

}
