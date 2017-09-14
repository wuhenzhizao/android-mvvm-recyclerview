package com.wuhenzhizao.viewmodule;

import com.gomeos.mvvm.viewmodel.RecyclerItemViewModel;
import com.gomeos.mvvm.viewmodel.command.OnClickCommand;
import com.wuhenzhizao.viewmodule.viewbean.StickyItemViewBean;

/**
 * Created by liufei on 2017/9/14.
 */

public class StickyHeaderItemViewModel extends RecyclerItemViewModel<StickyItemViewBean> {
    private String title;

    public String getTitle() {
        return title;
    }

    public OnClickCommand getOnClickCommand(){
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {

            }
        };
    }

    @Override
    protected void onItemChange(StickyItemViewBean oldItem, StickyItemViewBean item) {
        title = item.getTitle();
        notifyChange();
    }
}
