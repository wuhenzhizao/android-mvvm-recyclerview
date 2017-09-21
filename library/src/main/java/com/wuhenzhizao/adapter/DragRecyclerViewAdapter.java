package com.wuhenzhizao.adapter;

import android.content.Context;

import com.wuhenzhizao.factory.AbsViewFactory;

import java.util.Collections;

/**
 * Created by wuhenzhizao on 2017/9/12.
 */

public class DragRecyclerViewAdapter extends ViewModelRecyclerViewAdapter<AbsViewFactory> {

    public DragRecyclerViewAdapter(Context context) {
        super(context);
    }

    public void onItemMoved(int fromPosition, int toPosition) {
        Collections.swap(getItems(), fromPosition, toPosition);
        super.notifyItemMoved(fromPosition, toPosition);
    }
}
