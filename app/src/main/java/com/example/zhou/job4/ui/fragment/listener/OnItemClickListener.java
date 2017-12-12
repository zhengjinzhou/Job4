package com.example.zhou.job4.ui.fragment.listener;

import android.view.View;

public interface OnItemClickListener {
    public void onItemClick(View view, long position);

    void onFooterClick(View v, int layoutPosition);
}
