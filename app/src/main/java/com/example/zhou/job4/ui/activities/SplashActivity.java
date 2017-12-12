package com.example.zhou.job4.ui.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.zhou.job4.Constant;
import com.example.zhou.job4.R;
import com.example.zhou.job4.bean.JobBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SplashActivity extends AppCompatActivity {


    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initNet();
            }
        }, 100);
        //联网 判断跳到哪里
    }

    private void initNet() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(Constant.URL_MAIN).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),"请确保您的应用已经联网",Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onFailure: ");
                        finish();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.d(TAG, "onResponse: " + string);
                Gson gson = new Gson();
                JobBean jobBean = gson.fromJson(string, JobBean.class);
                if (jobBean.getData().getShow_url().equals("1")) {
                    Intent intent = new Intent(getApplicationContext(), WebActivity.class);
                    intent.putExtra("url_main", jobBean.getData().getUrl());
                    startActivity(intent);
                    finish();
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });
    }
}
