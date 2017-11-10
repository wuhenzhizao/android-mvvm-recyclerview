package com.wuhenzhizao.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by wuhenzhizao on 2017/9/14.
 */
interface StickyHeaderAdapter<T extends RecyclerView.ViewHolder> {

    long getHeaderId(int position);


    T onCreateHeaderViewHolder(ViewGroup parent, int position);


    void onBindHeaderViewHolder(T viewHolder, int position);
}
