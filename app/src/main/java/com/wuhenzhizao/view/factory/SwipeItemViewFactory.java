package com.wuhenzhizao.view.factory;

import android.databinding.ViewDataBinding;

import com.gomeos.mvvm.viewmodel.AbsItemViewModel;
import com.wuhenzhizao.R;
import com.wuhenzhizao.databinding.ItemSwipeLeftBinding;
import com.wuhenzhizao.databinding.ItemSwipeRightBinding;
import com.wuhenzhizao.factory.AbsViewFactory;
import com.wuhenzhizao.viewmodule.SwipeLeftItemViewModel;
import com.wuhenzhizao.viewmodule.SwipeRightItemViewModel;
import com.wuhenzhizao.viewmodule.viewbean.SwipeBaseViewBean;
import com.wuhenzhizao.viewmodule.viewbean.SwipeLeftViewBean;
import com.wuhenzhizao.viewmodule.viewbean.SwipeRightViewBean;

/**
 * Created by wuhenzhizao on 2017/9/15.
 */

public class SwipeItemViewFactory extends AbsViewFactory<SwipeBaseViewBean> {

    public static String getClassName() {
        return SwipeItemViewFactory.class.getName();
    }

    @Override
    protected Class<? extends AbsItemViewModel> getViewModelType(SwipeBaseViewBean item) {
        if (item instanceof SwipeLeftViewBean) {
            return SwipeLeftItemViewModel.class;
        } else if (item instanceof SwipeRightViewBean) {
            return SwipeRightItemViewModel.class;
        }
        return null;
    }

    @Override
    protected ViewDataBinding createViewDataBinding(AbsItemViewModel viewModel) {
        if (viewModel instanceof SwipeLeftItemViewModel) {
            ItemSwipeLeftBinding leftBinding = inflate(R.layout.item_swipe_left);
            leftBinding.setVm((SwipeLeftItemViewModel) viewModel);
            return leftBinding;
        } else if (viewModel instanceof SwipeRightItemViewModel) {
            ItemSwipeRightBinding rightBinding = inflate(R.layout.item_swipe_right);
            rightBinding.setVm((SwipeRightItemViewModel) viewModel);
            return rightBinding;
        }
        return null;
    }
}
