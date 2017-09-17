package com.wuhenzhizao.viewmodule;

import android.widget.Toast;

import com.gomeos.mvvm.viewmodel.RecyclerItemViewModel;
import com.gomeos.mvvm.viewmodel.command.OnClickCommand;
import com.wuhenzhizao.viewmodule.viewbean.SwipeLeftViewBean;

/**
 * Created by wuhenzhizao on 2017/9/15.
 */

public class SwipeLeftItemViewModel extends RecyclerItemViewModel<SwipeLeftViewBean> {
    private String name;

    public String getName() {
        return name;
    }

    public OnClickCommand getDeleteCommand() {
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {
                Toast.makeText(getContext(), name + " clicked", Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    protected void onItemChange(SwipeLeftViewBean oldItem, SwipeLeftViewBean item) {
        this.name = item.getName();
        notifyChange();
    }
}
