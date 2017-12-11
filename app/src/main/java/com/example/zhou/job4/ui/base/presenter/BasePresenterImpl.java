package com.example.zhou.job4.ui.base.presenter;


import com.example.zhou.job4.ui.base.view.BaseView;

/**
 * Created by junbo on 16/11/2016.
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {
    public T view;

    @Override
    public void attach(T view) {
        this.view = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void destory() {
        view=null;
    }


}