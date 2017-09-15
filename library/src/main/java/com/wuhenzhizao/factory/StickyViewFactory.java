package com.wuhenzhizao.factory;

import android.databinding.ViewDataBinding;

import com.gomeos.mvvm.viewmodel.AbsItemViewModel;

/**
 * Created by wuhenzhizao on 2017/9/14.
 */
public abstract class StickyViewFactory<ItemType> extends AbsViewFactory<ItemType> {

    public final AbsItemViewModel<ItemType> getHeaderViewModel(ItemType item) {
        return getViewModel(getHeaderViewModelType(item));
    }

    public final ViewDataBinding getHeaderViewDataBinding(AbsItemViewModel<ItemType> viewModel) {
        ViewDataBinding viewDataBinding = createHeaderViewDataBinding(viewModel);
        viewModel.setContext(viewDataBinding.getRoot().getContext());
        return viewDataBinding;
    }

    protected abstract Class<? extends AbsItemViewModel> getHeaderViewModelType(ItemType item);

    protected abstract ViewDataBinding createHeaderViewDataBinding(AbsItemViewModel<ItemType> viewModel);
}
