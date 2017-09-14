package com.wuhenzhizao.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by liufei on 2017/9/14.
 */
public interface StickyHeaderAdapter<T extends RecyclerView.ViewHolder> {

    long getHeaderId(int position);


    T onCreateHeaderViewHolder(ViewGroup parent, int position);


    void onBindHeaderViewHolder(T viewholder, int position);
}
