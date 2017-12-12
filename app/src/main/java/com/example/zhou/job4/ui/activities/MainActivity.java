package com.example.zhou.job4.ui.activities;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.zhou.job4.R;
import com.example.zhou.job4.listener.OnTagChangedListener;
import com.example.zhou.job4.ui.fragment.NavFragment;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements OnTagChangedListener {

    @BindView(R.id.content)
    FrameLayout frameLayout;

    NavFragment fragment;
    //记录用户首次点击返回键的时间
    private long firstTime = 0;
    //双击退出函数
    private static Boolean isExit = false;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initIntent() {

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void iniView() {
        fragment = (NavFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        fragment.setOnTagChangedListener(this);
        fragment.setUp(this, getSupportFragmentManager(), R.id.content);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(String title) {
        toolbar.setTitle(title);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            Toast.makeText(getApplicationContext(),"再按一次退出程序",Toast.LENGTH_SHORT).show();
            firstTime = secondTime;
        } else {
            finish();
        }
        return false;
    }
}
