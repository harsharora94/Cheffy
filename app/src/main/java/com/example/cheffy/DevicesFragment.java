package com.example.cheffy;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DevicesFragment extends Fragment {

    ListView listView;
    Button button2;
    LinearLayout dynamiclayout;
    SeekBar seekBar;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.devices_layout, container, false);

        button2 = (Button) view.findViewById(R.id.button2);

        dynamiclayout = (LinearLayout) view.findViewById(R.id.dynamiclayout);

        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.getIndeterminateDrawable().setColorFilter(new LightingColorFilter(0x004D40, 0x004D40));
        progressBar.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.whatsapp2), android.graphics.PorterDuff.Mode.SRC_IN);

        return view;
    }
}
