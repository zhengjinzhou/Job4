package com.example.zhou.job4.ui.base.presenter;


import com.example.zhou.job4.ui.base.view.BaseView;

/**
 * Created by junbo on 17/11/2016.
 */

public interface BaseFailPresenter<T extends BaseView> extends BasePresenter<T> {

    public void retry();
}
