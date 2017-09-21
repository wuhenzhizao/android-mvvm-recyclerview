package com.wuhenzhizao.factory;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;

import com.gomeos.mvvm.utils.ObjectUtils;
import com.gomeos.mvvm.view.DataBindingFactory;
import com.gomeos.mvvm.viewmodel.AbsItemViewModel;

/**
 * Created by chenbaocheng on 16/8/11.
 */
public abstract class AbsViewFactory<ItemType>{
    private Context context;

    public final Class<?> getViewModelClass(ItemType item) {
        return getViewModelType(item);
    }

    public final AbsItemViewModel<ItemType> getViewModel(ItemType item) {
        return getViewModel(getViewModelType(item));
    }

    public final AbsItemViewModel<ItemType> getViewModel(Class<? extends AbsItemViewModel> type) {
        AbsItemViewModel<ItemType> vm = (AbsItemViewModel<ItemType>) ObjectUtils.newInstance(type);
        return vm;
    }

    public final ViewDataBinding getViewDataBinding(AbsItemViewModel<ItemType> viewModel) {
        ViewDataBinding viewDataBinding = createViewDataBinding(viewModel);
        viewModel.setContext(viewDataBinding.getRoot().getContext());
        return viewDataBinding;
    }

    protected abstract Class<? extends AbsItemViewModel> getViewModelType(ItemType item);

    protected abstract ViewDataBinding createViewDataBinding(AbsItemViewModel viewModel);

    protected final <T extends ViewDataBinding> T inflate(@LayoutRes int layoutId) {
        return DataBindingFactory.inflate(context, layoutId);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return this.context;
    }
}
