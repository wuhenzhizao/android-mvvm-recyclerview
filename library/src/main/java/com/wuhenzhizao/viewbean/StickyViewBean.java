package com.wuhenzhizao.viewbean;

/**
 * Created by liufei on 2017/9/11.
 */

public class StickyViewBean {
    public static final long DEFAULT_ID = 1;

    private boolean isSticky;
    private long headId = DEFAULT_ID;

    public boolean isSticky() {
        return isSticky;
    }

    public long getHeadId() {
        return headId;
    }
}
