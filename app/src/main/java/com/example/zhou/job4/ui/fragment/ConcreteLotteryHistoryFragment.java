package com.example.zhou.job4.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.zhou.job4.R;
import com.example.zhou.job4.model.LotteryHistory;
import com.example.zhou.job4.ui.activities.LotteryDetailActivity;
import com.example.zhou.job4.ui.fragment.adapter.HistoryFragmentAdapter;
import com.example.zhou.job4.ui.fragment.base.BaseFailFragment;
import com.example.zhou.job4.ui.fragment.listener.OnItemClickListener;
import com.example.zhou.job4.ui.fragment.presenter.ConcreteLotteryHistoryPresenter;
import com.example.zhou.job4.ui.fragment.presenter.ConcreteLotteryHistoryPresenterImpl;
import com.example.zhou.job4.ui.fragment.view.ConcreteLotteryView;
import com.example.zhou.job4.ui.fragment.view.DividerDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class ConcreteLotteryHistoryFragment extends BaseFailFragment<ConcreteLotteryHistoryPresenter> implements ConcreteLotteryView<LotteryHistory.ListEntity>, OnItemClickListener {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    List<LotteryHistory.ListEntity> data;
    HistoryFragmentAdapter adapter;

    @Override
    protected void initView() {
        super.initView();
        if (data == null) data = new ArrayList<>();
        adapter = new HistoryFragmentAdapter(data, getActivity());
        adapter.setFooter(true);
        adapter.setId(issueId);
        adapter.setOnItemClickListener(this);
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
    protected ConcreteLotteryHistoryPresenter getPresenter() {
        return new ConcreteLotteryHistoryPresenterImpl(issueId);

    }

    String issueId;
    String name;


    public void setName(String name) {
        this.name = name;
    }


    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public static ConcreteLotteryHistoryFragment getInstance(String issueId, String name) {
        ConcreteLotteryHistoryFragment fragment = new ConcreteLotteryHistoryFragment();
        fragment.setIssueId(issueId);
        fragment.setName(name);
        Bundle bundle = new Bundle();
        bundle.putString("issueId", issueId);
        bundle.putString("name", name);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            setIssueId(bundle.getString("issueId"));
            setName(bundle.getString("name"));
        }
    }


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_concrrete_history;
    }

    @Override
    public String getTitle() {
        return name;
    }


    @Override
    public void onItemClick(View view, long position) {
        LotteryHistory.ListEntity entity = data.get((int) position);
        startDetailActivity(entity);
    }


    private void startDetailActivity(LotteryHistory.ListEntity entity) {
        Intent intent = new Intent(getActivity(), LotteryDetailActivity.class);
        Bundle b = new Bundle();
        b.putString("issue", entity.getIssue());
        b.putString("lotId", issueId);
        intent.putExtras(b);
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    @Override
    public void onFooterClick(View v, int layoutPosition) {
        presenter.loadMore();

    }

    @Override
    public void update(List<LotteryHistory.ListEntity> list, boolean isAdd) {
        super.update(list);
        adapter.setFlushing(false);
        if (!isAdd) {
            data.clear();
        }
        Log.d("", "update: "+list.size());

        if (list == null || list != null && list.size() == 0) {
            adapter.onEnd(true);
        } else {
            adapter.onEnd(false);
            data.addAll(list);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void update(List list) {

    }
}
