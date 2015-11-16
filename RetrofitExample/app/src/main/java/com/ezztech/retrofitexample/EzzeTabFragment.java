package com.ezztech.retrofitexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tabs.EzzePagerAdapter;
import tabs.EzzeTabLayout;
import tabs.SlidingTabLayout;

/**
 * Created by Kofil on 9/20/15.
 */
public class EzzeTabFragment extends Fragment {

    private ViewPager mTabPager;

    public EzzeTabFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_fragment, container, false);
        EzzePagerAdapter adapter = new EzzePagerAdapter(getFragmentManager());
        mTabPager = (ViewPager) root.findViewById(R.id.pager);
        mTabPager.setAdapter(adapter);
        if (savedInstanceState == null) {
            mTabPager.setCurrentItem(0, true);
        }
        final EzzeTabLayout mSlidingTabs = (EzzeTabLayout) getActivity().findViewById(R.id.navigation_tabs);
        mSlidingTabs.setViewPager(mTabPager);
        mSlidingTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            public int getIndicatorColor(int position) {
                return getActivity().getResources().getColor(android.R.color.white);
            }

            public int getDividerColor(int position) {
                return 0;
            }
        });
        mSlidingTabs.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
        });
        return root;
    }
}
