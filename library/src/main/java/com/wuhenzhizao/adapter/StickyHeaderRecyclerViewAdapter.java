package com.wuhenzhizao.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.gomeos.mvvm.viewmodel.RecyclerItemViewModel;
import com.wuhenzhizao.factory.StickyViewFactory;
import com.wuhenzhizao.viewbean.StickyViewBean;
import com.wuhenzhizao.viewholder.DefaultViewHolder;

/**
 * Created by wuhenzhizao on 2017/9/11.
 */
public class StickyHeaderRecyclerViewAdapter extends ViewModelRecyclerViewAdapter<StickyViewFactory> implements StickyHeaderAdapter<DefaultViewHolder> {

    public StickyHeaderRecyclerViewAdapter(Context context) {
        super(context);
        setHasStableIds(true);
    }

    @Override
    public long getHeaderId(int position) {
        return getItem(position).getHeadId();
    }

    @Override
    public DefaultViewHolder onCreateHeaderViewHolder(ViewGroup parent, int position) {
        RecyclerItemViewModel vm = (RecyclerItemViewModel) itemViewFactory.getHeaderViewModel(getItem(position));
        return new DefaultViewHolder(vm, itemViewFactory.getHeaderViewDataBinding(vm));
    }

    @Override
    public void onBindHeaderViewHolder(DefaultViewHolder holder, int position) {
        RecyclerItemViewModel recyclerItemViewModel = holder.recyclerItemViewModel;
        recyclerItemViewModel.setItem(getItem(position));
        holder.viewDataBinding.getRoot().setTag(position);
        holder.viewDataBinding.executePendingBindings();
    }

    @Override
    public StickyViewBean getItem(int position) {
        return (StickyViewBean) super.getItem(position);
    }
}
