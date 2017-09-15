package com.wuhenzhizao.viewmodule;

import android.os.Bundle;

import com.gomeos.mvvm.viewmodel.LifecycleViewModel;
import com.wuhenzhizao.model.Address;
import com.wuhenzhizao.view.ui.SwipeMenuActivity;
import com.wuhenzhizao.viewmodule.viewbean.SwipeBaseViewBean;
import com.wuhenzhizao.viewmodule.viewbean.SwipeLeftViewBean;
import com.wuhenzhizao.viewmodule.viewbean.SwipeRightViewBean;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liufei on 2017/9/15.
 */

public class SwipeViewModel extends LifecycleViewModel {
    private List<SwipeBaseViewBean> itemList;
    private int mode;

    public void setMode(int mode) {
        this.mode = mode;
    }

    public List<SwipeBaseViewBean> getItemList() {
        return itemList;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        itemList = new LinkedList<>();
        for (int i = 0; i < Address.provinces.length; i++){
            SwipeBaseViewBean viewBean;
            if (mode == SwipeMenuActivity.RIGHT){
                viewBean = new SwipeRightViewBean();
            } else {
                viewBean = new SwipeLeftViewBean();
            }
            viewBean.setName(Address.provinces[i]);
            itemList.add(viewBean);
        }
        notifyChange();
    }
}
