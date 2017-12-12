package com.example.zhou.job4.ui.activities.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.example.zhou.job4.ui.base.adapter.BasePagerAdapter;
import com.example.zhou.job4.ui.fragment.base.BaseFragment;

import java.util.List;

public class HistoryAdapter extends BasePagerAdapter {
    public HistoryAdapter(FragmentManager fm, List<BaseFragment> fragmentList, Context context) {
        super(fm, fragmentList, context);
    }

    public HistoryAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm, fragmentList);
    }
}
