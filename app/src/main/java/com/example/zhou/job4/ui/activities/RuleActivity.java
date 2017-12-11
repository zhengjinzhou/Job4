package com.example.zhou.job4.ui.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.zhou.job4.R;
import com.example.zhou.job4.model.Rule;
import com.example.zhou.job4.ui.activities.adapter.RuleAdapter;
import com.example.zhou.job4.ui.activities.presenter.RulePresenter;
import com.example.zhou.job4.ui.activities.presenter.RulePresenterImpl;
import com.example.zhou.job4.ui.activities.view.RuleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by junbo on 15/11/2016.
 */

public class RuleActivity extends BaseActivity<Rule, RulePresenter> implements RuleView {
    @BindView(R.id.listView)
    ListView listView;
    RuleAdapter adapter;
    List<Rule> data = new ArrayList<>();
    RulePresenter presenter;

    @Override
    protected void initIntent() {

    }

    void show(Rule rule) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(rule.getName()).setMessage(rule.getContent())
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                }).create();
        dialog.show();
    }

    @Override
    protected void initPresenter() {
        presenter = new RulePresenterImpl();
        presenter.attach(this);

    }

    @Override
    protected void iniView() {
        adapter = new RuleAdapter(data, this);
        listView.setAdapter(adapter);
        toolbar.setTitle("开奖规则");
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RuleActivity.this.finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
        presenter.loadRule(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                show(data.get(position));
            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_rule;
    }

    @Override
    public void update(List data) {
       // MLog.i("update");
        Log.d("", "update: ");
        this.data.clear();
        this.data.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
}
