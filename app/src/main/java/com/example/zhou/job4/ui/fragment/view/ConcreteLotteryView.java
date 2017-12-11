package com.example.zhou.job4.ui.fragment.view;

import com.example.zhou.job4.ui.base.view.BaseView;

import java.util.List;


/**
 * Created by junbo on 7/11/2016.
 */

public interface ConcreteLotteryView<K> extends BaseView {
    public void update(List<K> list, boolean isAdd);
}
