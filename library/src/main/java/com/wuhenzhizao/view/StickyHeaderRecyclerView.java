package com.wuhenzhizao.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wuhenzhizao.adapter.StickyHeaderRecyclerViewAdapter;
import com.wuhenzhizao.api.OnItemHeaderClickListener;

/**
 * Created by wuhenzhizao on 2017/3/16.
 */
public class StickyHeaderRecyclerView extends BaseRecyclerView<StickyHeaderRecyclerViewAdapter> implements StickyHeaderTouchListener.OnHeaderClickListener {
    private StickyRecyclerHeadersDecoration decoration;
    private OnItemHeaderClickListener listener;

    public StickyHeaderRecyclerView(Context context) {
        super(context);
    }

    public StickyHeaderRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StickyHeaderRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setHeaderClickListener(OnItemHeaderClickListener listener) {
        this.listener = listener;
    }

    @Override
    protected void initSettings() {
        adapter = new StickyHeaderRecyclerViewAdapter(getContext());
        adapter.setLooped(isLooped);
        decoration = new StickyRecyclerHeadersDecoration(adapter);
        addItemDecoration(decoration);

        StickyHeaderTouchListener touchListener = new StickyHeaderTouchListener(this, decoration);
        touchListener.setOnHeaderClickListener(this);
        addOnItemTouchListener(touchListener);
    }

    @Override
    public void onHeaderClick(View headerView, View clickView, int position, long headerId) {
        if (listener != null) {
            listener.onHeaderClick(position, headerId);
        }
    }
}
