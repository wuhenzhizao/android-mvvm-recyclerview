package com.wuhenzhizao.adapter;

import android.content.Context;

import java.util.Collections;

import com.wuhenzhizao.factory.AbsViewFactory;

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
