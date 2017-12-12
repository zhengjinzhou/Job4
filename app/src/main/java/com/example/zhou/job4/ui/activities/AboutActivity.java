package com.example.zhou.job4.ui.activities;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;

import com.example.zhou.job4.R;
import com.example.zhou.job4.ui.activities.presenter.AboutPresenterImpl;
import com.example.zhou.job4.ui.activities.view.AboutView;

import butterknife.BindView;

public class AboutActivity extends BaseActivity implements AboutView {

    @Override
    protected void initIntent() {

    }

    @Override
    protected void initPresenter() {
        presenter = new AboutPresenterImpl<>();
    }

    @Override
    protected void iniView() {
        toolbar.setTitle("关于");
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            finish();
            overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
        }
        return super.onKeyUp(keyCode, event);
    }
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_about;
    }

    @Override
    public void update(String data) {
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {

    }
}
