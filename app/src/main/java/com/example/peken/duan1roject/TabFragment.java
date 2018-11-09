package com.example.peken.duan1roject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFragment  extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3 ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View x=inflater.inflate(R.layout.tab_layout,null);
        tabLayout=(TabLayout)x.findViewById(R.id.tabs);
        viewPager=(ViewPager)x.findViewById(R.id.viewpager);

        /* Set adapter cho viewpager  */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return x;

    }
}

class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position)
    {
        switch (position){
            case 0 : return new HomeFragment();
            case 1 : return new TheLoaiFragment();
            case 2 : return new DonHangFragment();
        }
        return null;
    }
    @Override
    public int getCount() {
        int int_items=3;
        return int_items;
    }
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0 :
                return "Trang chủ";
            case 1 :
                return "Thể loại";
            case 2 :
                return "Đơn hàng";
        }
        return null;
    }
}

