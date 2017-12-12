package com.example.zhou.job4.ui.fragment.presenter;


import com.example.zhou.job4.data.LotteryServiceManager;
import com.example.zhou.job4.model.Lottery;
import com.example.zhou.job4.ui.base.presenter.BaseFailPresenterImpl;
import com.example.zhou.job4.ui.fragment.view.MainView;

import java.util.List;

import rx.Subscriber;


public class MainPresenterImpl extends BaseFailPresenterImpl<MainView> implements MainPresenter<MainView> {

    @Override
    public void refresh() {
        fetchData();
    }

    @Override
    public void start() {
        fetchData();
    }
    private void fetchData(){
        view.showProgress();
        LotteryServiceManager.getInstance().getLastData360(new Subscriber<List<Lottery.IEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.fail();
                view.dismissProgress();
            }

            @Override
            public void onNext(List<Lottery.IEntity> list) {
                view.dismissProgress();
                view.update(list);
            }
        });
    }
}
