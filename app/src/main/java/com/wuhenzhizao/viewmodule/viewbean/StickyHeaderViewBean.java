package com.wuhenzhizao.viewmodule.viewbean;

import com.wuhenzhizao.viewbean.StickyViewBean;

/**
 * Created by wuhenzhizao on 2017/9/14.
 */

public class StickyHeaderViewBean extends StickyViewBean {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "StickyHeaderViewBean{" +
                "title='" + title + '\'' +
                '}';
    }
}
