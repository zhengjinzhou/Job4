package com.example.zhou.job4.ui.fragment.view;

import com.example.zhou.job4.model.News;
import com.example.zhou.job4.ui.base.view.BaseView;

import java.util.List;


/**
 * Created by junbo on 14/11/2016.
 */

public interface NewsView<T extends News> extends BaseView {
    public void update(List<T> list, boolean isAdd);
}
