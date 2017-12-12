package com.example.zhou.job4.ui.fragment.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.example.zhou.job4.R;
import com.example.zhou.job4.model.Lottery;
import com.example.zhou.job4.ui.base.adapter.BaseRecyclerAdapter;
import com.example.zhou.job4.utils.LotteryUtils;
import com.example.zhou.job4.widget.KJLineItemView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragmentAdapter extends BaseRecyclerAdapter<Lottery.IEntity, MainFragmentAdapter.MainFragmentViewHolder> {


    public MainFragmentAdapter(List<Lottery.IEntity> list, Context context) {
        super(list, context);
    }


    @Override
    public MainFragmentViewHolder createVH(View v,int viewType) {

        return new MainFragmentViewHolder(v);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.last_num_item;
    }

    @Override
    public void bindVH(MainFragmentViewHolder holder, int position) {
        MainFragmentViewHolder vh =  holder;
        Lottery.IEntity o = list.get(position);
        vh.name.setText(o.getLotName());
        vh.phase.setText("第" + o.getIssue() + "期");
        vh.time.setText("开奖日期" + o.getDate());
        DisplayMetrics outMetrics = null;
        outMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        vh.ball.setWidthHeight(outMetrics.widthPixels, outMetrics.heightPixels);
        vh.ball.addViewList(LotteryUtils.getBall(o));


    }

    @Override
    public void bindFooterVH(MainFragmentViewHolder holder, int position) {

    }

    class MainFragmentViewHolder extends BaseRecyclerAdapter.BaseViewHoler {
        @BindView(R.id.text_name)
        TextView name;
        @BindView(R.id.text_phase)
        TextView phase;
        @BindView(R.id.text_timedraw)
        TextView time;
        @BindView(R.id.view_ball)
        KJLineItemView ball;

        public MainFragmentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
