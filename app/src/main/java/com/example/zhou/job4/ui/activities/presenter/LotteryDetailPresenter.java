package com.example.zhou.job4.ui.activities.presenter;


import com.example.zhou.job4.ui.activities.view.ILotteryDetailView;
import com.example.zhou.job4.ui.base.presenter.BasePresenter;

/**
 * Created by junbo on 3/11/2016.
 */

public interface LotteryDetailPresenter<T extends ILotteryDetailView> extends BasePresenter<T> {
    void setIssueAndName(String issue, String name);
}
