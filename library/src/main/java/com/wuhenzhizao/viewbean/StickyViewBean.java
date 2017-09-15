package com.wuhenzhizao.viewbean;

/**
 * Created by wuhenzhizao on 2017/9/11.
 */

public class StickyViewBean {
    public static final long DEFAULT_ID = -1;
    public static final long STICKY_ID = 1;

    private boolean isSticky;
    private long headId = DEFAULT_ID;

    public StickyViewBean(boolean isSticky) {
        this.isSticky = isSticky;
        if (isSticky){
            headId = STICKY_ID;
        }
    }

    public boolean isSticky() {
        return isSticky;
    }

    public void setSticky(boolean sticky) {
        isSticky = sticky;
    }

    public long getHeadId() {
        return headId;
    }

    public void setHeadId(long headId) {
        this.headId = headId;
    }

    @Override
    public String toString() {
        return "StickyViewBean{" +
                "isSticky=" + isSticky +
                ", headId=" + headId +
                '}';
    }
}
