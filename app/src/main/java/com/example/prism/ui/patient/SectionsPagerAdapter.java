package com.example.prism.ui.patient;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.prism.R;
import com.example.prism.model.Routine;
import com.example.prism.model.Routines;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    Routines routines;

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm, Routines routines) {
        super(fm);
        mContext = context;
        this.routines = routines;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PhysicalTreatmentFragment.newInstance(routines);
            case 1:
                return PatientNotificationsFragment.newInstance("asd","asddd");
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}