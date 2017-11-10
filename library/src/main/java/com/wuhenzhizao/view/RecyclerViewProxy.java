package com.wuhenzhizao.view;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wuhenzhizao.api.OnItemDragListener;
import com.wuhenzhizao.api.OnItemHeaderClickListener;
import com.wuhenzhizao.api.OnLoadMoreListener;
import com.wuhenzhizao.api.OnMultiChangedListener;
import com.wuhenzhizao.api.OnPullRefreshListener;
import com.wuhenzhizao.api.OnRefreshOrLoadMoreListener;

import java.lang.ref.WeakReference;

/**
 * Created by wuhenzhizao on 2017/9/21.
 */

public class RecyclerViewProxy {
    protected WeakReference<RecyclerView> recyclerViewRf;
    protected RecyclerView.ItemDecoration itemDecoration;
    protected RecyclerView.OnScrollListener scrollListener;

    public RecyclerView.ItemDecoration getItemDecoration() {
        return itemDecoration;
    }

    public void attach(RecyclerView recyclerView) {
        this.recyclerViewRf = new WeakReference<>(recyclerView);
    }

    public void setItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.itemDecoration = itemDecoration;
    }

    public RecyclerView.OnScrollListener getScrollListener() {
        return scrollListener;
    }

    public void setScrollListener(RecyclerView.OnScrollListener scrollListener) {
        this.scrollListener = scrollListener;
    }

    public int getFirstVisibleItemPosition() {
        if (recyclerViewRf.isEnqueued()) return 0;
        RecyclerView.LayoutManager layoutManager = recyclerViewRf.get().getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        } else if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        return 0;
    }

    public int getLastVisibleItemPosition() {
        if (recyclerViewRf.isEnqueued()) return 0;
        RecyclerView.LayoutManager layoutManager = recyclerViewRf.get().getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        } else if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        return 0;
    }

    public void scrollToPosition(int position, final int offSet) {
        if (recyclerViewRf.isEnqueued()) return;
        RecyclerView recyclerView = recyclerViewRf.get();
        int firstVisiblePosition = getFirstVisibleItemPosition();
        int lastVisiblePosition = getLastVisibleItemPosition();
        if (position < firstVisiblePosition) {
            recyclerView.smoothScrollToPosition(position);
        } else if (position <= lastVisiblePosition) {
            int movePosition = position - firstVisiblePosition;
            if (movePosition >= 0 && movePosition < recyclerView.getChildCount()) {
                int top = recyclerView.getChildAt(movePosition).getTop();
                recyclerView.scrollBy(0, top + offSet);
            }
        } else {
            recyclerView.smoothScrollToPosition(position);
            recyclerView.addOnScrollListener(new ScrollListener(true, position, offSet));
        }
    }

    class ScrollListener extends RecyclerView.OnScrollListener {
        private boolean moveBelowLastVisiblePosition;
        private int targetPosition;
        private int offSet;

        public ScrollListener(boolean moveBelowLastVisiblePosition, int targetPosition, int offSet) {
            this.moveBelowLastVisiblePosition = moveBelowLastVisiblePosition;
            this.targetPosition = targetPosition;
            this.offSet = offSet;
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (newState == RecyclerView.SCROLL_STATE_IDLE && moveBelowLastVisiblePosition) {
                moveBelowLastVisiblePosition = false;
                int firstVisiblePosition = getFirstVisibleItemPosition();
                int movePosition = targetPosition - firstVisiblePosition;
                if (movePosition >= 0 && movePosition < recyclerView.getChildCount()) {
                    int top = recyclerView.getChildAt(movePosition).getTop();
                    recyclerView.scrollBy(0, top + offSet);
                }
                recyclerView.removeOnScrollListener(this);
            }
        }
    }
}
