package com.wuhenzhizao.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.gomeos.mvvm.viewmodel.RecyclerItemViewModel;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.wuhenzhizao.viewbean.StickyViewBean;
import com.wuhenzhizao.viewholder.DefaultViewHolder;

/**
 * Created by liufei on 2017/9/11.
 */
public class StickyHeaderRecyclerViewAdapter extends ViewModelRecyclerViewAdapter implements StickyRecyclerHeadersAdapter<DefaultViewHolder> {

    public StickyHeaderRecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    public long getHeaderId(int position) {
        StickyViewBean viewBean = getItem(position);
        if (viewBean.isSticky()) {
            return viewBean.getHeadId();
        } else {
            return 0;
        }
    }

    @Override
    public DefaultViewHolder onCreateHeaderViewHolder(ViewGroup parent, int position) {
        RecyclerItemViewModel vm = (RecyclerItemViewModel) itemViewFactory.getViewModel(getItem(position));
        return new DefaultViewHolder(vm, itemViewFactory.getViewDataBinding(vm));
    }

    @Override
    public void onBindHeaderViewHolder(DefaultViewHolder holder, int position) {
        RecyclerItemViewModel recyclerItemViewModel = holder.recyclerItemViewModel;
        recyclerItemViewModel.setItem(getItem(position));
        holder.viewDataBinding.executePendingBindings();
    }

    @Override
    public StickyViewBean getItem(int position) {
        return (StickyViewBean) super.getItem(position);
    }
}
