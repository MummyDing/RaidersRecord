package com.github.mummyding.raidersrecord.support;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.mummyding.raidersrecord.ui.BaseListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MummyDing on 16-3-16.
 * GitHub: https://github.com/MummyDing
 * Blog: http://blog.csdn.net/mummyding
 */
public class PagerAdapterWrapper {

    private FragmentManager fragmentManager;
    private List<BaseListFragment> fragments;

    public PagerAdapterWrapper(FragmentManager fragmentManager, List<BaseListFragment> fragments) {
        this.fragmentManager = fragmentManager;
        this.fragments = fragments;
    }

    public PagerAdapterWrapper(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        fragments = new ArrayList<>();
    }

    public PagerAdapterWrapper addFragments(BaseListFragment... fragments){
        if (fragments == null || fragments.length <= 0 ){
            throw new IllegalArgumentException("args must not be null!!!");
        }
        for (BaseListFragment fragment:fragments){
            this.fragments.add(fragment);
        }
        return this;
    }


    public PagerAdapter build(){
        PagerAdapter pagerAdapter = new PagerAdapter(fragmentManager,fragments);
        return pagerAdapter;
    }

    /**
     * clear fragments
     */
    public void clear(){
        fragments.clear();
    }




    /***
     * We'd better　declare it to static
     * tips:A static nested class does not have a reference to a nesting instance -- By MummyDing
     */
    static class PagerAdapter extends FragmentStatePagerAdapter {
        List<BaseListFragment> listFragments;
        public PagerAdapter(FragmentManager fm, List<BaseListFragment> listFragments) {
            super(fm);

            if (listFragments == null || listFragments.size() <=0){
                throw new IllegalArgumentException("listFragments must not be null!!!");
            }
            this.listFragments = listFragments;
        }

        @Override
        public Fragment getItem(int position) {
            return listFragments.get(position);
        }

        @Override
        public int getCount() {
            return listFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return listFragments.get(position).getTitle();
        }
    }

}
