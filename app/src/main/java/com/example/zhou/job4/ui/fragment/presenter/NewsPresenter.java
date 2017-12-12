package com.example.zhou.job4.ui.fragment.presenter;


import com.example.zhou.job4.ui.base.presenter.BaseFailPresenter;
import com.example.zhou.job4.ui.fragment.view.NewsView;


public interface NewsPresenter<T extends NewsView> extends BaseFailPresenter<T> {
    public void loadMore();
    public void refresh();
}
