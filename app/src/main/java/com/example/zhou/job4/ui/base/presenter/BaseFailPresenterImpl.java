package com.example.zhou.job4.ui.base.presenter;


import com.example.zhou.job4.ui.base.view.BaseView;

/**
 * Created by junbo on 17/11/2016.
 */

public class BaseFailPresenterImpl<T extends BaseView> implements BaseFailPresenter<T> {
    public T view;

    @Override
    public void retry() {
        start();
    }

    @Override
    public void attach(T view) {
        this.view = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void destory() {

    }
}
