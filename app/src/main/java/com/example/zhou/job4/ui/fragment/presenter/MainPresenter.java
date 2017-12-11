package com.example.zhou.job4.ui.fragment.presenter;


import com.example.zhou.job4.ui.base.presenter.BaseFailPresenter;
import com.example.zhou.job4.ui.fragment.view.MainView;

/**
 * Created by junbo on 1/11/2016.
 */

public interface MainPresenter<T extends MainView> extends BaseFailPresenter<T> {
    public void refresh();
}
