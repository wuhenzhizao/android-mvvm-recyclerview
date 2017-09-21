package com.wuhenzhizao.view;

import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wuhenzhizao on 2017/9/14.
 */
public class StickyHeaderTouchListener implements RecyclerView.OnItemTouchListener {
    private final GestureDetector mTapDetector;
    private final StickyHeaderRecyclerView mRecyclerView;
    private final StickyRecyclerHeadersDecoration mDecor;
    private OnHeaderClickListener mOnHeaderClickListener;

    public interface OnHeaderClickListener {
        void onHeaderClick(View headerView, View clickView, int position, long headerId);
    }

    public StickyHeaderTouchListener(final StickyHeaderRecyclerView recyclerView,
                                     final StickyRecyclerHeadersDecoration decor) {
        mTapDetector = new GestureDetector(recyclerView.getContext(), new SingleTapDetector());
        mRecyclerView = recyclerView;
        mDecor = decor;
    }

    public void setOnHeaderClickListener(OnHeaderClickListener listener) {
        mOnHeaderClickListener = listener;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        if (this.mOnHeaderClickListener != null) {
            boolean tapDetectorResponse = this.mTapDetector.onTouchEvent(e);
            if (tapDetectorResponse) {
                // Don't return false if a single tap is detected
                return true;
            }
            if (e.getAction() == MotionEvent.ACTION_DOWN) {
                View v = mDecor.findHeaderViewUnder((int) e.getX(), (int) e.getY());
                return v != null;
            }
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent e) { /* do nothing? */ }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        // do nothing
    }

    private class SingleTapDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            View v = mDecor.findHeaderViewUnder((int) e.getX(), (int) e.getY());
            if (v != null) {
                View headerView = null;
                View temp = v;
                while (temp instanceof ViewGroup) {
                    ViewGroup parent = (ViewGroup) temp.getParent();
                    if (parent == null || parent.getLayoutParams() instanceof RecyclerView.LayoutParams) {
                        headerView = temp;
                        break;
                    } else {
                        temp = parent;
                    }
                }
                int position = (int) headerView.getTag();
                long headerId = mRecyclerView.getAdapter().getHeaderId(position);
                mOnHeaderClickListener.onHeaderClick(headerView, v, position, headerId);
                mRecyclerView.playSoundEffect(SoundEffectConstants.CLICK);
                v.onTouchEvent(e);
                return true;
            }
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            return true;
        }
    }
}