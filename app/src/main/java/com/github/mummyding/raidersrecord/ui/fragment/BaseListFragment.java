package com.github.mummyding.raidersrecord.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mummyding.raidersrecord.R;
import com.github.mummyding.raidersrecord.support.DataLoader;
import com.github.mummyding.raidersrecord.support.adapter.ListAdapter;

/**
 * Created by MummyDing on 16-3-16.
 * GitHub: https://github.com/MummyDing
 * Blog: http://blog.csdn.net/mummyding
 */
public abstract class BaseListFragment extends Fragment {
    /**
     * you must to implement it,this title will be regarded as tab title by default.
     * @return
     */
    public abstract String getTitle();


    private View parentView;
    private RecyclerView recyclerView;
    private ListAdapter adapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView =  inflater.inflate(R.layout.fragment_list, container, false);
        initView();
        return parentView;
    }

    private void initView(){
        recyclerView = (RecyclerView) parentView.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());
        adapter = new ListAdapter(DataLoader.load());
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);
    }
}
