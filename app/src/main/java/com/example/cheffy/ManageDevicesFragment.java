package com.example.cheffy;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;


import androidx.fragment.app.Fragment;

import java.lang.reflect.Type;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManageDevicesFragment extends Fragment {


    ListView listView;
    Button button2, button3, button4;
    SharedPreferences sharedPreferences;


    ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manage_devices, container, false);
        button2 = (Button) view.findViewById(R.id.button2);


        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);

        progressBar.getIndeterminateDrawable().setColorFilter(new LightingColorFilter(0x004D40, 0x004D40));
        //progressBar.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.whatsapp2), android.graphics.PorterDuff.Mode.SRC_IN);

        listView = (ListView) view.findViewById(R.id.listView);
        registerForContextMenu(listView);

        return view;

    }
}