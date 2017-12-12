package com.example.zhou.job4.ui.activities.presenter;

import android.util.Log;

import com.example.zhou.job4.data.LotteryServiceManager;
import com.example.zhou.job4.model.LotteryDetail;
import com.example.zhou.job4.ui.activities.view.ILotteryDetailView;
import com.example.zhou.job4.ui.base.presenter.BasePresenterImpl;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.functions.Func1;

public class LotteryDetailPresenterImpl<T extends ILotteryDetailView> extends BasePresenterImpl<ILotteryDetailView> implements LotteryDetailPresenter<ILotteryDetailView> {
    String lotId;
    String issue;

    @Override
    public void start() {
        super.start();
        fetchData();
    }

    void fetchData() {
        LotteryServiceManager.getInstance().getLotteryDetail(lotId, issue)
                .map(new Func1<LotteryDetail, List<LotteryDetail>>() {
                    @Override
                    public List<LotteryDetail> call(LotteryDetail lotteryDetail) {
                        List list = new ArrayList();
                        list.add(lotteryDetail);
                        return list;
                    }
                }).subscribe(new Subscriber<List<LotteryDetail>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<LotteryDetail> lotteryDetails) {
                view.update(lotteryDetails);
            }
        });
    }

    @Override
    public void setIssueAndName(String issue, String name) {
       // MLog.i("====" + issue + name);
        Log.d("", "setIssueAndName: "+name);
        this.issue = issue;
        lotId = name;
    }
}
