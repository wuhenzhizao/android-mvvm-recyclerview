package com.wuhenzhizao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.gomeos.mvvm.viewmodel.RecyclerItemViewModel;
import com.wuhenzhizao.viewholder.DefaultViewHolder;

import java.util.ArrayList;
import java.util.List;

import com.wuhenzhizao.factory.AbsViewFactory;

/**
 * Created by liuyuxuan on 16/5/17.
 */
public class ViewModelRecyclerViewAdapter<Factory extends AbsViewFactory> extends BaseRecyclerAdapter {
    protected final List<Class<?>> viewModelTypes;
    protected Factory itemViewFactory;
    protected boolean isLooped;
    protected final int LOOP_COUNT = 10000000;

    public ViewModelRecyclerViewAdapter(Context context) {
        super(context);
        this.viewModelTypes = new ArrayList<>();
        setHasStableIds(true);
    }

    public void setLooped(boolean looped) {
        isLooped = looped;
    }

    protected final void onDataChange() {
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        if (isLooped) {
            position = getCount() == 0 ? 0 : position % getCount();
        }
        return position;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final int getItemViewType(int position) {
        Class<?> type = itemViewFactory.getViewModelClass(getItem(position));
        int index = viewModelTypes.indexOf(type);
        if (index == -1) {
            viewModelTypes.add(type);
            index = viewModelTypes.indexOf(type);
        }

        return index;
    }

    @Override
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerItemViewModel vm = (RecyclerItemViewModel) itemViewFactory.getViewModel(viewModelTypes.get(viewType));
        return new DefaultViewHolder(vm, itemViewFactory.getViewDataBinding(vm));
    }

    @Override
    public final void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DefaultViewHolder viewHolder = (DefaultViewHolder) holder;
        RecyclerItemViewModel recyclerItemViewModel = viewHolder.recyclerItemViewModel;
        recyclerItemViewModel.setItem(getItem(position));
        viewHolder.viewDataBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if (isLooped) {
            if (getCount() > 0) {
                return LOOP_COUNT;
            }
        }
        return getCount();
    }


    @Override
    public Object getItem(int position) {
        if (isLooped) {
            position = getCount() == 0 ? 0 : position % getCount();
        }
        return super.getItem(position);
    }

    public Factory getItemViewFactory() {
        return itemViewFactory;
    }

    public void setItemViewFactory(Factory itemViewFactory) {
        this.itemViewFactory = itemViewFactory;
    }
}
