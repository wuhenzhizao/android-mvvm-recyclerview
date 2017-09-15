package com.wuhenzhizao.viewmodule;

import com.gomeos.mvvm.viewmodel.RecyclerItemViewModel;
import com.wuhenzhizao.R;
import com.wuhenzhizao.viewmodule.viewbean.StickyTestViewBean;

/**
 * Created by wuhenzhizao on 2017/9/14.
 */

public class StickyMenuItemViewModel extends RecyclerItemViewModel<StickyTestViewBean> {
    private String title;
    private boolean collect;
    private int image;

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    @Override
    protected void onItemChange(StickyTestViewBean oldItem, StickyTestViewBean item) {
        title = item.getTitle();
        collect = item.isCollect();
        image = (collect ? R.mipmap.sticky_wishlist_selected : R.mipmap.sticky_wishlist_unselected);
        notifyChange();
    }
}
