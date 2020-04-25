package com.example.cheffy;

import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Created by Kiit on 23-04-2016.
 */
public class PrefFragment extends PreferenceFragment {




    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.fragment_pref);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);


        this.getActivity().setTheme(R.style.MyPreferencesTheme);
        view.setBackgroundColor(Color.parseColor("#EEE8AA"));



        return view;
    }


}
