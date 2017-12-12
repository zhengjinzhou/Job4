package com.example.zhou.job4.ui.fragment.presenter;


import com.example.zhou.job4.ui.base.presenter.BaseFailPresenter;
import com.example.zhou.job4.ui.fragment.view.ConcreteLotteryView;

public interface ConcreteLotteryHistoryPresenter<T extends ConcreteLotteryView> extends BaseFailPresenter<T> {
    public void refresh();
    public void loadMore();
}
