package com.example.cheffy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabLayout;


public class TabFragment extends Fragment {

    public static TabLayout tabLayout;
    public static int tab_items = 3 ;

    //Tab Icons
    private int[] t_icons = {
            R.drawable.ic_home_white_48dp,
            R.drawable.ic_devices_white_48dp,
            R.drawable.ic_comment_white_48dp};
    //End Tab Icons


//

//

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

            View view =  inflater.inflate(R.layout.tab_layout,null);
            tabLayout = (TabLayout) view.findViewById(R.id.tablayout);

//


//

        //new

        //new end



        //

        //

        return view;

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(t_icons[0]);
        tabLayout.getTabAt(1).setIcon(t_icons[1]);
        tabLayout.getTabAt(2).setIcon(t_icons[2]);

    }

    /*public  String setupTabTags()
    {
        int item = viewPager.getCurrentItem();
        String tag = "";
        if(item == 0)
        {
            tag = "HomeFragmentTag";
        }
        else if(item == 1)
        {
            tag = "DevicesFragmentTag";
        }
        else if(item == 1)
        {
            tag = "HistoryFragmentTag";
        }
        return tag;
    }*/


    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }


        //
        /*private String makeFragmentName(long viewPager, int position)
        {
            return "android:switcher:" + viewPager + ":" + position;
        }*/

        //

        @Override
        public Fragment getItem(int position)
        {
          switch (position){
              case 0 : return new HomeFragment();
              case 1 : return new DevicesFragment();
              case 2 : return new HistoryFragment();
          }
        return null;
        }

        @Override
        public int getCount() {

            return tab_items;

        }

        @Override
        public CharSequence getPageTitle(int position)
        {
                return null;
        }
    }

}
