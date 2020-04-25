package com.example.cheffy;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;



public class HistoryFragment extends Fragment {


    ListView listView;
    ArrayList<String> stringArrayList;
    ArrayAdapter<String> arrayAdapter;

    private static Parcelable mListViewScrollPos = null;
    int mCurCheckPosition = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.history_layout, container,false);

        //Save fragment data


            //End

        //

        //


            listView = (ListView) view.findViewById(R.id.listView);
            stringArrayList = new ArrayList<String>();
            for (int i = 1; i < 3; i++)
            {
                stringArrayList.add("Notification: " + i);
            }
            arrayAdapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, stringArrayList);
            listView.setAdapter(arrayAdapter);


            //stringArrayList.add("");
            //arrayAdapter.notifyDataSetChanged();


            return view;

        }



    public  void updateHistory(String dname)
    {

        stringArrayList.add(dname);
        arrayAdapter.notifyDataSetChanged();


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {

        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        // Save the ListView position

    }



}
