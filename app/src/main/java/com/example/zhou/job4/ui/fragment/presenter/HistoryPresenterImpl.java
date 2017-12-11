package com.example.zhou.job4.ui.fragment.presenter;

import com.example.zhou.job4.model.LotteryItem;
import com.example.zhou.job4.ui.base.presenter.BasePresenterImpl;
import com.example.zhou.job4.ui.fragment.view.HistoryView;
import com.example.zhou.job4.utils.LotteryUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by junbo on 7/11/2016.
 */

public class HistoryPresenterImpl extends BasePresenterImpl<HistoryView> implements HistoryPresenter<HistoryView> {

    @Override
    public void start() {
        fetchLotteries();
    }

    void fetchLotteries() {
        Observable.create(new Observable.OnSubscribe<Map>() {

            @Override
            public void call(Subscriber<? super Map> subscriber) {
                subscriber.onNext(LotteryUtils.getAllAvailable());
            }
        }).map(new Func1<Map, List>() {
            @Override
            public List call(Map map) {
                List result = new ArrayList();
                if (map != null && map.size() > 0) {
                    Iterator<String> iterator = map.keySet().iterator();
                    while (iterator.hasNext()) {
                        String name = iterator.next();
                        String id = (String) map.get(name);
                        result.add(new LotteryItem(id, name, true));
                    }
                }
                return result;
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List list) {
                        if (view != null) {
                            view.update(list);
                        }
                    }
                })
        ;


    }
}
