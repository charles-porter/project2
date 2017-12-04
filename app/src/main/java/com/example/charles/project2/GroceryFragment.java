package com.example.charles.project2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */

public class GroceryFragment extends Fragment {
    private ListView mShoppingList;
    private EditText mItemEdit;
    private Button mAddButton;


    public GroceryFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_grocery, container, false);

        mShoppingList = (ListView) view.findViewById(R.id.shopping_listView);
        mItemEdit = (EditText) view.findViewById(R.id.item_editText);
        mAddButton = (Button) view.findViewById(R.id.add_button);
        final GroceryArrayAdapter mAdapter = new GroceryArrayAdapter(this.getActivity(), getGroceryList());
        mShoppingList.setAdapter(mAdapter);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = mItemEdit.getText().toString();
                mAdapter.add(item);
                mAdapter.notifyDataSetChanged();
                mItemEdit.setText("");


            }
        });
        mShoppingList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mShoppingList.setSelection(position);
                mAdapter.delete(position, view);
            }
        });

        return view;

    }


    public ArrayList<String> getGroceryList()
    {
        ArrayList<String> groceries = new ArrayList<String>();
        return groceries;
    }
}
