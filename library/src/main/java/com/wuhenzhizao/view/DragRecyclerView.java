package com.wuhenzhizao.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;

import com.wuhenzhizao.adapter.DragRecyclerViewAdapter;
import com.wuhenzhizao.callback.ItemTouchHelperCallBack;
import com.wuhenzhizao.callback.OnItemDragCallBack;

/**
 * Created by liufei on 2017/9/12.
 */

public class DragRecyclerView extends DataBindingRecyclerView<DragRecyclerViewAdapter> implements OnItemDragCallBack {

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

    @Override
    public void onDrag(int oldPositon, int newPosition) {
        // 更新数据
        items.add(newPosition, items.remove(oldPositon));
        adapter.notifyItemMoved(oldPositon, newPosition);
    }
}
