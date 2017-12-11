package com.example.zhou.job4.ui.activities;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;

import com.example.zhou.job4.R;
import com.example.zhou.job4.ui.activities.presenter.AboutPresenterImpl;
import com.example.zhou.job4.ui.activities.view.AboutView;

import butterknife.BindView;

/**
 * Created by junbo on 13/11/2016.
 */

public class AboutActivity extends BaseActivity implements AboutView {
    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void initIntent() {

    }

    @Override
    protected void initPresenter() {
        presenter = new AboutPresenterImpl<>();
    }

    @Override
    protected void iniView() {
        //webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/about.html");
        toolbar.setTitle(getString(R.string.about_titile));
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutActivity.this.finish();
            }
        });
       // setSupportActionBar(toolbar);

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
        webView.loadUrl(data);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {

    }
}
