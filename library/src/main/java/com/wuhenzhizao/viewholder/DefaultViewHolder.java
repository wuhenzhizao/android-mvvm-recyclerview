package com.wuhenzhizao.viewholder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.gomeos.mvvm.viewmodel.RecyclerItemViewModel;

/**
 * Created by wuhenzhizao on 2017/9/11.
 */
public class DefaultViewHolder extends RecyclerView.ViewHolder {
    public RecyclerItemViewModel recyclerItemViewModel;
    public ViewDataBinding viewDataBinding;

    public DefaultViewHolder(RecyclerItemViewModel recyclerItemViewModel, ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        this.recyclerItemViewModel = recyclerItemViewModel;
        this.viewDataBinding = viewDataBinding;
        this.recyclerItemViewModel.setView(viewDataBinding.getRoot());
    }
}
