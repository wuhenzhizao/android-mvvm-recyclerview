package com.wuhenzhizao.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;

import com.wuhenzhizao.adapter.DragRecyclerViewAdapter;
import com.wuhenzhizao.callback.ItemDragCallBack;

/**
 * Created by wuhenzhizao on 2017/9/12.
 */
public class DragRecyclerView extends DataBindingRecyclerView<DragRecyclerViewAdapter> implements ItemDragCallBack {
    private ItemDragCallBack callback;

    public DragRecyclerView(Context context) {
        super(context);
    }

    public DragRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DragRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void initSettings() {
        adapter = new DragRecyclerViewAdapter(getContext());
        adapter.setLooped(isLooped);

        ItemTouchHelper.Callback callback = new ItemTouchHelperCallBack(this);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(this);
    }

    public void setCallback(ItemDragCallBack callback) {
        this.callback = callback;
    }

    @Override
    public void onDrag(int fromPosition, int toPosition) {
        // 更新数据
        adapter.onItemMoved(fromPosition, toPosition);
        if (callback != null) {
            callback.onDrag(fromPosition, toPosition);
        }
    }
}
