package com.wuhenzhizao.factory;

import android.databinding.ViewDataBinding;

import com.gomeos.mvvm.viewmodel.AbsItemViewModel;

/**
 * Created by liufei on 2017/9/14.
 */

public interface Factory<ItemType> {

    Class<?> getViewModelClass(ItemType item);

    AbsItemViewModel<ItemType> getViewModel(ItemType item);

    AbsItemViewModel<ItemType> getViewModel(Class<? extends AbsItemViewModel> type);

    ViewDataBinding getViewDataBinding(AbsItemViewModel<ItemType> viewModel);
}
