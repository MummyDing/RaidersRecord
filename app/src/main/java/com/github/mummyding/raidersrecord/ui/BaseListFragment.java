package com.github.mummyding.raidersrecord.ui;

import android.support.v4.app.Fragment;

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
}
