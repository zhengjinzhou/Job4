package com.example.zhou.job4.ui.fragment.presenter;


import com.example.zhou.job4.ui.base.presenter.BaseFailPresenter;
import com.example.zhou.job4.ui.fragment.view.ConcreteLotteryView;

/**
 * Created by junbo on 7/11/2016.
 */

public interface ConcreteLotteryHistoryPresenter<T extends ConcreteLotteryView> extends BaseFailPresenter<T> {
    public void refresh();
    public void loadMore();
}
