package com.wuhenzhizao.view.factory;

import android.databinding.ViewDataBinding;

import com.gomeos.mvvm.viewmodel.AbsItemViewModel;
import com.wuhenzhizao.R;
import com.wuhenzhizao.databinding.ItemDragBinding;
import com.wuhenzhizao.factory.AbsViewFactory;
import com.wuhenzhizao.viewbean.BaseViewBean;
import com.wuhenzhizao.viewmodule.DragItemViewModel;

/**
 * Created by wuhenzhizao on 2017/9/13.
 */

public class DragItemViewFactory extends AbsViewFactory<BaseViewBean> {

    public static String getClassName() {
        return DragItemViewFactory.class.getName();
    }

    @Override
    protected Class<? extends AbsItemViewModel> getViewModelType(BaseViewBean item) {
        return DragItemViewModel.class;
    }

    @Override
    protected ViewDataBinding createViewDataBinding(AbsItemViewModel viewModel) {
        ItemDragBinding dragBinding = inflate(R.layout.item_drag);
        dragBinding.setVm((DragItemViewModel) viewModel);
        return dragBinding;
    }
}
