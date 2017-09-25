package com.wuhenzhizao.viewmodule;

import android.os.Bundle;

import com.gomeos.mvvm.viewmodel.LifecycleViewModel;
import com.wuhenzhizao.model.Address;
import com.wuhenzhizao.view.RefreshLayoutProxy;
import com.wuhenzhizao.view.ui.SwipeMenuActivity;
import com.wuhenzhizao.viewmodule.viewbean.SwipeBaseViewBean;
import com.wuhenzhizao.viewmodule.viewbean.SwipeLeftViewBean;
import com.wuhenzhizao.viewmodule.viewbean.SwipeRightViewBean;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wuhenzhizao on 2017/9/15.
 */

public class SwipeViewModel extends LifecycleViewModel {
    private RefreshLayoutProxy proxy;
    private List<SwipeBaseViewBean> itemList;
    private int mode;

    public void setMode(int mode) {
        this.mode = mode;
    }

    public List<SwipeBaseViewBean> getItemList() {
        return itemList;
    }

    public RefreshLayoutProxy getProxy() {
        return proxy;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        proxy = new RefreshLayoutProxy();
        proxy.setEnableLoadMore(true);
        if (mode == SwipeMenuActivity.RIGHT_REFRESH) {
            proxy.setEnableLoadMore(true);
        } else {
            proxy.setEnableRefresh(false);
            proxy.setEnableLoadMore(false);
        }

        itemList = new LinkedList<>();
        for (int i = 0; i < Address.provinces.length / 3; i++) {
            SwipeBaseViewBean viewBean;
            if (mode == SwipeMenuActivity.LEFT) {
                viewBean = new SwipeLeftViewBean();
            } else {
                viewBean = new SwipeRightViewBean();
            }
            viewBean.setName(Address.provinces[i]);
            itemList.add(viewBean);
        }
        notifyChange();
    }
}
