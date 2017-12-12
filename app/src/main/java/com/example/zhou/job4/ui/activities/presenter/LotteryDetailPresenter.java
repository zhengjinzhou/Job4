package com.example.zhou.job4.ui.activities.presenter;


import com.example.zhou.job4.ui.activities.view.ILotteryDetailView;
import com.example.zhou.job4.ui.base.presenter.BasePresenter;

public interface LotteryDetailPresenter<T extends ILotteryDetailView> extends BasePresenter<T> {
    void setIssueAndName(String issue, String name);
}
