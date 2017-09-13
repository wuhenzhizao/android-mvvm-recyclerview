package com.wuhenzhizao.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
import com.wuhenzhizao.adapter.StickyHeaderRecyclerViewAdapter;

/**
 * Created by wuhenzhizao on 2017/3/16.
 */
public class StickyHeaderRecyclerView extends DataBindingRecyclerView<StickyHeaderRecyclerViewAdapter> {

    public StickyHeaderRecyclerView(Context context) {
        super(context);
    }

    public StickyHeaderRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StickyHeaderRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void initSettings() {
        adapter = new StickyHeaderRecyclerViewAdapter(getContext());
        adapter.setLooped(isLooped);
        ItemDecoration decoration = new StickyRecyclerHeadersDecoration(adapter);
        addItemDecoration(decoration);
    }
}
