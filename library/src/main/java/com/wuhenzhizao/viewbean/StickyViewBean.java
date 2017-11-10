package com.wuhenzhizao.viewbean;

/**
 * Created by wuhenzhizao on 2017/9/11.
 */

public class StickyViewBean extends BaseViewBean {
    public static final long DEFAULT_ID = -1;
    public static final long STICKY_ID = 1;

    private long headId = DEFAULT_ID;

    public StickyViewBean() {
    }

    public StickyViewBean(long headId) {
        this.headId = headId;
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
                ", headId=" + headId +
                '}';
    }
}
