package com.wuhenzhizao.viewmodule;

import com.gomeos.mvvm.viewmodel.RecyclerItemViewModel;
import com.gomeos.mvvm.viewmodel.command.OnClickCommand;
import com.wuhenzhizao.viewmodule.viewbean.StickyTestViewBean;

/**
 * Created by wuhenzhizao on 2017/9/14.
 */

public class StickyHeaderItemViewModel extends RecyclerItemViewModel<StickyTestViewBean> {
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
    protected void onItemChange(StickyTestViewBean oldItem, StickyTestViewBean item) {
        title = item.getTitle();
        notifyChange();
    }
}
