package com.example.zhou.job4.ui.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Switch;
import android.widget.TextView;

import com.example.zhou.job4.R;
import com.example.zhou.job4.action.IAction;
import com.example.zhou.job4.ui.activities.AboutActivity;
import com.example.zhou.job4.ui.activities.RuleActivity;
import com.example.zhou.job4.ui.fragment.base.BaseFragment;
import com.example.zhou.job4.ui.fragment.presenter.MePresenter;
import com.example.zhou.job4.ui.fragment.presenter.MePresenterImpl;
import com.example.zhou.job4.ui.fragment.view.MeView;
import com.example.zhou.job4.utils.Constants;
import com.example.zhou.job4.utils.LotteryUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MeFragment extends BaseFragment<MePresenter> implements MeView {
    private AlertDialog ad;
    @BindView(R.id.switch_wifi)
    Switch wifi;
    @BindView(R.id.checkVersion)
    TextView checkVersion;
    @BindView(R.id.about)
    TextView about;
    @BindView(R.id.lotteryRule)
    TextView rule;


    @Override
    protected void initView() {
        boolean savedWifi = LotteryUtils.getBooleanFromSharePreferences(getActivity(), Constants.Setting.WIFI_KEY, false);
        wifi.setChecked(savedWifi);
    }

    @OnClick(R.id.switch_wifi)
    public void onSwitch() {
        LotteryUtils.saveBooleanToSharePreferences(getActivity(), Constants.Setting.WIFI_KEY, wifi.isChecked());
    }

    @OnClick(R.id.checkVersion)
    public void checkVersion() {
        presenter.checkVersion();
    }

    @OnClick(R.id.about)
    public void about() {
        startActivity(new Intent(getActivity(), AboutActivity.class));
    }

    @OnClick(R.id.lotteryRule)
    public void rule() {
        startActivity(new Intent(getActivity(), RuleActivity.class));
    }

    @Override
    protected MePresenter getPresenter() {
        return new MePresenterImpl();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_me;
    }

    @Override
    public String getTitle() {
        return "设置";
    }


    private void showDialog(final String url) {
        showDialog("检查新版本", "检查到新版本，是否更新？", new IAction() {
            @Override
            public void doAction(Context context) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                context.startActivity(intent);
            }
        }, new IAction() {
            @Override
            public void doAction(Context context) {
                dismissDialog();
            }
        });

    }

    @Override
    public void newVersion(String url) {
        showToast("没有检测到最新版本！");
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void update(List list) {
        super.update(null);
    }

    @Override
    public void fail() {

    }
}
