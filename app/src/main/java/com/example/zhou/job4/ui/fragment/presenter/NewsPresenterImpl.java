package com.example.zhou.job4.ui.fragment.presenter;

import android.util.Log;

import com.example.zhou.job4.data.NewsServiceManager;
import com.example.zhou.job4.model.News;
import com.example.zhou.job4.ui.base.presenter.BaseFailPresenterImpl;
import com.example.zhou.job4.ui.fragment.view.NewsView;
import com.example.zhou.job4.utils.Constants;

import java.util.List;
import java.util.Map;

import rx.Subscriber;

/**
 * Created by junbo on 14/11/2016.
 */

public class NewsPresenterImpl extends BaseFailPresenterImpl<NewsView> implements NewsPresenter<NewsView> {
    int page = 0;
    int pageSize = 20;

    @Override
    public void loadMore() {
        load();
    }

    private void load() {
        NewsServiceManager.getInstance()
                .getNews("", Constants.HEADLINE_TYPE, Constants.LOTTERY_ID, getPage())
                .subscribe(new Subscriber<Map<String, List<News>>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("", "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.fail();
                        Log.d("", "onError: "+e.getMessage());
                    }

                    @Override
                    public void onNext(Map<String, List<News>> stringListMap) {
                       // MLog.i("onNext"+stringListMap);
                        Log.d("", "onNext: "+stringListMap);
                        if (view != null) {
                            view.update(stringListMap.get(Constants.LOTTERY_ID), page > 0);
                        }
                        page++;
                    }
                });
    }

    private int getPage() {
        return page * pageSize;
    }

    @Override
    public void refresh() {
        page = 0;
        load();
    }


    @Override
    public void start() {
        load();
    }
}
