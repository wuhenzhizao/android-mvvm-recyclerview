package com.wuhenzhizao.callback;

import android.view.View;

/**
 * Created by wuhenzhizao on 2017/9/14.
 */

public interface ItemHeaderClickListener {
    /**
     *
     * @param clickView
     * @param position
     * @param headerId
     */
    void onHeaderClick(View clickView, int position, long headerId);
}
