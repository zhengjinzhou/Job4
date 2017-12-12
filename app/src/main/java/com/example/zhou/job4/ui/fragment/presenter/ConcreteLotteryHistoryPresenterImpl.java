package com.example.zhou.job4.ui.fragment.presenter;


import android.util.Log;

import com.example.zhou.job4.data.LotteryServiceManager;
import com.example.zhou.job4.model.LotteryHistory;
import com.example.zhou.job4.ui.base.presenter.BaseFailPresenterImpl;
import com.example.zhou.job4.ui.fragment.view.ConcreteLotteryView;

import rx.Subscriber;

public class ConcreteLotteryHistoryPresenterImpl extends BaseFailPresenterImpl<ConcreteLotteryView> implements ConcreteLotteryHistoryPresenter<ConcreteLotteryView> {
    int currentPage=1;
    int pageCount=10;
    String lotId;

    public ConcreteLotteryHistoryPresenterImpl(String lotId) {
        this.lotId = lotId;
        //MLog.i("lotid="+lotId);
        Log.d("", "ConcreteLotteryHistoryPresenterImpl: "+"lotid="+lotId);
    }

    @Override
    public void start() {
        fetchData();
    }

    @Override
    public void refresh() {
        currentPage=1;
        fetchData();
    }

    @Override
    public void loadMore() {
        currentPage++;
        fetchData();
    }

    public void fetchData() {
        Log.d("", "fetchdata");

        LotteryServiceManager.getInstance().getHistory360(new Subscriber<LotteryHistory>() {
            @Override
            public void onCompleted() {
                Log.d("", "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("", "onError: "+e.getMessage());
                view.fail();

            }

            @Override
            public void onNext(LotteryHistory o) {
                Log.d("", "onNext: "+o.getList());
                pageCount = Integer.parseInt(o.getPageCount());
                Log.d("", "pc=" + pageCount);
                if (view != null) {
                    if (currentPage == 1) {
                        view.update(o.getList(), false);
                    } else {
                        view.update(o.getList(), true);
                    }
                }

            }
        }, lotId, currentPage + "");
    }


}
