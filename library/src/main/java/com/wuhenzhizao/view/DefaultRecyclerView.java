package com.wuhenzhizao.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.wuhenzhizao.adapter.ViewModelRecyclerViewAdapter;

/**
 * Created by wuhenzhizao on 2017/9/21.
 */

public class DefaultRecyclerView extends BaseRecyclerView {

    public DefaultRecyclerView(Context context) {
        super(context);
    }

    public DefaultRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DefaultRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void initSettings() {
        adapter = new ViewModelRecyclerViewAdapter(getContext());
        adapter.setLooped(isLooped);
    }
}
