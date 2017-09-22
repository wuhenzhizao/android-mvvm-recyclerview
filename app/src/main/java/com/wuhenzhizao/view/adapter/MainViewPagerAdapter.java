package com.wuhenzhizao.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import com.gomeos.mvvm.view.ui.BaseFragment;
import com.wuhenzhizao.R;
import com.wuhenzhizao.view.ui.MainDragFragment;
import com.wuhenzhizao.view.ui.MainIndexableFragment;
import com.wuhenzhizao.view.ui.MainStickyFragment;
import com.wuhenzhizao.view.ui.MainSwipeFragment;


/**
 * Created by wuhenzhizao on 2016/10/25.
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private String[] titles;
    private SparseArray<BaseFragment> fragmentArray;

    public MainViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        titles = context.getResources().getStringArray(R.array.titles);
        fragmentArray = new SparseArray<>(titles.length);
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = fragmentArray.get(position);
        if (position == 0 && fragment == null) {
            fragment = new MainStickyFragment();
            fragmentArray.put(position, fragment);
        } else if (position == 1) {
            fragment = new MainSwipeFragment();
            fragmentArray.put(position, fragment);
        } else if (position == 2) {
            fragment = new MainDragFragment();
            fragmentArray.put(position, fragment);
        } else if (position == 3) {
            fragment = new MainIndexableFragment();
            fragmentArray.put(position, fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
