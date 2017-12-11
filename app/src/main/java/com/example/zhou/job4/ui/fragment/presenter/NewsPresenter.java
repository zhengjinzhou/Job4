package com.example.zhou.job4.ui.fragment.presenter;


import com.example.zhou.job4.ui.base.presenter.BaseFailPresenter;
import com.example.zhou.job4.ui.fragment.view.NewsView;

/**
 * Created by junbo on 14/11/2016.
 */

public interface NewsPresenter<T extends NewsView> extends BaseFailPresenter<T> {
    public void loadMore();
    public void refresh();
}
