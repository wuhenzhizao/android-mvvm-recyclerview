package com.wuhenzhizao.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;

import com.wuhenzhizao.adapter.DragRecyclerViewAdapter;
import com.wuhenzhizao.api.OnItemDragListener;

/**
 * Created by wuhenzhizao on 2017/9/12.
 */
public class DragRecyclerView extends BaseRecyclerView<DragRecyclerViewAdapter> implements OnItemDragListener {
    private OnItemDragListener dragListener;

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

    public void setDragListener(OnItemDragListener dragListener) {
        this.dragListener = dragListener;
    }

    @Override
    public void onDrag(int fromPosition, int toPosition) {
        // 更新数据
        adapter.onItemMoved(fromPosition, toPosition);
        if (dragListener != null) {
            dragListener.onDrag(fromPosition, toPosition);
        }
    }

    private class ItemTouchHelperCallBack extends ItemTouchHelper.Callback {
        private OnItemDragListener callBack;

        public ItemTouchHelperCallBack(OnItemDragListener callBack) {
            this.callBack = callBack;
        }

        @Override
        public boolean isLongPressDragEnabled() {
            return true;
        }

        @Override
        public boolean isItemViewSwipeEnabled() {
            return false;
        }

        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            int swipeFlag = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
            return makeMovementFlags(dragFlag, swipeFlag);
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            if (viewHolder.getItemViewType() != target.getItemViewType()) {
                return false;
            }
            callBack.onDrag(viewHolder.getAdapterPosition(), target.getAdapterPosition());
            return true;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        }
    }

}
