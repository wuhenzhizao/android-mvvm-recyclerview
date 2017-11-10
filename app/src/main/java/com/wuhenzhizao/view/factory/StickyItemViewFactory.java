package com.wuhenzhizao.view.factory;

import android.databinding.ViewDataBinding;

import com.gomeos.mvvm.view.DataBindingFactory;
import com.gomeos.mvvm.viewmodel.AbsItemViewModel;
import com.wuhenzhizao.R;
import com.wuhenzhizao.databinding.ItemStickyContentBinding;
import com.wuhenzhizao.databinding.ItemStickyHeaderBinding;
import com.wuhenzhizao.databinding.ItemStickyMenuBinding;
import com.wuhenzhizao.factory.StickyViewFactory;
import com.wuhenzhizao.viewbean.StickyViewBean;
import com.wuhenzhizao.viewmodule.StickyHeaderItemViewModel;
import com.wuhenzhizao.viewmodule.StickyItemViewModel;
import com.wuhenzhizao.viewmodule.StickyMenuItemViewModel;
import com.wuhenzhizao.viewmodule.viewbean.StickyTestViewBean;

/**
 * Created by wuhenzhizao on 2017/9/14.
 */

public class StickyItemViewFactory extends StickyViewFactory<StickyViewBean> {

    public static String getClassName() {
        return StickyItemViewFactory.class.getName();
    }

    @Override
    protected Class<? extends AbsItemViewModel> getHeaderViewModelType(StickyViewBean item) {
        if (item instanceof StickyTestViewBean) {
            if (((StickyTestViewBean) item).getStickyTheme() == 1){
                return StickyHeaderItemViewModel.class;
            } else {
                return StickyMenuItemViewModel.class;
            }
        }
        return null;
    }

    @Override
    protected ViewDataBinding createHeaderViewDataBinding(AbsItemViewModel viewModel) {
        if (viewModel instanceof StickyHeaderItemViewModel) {
            ItemStickyHeaderBinding binding = DataBindingFactory.inflate(getContext(), R.layout.item_sticky_header);
            binding.setVm((StickyHeaderItemViewModel) viewModel);
            return binding;
        } else if (viewModel instanceof StickyMenuItemViewModel){
            ItemStickyMenuBinding binding = DataBindingFactory.inflate(getContext(), R.layout.item_sticky_menu);
            binding.setVm((StickyMenuItemViewModel) viewModel);
            return binding;
        }
        return null;
    }

    @Override
    protected Class<? extends AbsItemViewModel> getViewModelType(StickyViewBean item) {
        if (item instanceof StickyTestViewBean) {
            return StickyItemViewModel.class;
        }
        return null;
    }

    @Override
    protected ViewDataBinding createViewDataBinding(AbsItemViewModel viewModel) {
        if (viewModel instanceof StickyItemViewModel) {
            ItemStickyContentBinding contentBinding = inflate(R.layout.item_sticky_content);
            contentBinding.setVm((StickyItemViewModel) viewModel);
            return contentBinding;
        }
        return null;
    }
}
