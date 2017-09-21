package com.wuhenzhizao.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.swipe.SwipeLayout;
import com.wuhenzhizao.adapter.SwipeMenuRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuhenzhizao on 2017/9/11.
 */
public class SwipeMenuRecyclerView extends BaseRecyclerView<SwipeMenuRecyclerViewAdapter> {
    private SwipeLayout oldSwipeLayout;
    private boolean isClosing = false;
    private int mOldTouchedPosition = INVALID_POSITION;

    private static final int INVALID_POSITION = -1;

    public SwipeMenuRecyclerView(Context context) {
        super(context);
    }

    public SwipeMenuRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SwipeMenuRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void initSettings() {
        adapter = new SwipeMenuRecyclerViewAdapter(getContext());
        adapter.setLooped(isLooped);

        setOnScrollListener(scrollListener);
    }

    RecyclerView.OnScrollListener scrollListener = new OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            adapter.closeAllItems();
        }
    };

    private SwipeLayout getSwipeLayoutView(View itemView) {
        if (itemView instanceof SwipeLayout) return (SwipeLayout) itemView;
        List<View> unvisited = new ArrayList<>();
        unvisited.add(itemView);
        while (!unvisited.isEmpty()) {
            View child = unvisited.remove(0);
            if (!(child instanceof ViewGroup)) { // view
                continue;
            }
            if (child instanceof SwipeLayout) return (SwipeLayout) child;
            ViewGroup group = (ViewGroup) child;
            final int childCount = group.getChildCount();
            for (int i = 0; i < childCount; i++) unvisited.add(group.getChildAt(i));
        }
        return null;
    }

    private int lastDispatchX = 0;
    private int lastDispatchY = 0;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int currentDispatchX = (int) ev.getX();
        int currentDispatchY = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs(currentDispatchX - lastDispatchX) < Math.abs(currentDispatchY - lastDispatchY)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
        }
        lastDispatchX = currentDispatchX;
        lastDispatchY = currentDispatchY;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        if (e.getPointerCount() > 1) return true;
        boolean isIntercepted = super.onInterceptTouchEvent(e);

        int touchingPosition;
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchingPosition = getChildAdapterPosition(findChildViewUnder(e.getX(), e.getY()));
                if (touchingPosition != mOldTouchedPosition && isOldSwipeLayoutStatusOpen()) {
                    closeSwipeLayout();
                    isIntercepted = true;
                }
                if (isIntercepted) {
                    oldSwipeLayout = null;
                    mOldTouchedPosition = INVALID_POSITION;
                } else {
                    ViewHolder vh = findViewHolderForAdapterPosition(touchingPosition);
                    if (vh != null) {
                        SwipeLayout swipeLayout = getSwipeLayoutView(vh.itemView);
                        if (swipeLayout != null) {
                            oldSwipeLayout = swipeLayout;
                            mOldTouchedPosition = touchingPosition;
                        }
                    }
                }
                break;
        }
        return isIntercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                if (isClosing) return true;
                break;
        }
        return super.onTouchEvent(e);
    }

    private boolean isOldSwipeLayoutStatusOpen() {
        return oldSwipeLayout != null && oldSwipeLayout.getOpenStatus() != SwipeLayout.Status.Close;
    }

    private void closeSwipeLayout() {
        isClosing = true;
        oldSwipeLayout.close(true, false);
        oldSwipeLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                isClosing = false;
            }
        }, 500);
    }
}
