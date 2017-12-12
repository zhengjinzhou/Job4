package com.example.zhou.job4.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.zhou.job4.R;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private ViewPager viewPager;
    private List<View> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sp = getSharedPreferences("config", Context.MODE_PRIVATE);
        boolean first = sp.getBoolean("FIRST", false);
        Log.d("", "onCreate: " + first);
        if (first) {
            startActivity(new Intent(getApplicationContext(), SplashActivity.class));
            finish();
        } else {
            initViewpager();
        }
    }

    private void initViewpager() {
        viewPager = findViewById(R.id.viewPager);
        list = new ArrayList<>();
        View view1 = getLayoutInflater().inflate(R.layout.layout1, null);
        View view2 = getLayoutInflater().inflate(R.layout.layout2, null);
        View view3 = getLayoutInflater().inflate(R.layout.layout3, null);
        view3.findViewById(R.id.bt_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SplashActivity.class));
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("FIRST",true);
                edit.commit();
                finish();
            }
        });
        list.add(view1);
        list.add(view2);
        list.add(view3);

        viewPager.setAdapter(new MyPagerAdapter());
    }

    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }
    }
}
