package com.example.zhou.job4.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.zhou.job4.R;
import com.example.zhou.job4.model.ILottery;
import com.example.zhou.job4.ui.base.presenter.BasePresenter;
import com.example.zhou.job4.ui.base.view.BaseView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public abstract class BaseActivity<T extends ILottery, K extends BasePresenter> extends AppCompatActivity implements BaseView<T> {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    K presenter;

    @Override
    public void fail() {

    }

    @Override
    public void update(List<T> list) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        initIntent();

        initPresenter();
        iniView();

    }

    protected abstract void initIntent();

    protected abstract void initPresenter();

    protected abstract void iniView();

    protected abstract int getLayoutResId();

    public String getResString(int resId) {
        return getResources().getString(resId);
    }

    public String getResString(int resId, Object... args) {
        return getResources().getString(resId, args);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.destory();
        }
    }
}
