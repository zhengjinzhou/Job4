package com.example.zhou.job4.ui.base.view;

import com.example.zhou.job4.model.ILottery;

import java.util.List;

public interface BaseView<T extends ILottery> {
    public void showDialog();

    public void dismissDialog();

    public void update(List<T> list);
    public void fail();
}

