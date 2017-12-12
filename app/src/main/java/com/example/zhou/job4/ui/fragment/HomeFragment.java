package com.example.zhou.job4.ui.fragment;

import android.view.View;

import com.example.zhou.job4.App;
import com.example.zhou.job4.R;
import com.example.zhou.job4.ui.fragment.base.BaseFailFragment;
import com.example.zhou.job4.ui.fragment.listener.OnItemClickListener;
import com.example.zhou.job4.ui.fragment.presenter.MainPresenter;
import com.example.zhou.job4.ui.fragment.view.MainView;

/**
 * Created by zhou on 2017/12/12.
 */

public class HomeFragment extends BaseFailFragment<MainPresenter> implements MainView, OnItemClickListener {

    public static HomeFragment getInstance() {

        return new HomeFragment();
    }

    @Override
    public void onItemClick(View view, long position) {

    }

    @Override
    public void onFooterClick(View v, int layoutPosition) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    protected MainPresenter getPresenter() {
        return null;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    public String getTitle() {
        return App.getAppContext().getString(R.string.last_home);
    }

    @Override
    protected void onDataRefresh() {
        presenter.refresh();
    }
}
