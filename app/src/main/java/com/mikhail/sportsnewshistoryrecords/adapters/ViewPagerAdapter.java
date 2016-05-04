package com.mikhail.sportsnewshistoryrecords.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;

import com.mikhail.sportsnewshistoryrecords.MainActivity;
import com.mikhail.sportsnewshistoryrecords.R;
import com.mikhail.sportsnewshistoryrecords.fragments.HistoryFragment;
import com.mikhail.sportsnewshistoryrecords.fragments.LeaguesFragment;
import com.mikhail.sportsnewshistoryrecords.fragments.NewsDetailsFragment;
import com.mikhail.sportsnewshistoryrecords.fragments.RecordsFragment;

/**
 * Created by Mikhail on 4/29/16.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter{

    int fragmentType;
    int mNumOfTabs;



    public ViewPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    public void setFragmentType(int fragmentType) {
        this.fragmentType = fragmentType;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                LeaguesFragment tab1 = new LeaguesFragment();
                tab1.setFragmentType(fragmentType);

                Log.d("MainActivity", "in Tab 1");
                fragment = tab1;
                break;
            case 1:
                HistoryFragment tab2 = new HistoryFragment();


                Log.d("MainActivity", "in Tab 2");
                fragment = tab2;
                break;
            case 2:
                RecordsFragment tab3 = new RecordsFragment();
                fragment = tab3;
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
