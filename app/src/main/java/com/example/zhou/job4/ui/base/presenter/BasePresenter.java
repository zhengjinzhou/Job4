package com.example.zhou.job4.ui.base.presenter;


public interface BasePresenter<T> {
    public void attach(T view);

    public void start();

    public void destory();

}