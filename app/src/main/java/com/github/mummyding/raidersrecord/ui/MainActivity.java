package com.github.mummyding.raidersrecord.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.github.mummyding.raidersrecord.R;
import com.github.mummyding.raidersrecord.support.adapter.PagerAdapterWrapper;
import com.github.mummyding.raidersrecord.ui.fragment.LuckFragment;
import com.github.mummyding.raidersrecord.ui.fragment.RaiderFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("我的夺宝");
        /**
         * if this is a sub Activity ,you can add these code(it will display a back arrow)
         */
        /*getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });*/
        PagerAdapterWrapper pagerAdapterWrapper = new PagerAdapterWrapper(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapterWrapper.addFragments(new LuckFragment(),new RaiderFragment()).build());
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
    }
}
