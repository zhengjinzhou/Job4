package com.example.zhou.job4.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.zhou.job4.App;
import com.example.zhou.job4.R;
import com.example.zhou.job4.model.Lottery;
import com.example.zhou.job4.ui.activities.LotteryDetailActivity;
import com.example.zhou.job4.ui.fragment.adapter.MainFragmentAdapter;
import com.example.zhou.job4.ui.fragment.base.BaseFailFragment;
import com.example.zhou.job4.ui.fragment.listener.OnItemClickListener;
import com.example.zhou.job4.ui.fragment.presenter.MainPresenter;
import com.example.zhou.job4.ui.fragment.presenter.MainPresenterImpl;
import com.example.zhou.job4.ui.fragment.view.DividerDecoration;
import com.example.zhou.job4.ui.fragment.view.MainView;
import com.example.zhou.job4.utils.LotteryUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainFragment extends BaseFailFragment<MainPresenter> implements MainView, OnItemClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    MainFragmentAdapter adapter;
    List<Lottery.IEntity> data;

    public static MainFragment getInstance() {

        return new MainFragment();
    }

    @Override
    protected void initView() {
        super.initView();
        if (data == null) data = new ArrayList<>();
        adapter = new MainFragmentAdapter(data, getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerDecoration(getActivity(), DividerDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(this);
    }

    @Override
    protected void onDataRefresh() {
        presenter.refresh();
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenterImpl();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_main;
    }

    @Override
    public String getTitle() {
        return App.getAppContext().getString(R.string.last_lottery);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void update(List list) {
        super.update(null);
        data.clear();
        data.addAll(list);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onItemClick(View view, long position) {
        Lottery.IEntity entity = data.get((int) position);
        startDetailActivity(entity);
    }

    @Override
    public void onFooterClick(View v, int layoutPosition) {

    }

    private void startDetailActivity(Lottery.IEntity entity) {
        Intent intent = new Intent(getActivity(), LotteryDetailActivity.class);
        Bundle b = new Bundle();
        //MLog.i("===+" + entity.getIssue() + ";" + LotteryUtils.getId(entity));
        b.putString("issue", entity.getIssue());
        b.putString("lotId", LotteryUtils.getId(entity));
        intent.putExtras(b);
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }
}
