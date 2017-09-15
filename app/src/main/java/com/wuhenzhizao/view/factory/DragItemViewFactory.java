package com.wuhenzhizao.view.factory;

import android.databinding.ViewDataBinding;

import com.gomeos.mvvm.viewmodel.AbsItemViewModel;
import com.wuhenzhizao.R;
import com.wuhenzhizao.databinding.ItemDragBinding;
import com.wuhenzhizao.factory.AbsViewFactory;
import com.wuhenzhizao.viewmodule.DragItemViewModel;
import com.wuhenzhizao.viewmodule.viewbean.DragViewBean;

/**
 * Created by wuhenzhizao on 2017/9/13.
 */

public class DragItemViewFactory extends AbsViewFactory<DragViewBean> {

    public static String getClassName() {
        return DragItemViewFactory.class.getName();
    }

    @Override
    protected Class<? extends AbsItemViewModel> getViewModelType(DragViewBean item) {
        return DragItemViewModel.class;
    }

    @Override
    protected ViewDataBinding createViewDataBinding(AbsItemViewModel viewModel) {
        ItemDragBinding dragBinding = inflate(R.layout.item_drag);
        dragBinding.setVm((DragItemViewModel) viewModel);
        return dragBinding;
    }
}
