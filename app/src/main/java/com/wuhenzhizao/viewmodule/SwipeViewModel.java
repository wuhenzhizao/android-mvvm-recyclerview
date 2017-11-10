package com.wuhenzhizao.viewmodule;

import android.os.Bundle;

import com.gomeos.mvvm.viewmodel.LifecycleViewModel;
import com.wuhenzhizao.model.MainUseCase;
import com.wuhenzhizao.view.RecyclerViewProxy;
import com.wuhenzhizao.view.proxy.RefreshRecyclerViewProxy;
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
    private MainUseCase useCase;
    private RefreshRecyclerViewProxy proxy;
    private List<SwipeBaseViewBean> itemList;
    private int mode;

    public void setMode(int mode) {
        this.mode = mode;
    }

    public List<SwipeBaseViewBean> getItemList() {
        return itemList;
    }

    public RefreshRecyclerViewProxy getProxy() {
        return proxy;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        proxy = new RefreshRecyclerViewProxy();
        proxy.setEnableLoadMore(true);
        if (mode == SwipeMenuActivity.RIGHT_REFRESH) {
            proxy.setEnableLoadMore(true);
        } else {
            proxy.setEnableRefresh(false);
            proxy.setEnableLoadMore(false);
        }

        useCase = obtainUseCase(MainUseCase.class);
        String[] provinces = useCase.getProviceList();

        itemList = new LinkedList<>();
        for (int i = 0; i < provinces.length / 2; i++) {
            SwipeBaseViewBean viewBean;
            if (mode == SwipeMenuActivity.LEFT) {
                viewBean = new SwipeLeftViewBean();
            } else {
                viewBean = new SwipeRightViewBean();
            }
            viewBean.setName(provinces[i]);
            itemList.add(viewBean);
        }
        notifyChange();
    }
}
