package com.wuhenzhizao.adapter;

import android.content.Context;

import java.util.Collections;

/**
 * Created by liufei on 2017/9/12.
 */

public class DragRecyclerViewAdapter extends ViewModelRecyclerViewAdapter {

    public DragRecyclerViewAdapter(Context context) {
        super(context);
    }

    public void onItemMoved(int fromPosition, int toPosition) {
        Collections.swap(getItems(), fromPosition, toPosition);
        super.notifyItemMoved(fromPosition, toPosition);
    }
}
