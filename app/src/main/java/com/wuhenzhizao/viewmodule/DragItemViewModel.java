package com.wuhenzhizao.viewmodule;

import com.gomeos.mvvm.viewmodel.RecyclerItemViewModel;
import com.wuhenzhizao.viewmodule.viewbean.DragViewBean;

/**
 * Created by wuhenzhizao on 2017/9/13.
 */

public class DragItemViewModel extends RecyclerItemViewModel<DragViewBean> {
    private int image;
    private String name;

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    @Override
    protected void onItemChange(DragViewBean oldItem, DragViewBean item) {
        image = item.getImage();
        name = item.getName();
        notifyChange();
    }
}
