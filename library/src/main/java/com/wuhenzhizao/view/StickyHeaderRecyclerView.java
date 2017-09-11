package com.wuhenzhizao.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.gomeos.mvvm.utils.ObjectUtils;
import com.gomeos.mvvm.view.LayoutManagers;
import com.gomeos.mvvm.view.factory.ItemViewFactory;
import com.wuhenzhizao.adapter.R;
import com.wuhenzhizao.adapter.StickyViewModelRecyclerViewAdapter;

import java.util.Collection;

/**
 * Created by wuhenzhizao on 2017/3/16.
 */
public class StickyHeaderRecyclerView extends RecyclerView {
    private StickyViewModelRecyclerViewAdapter adapter;
    private String itemViewFactory;
    private boolean isLooped = false;
    Collection<?> items;

    public StickyHeaderRecyclerView(Context context) {
        this(context, null);
    }

    public StickyHeaderRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StickyHeaderRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DataBindingRecyclerView);
            if (typedArray != null) {
                isLooped = typedArray.getBoolean(R.styleable.DataBindingRecyclerView_looped, false);
                typedArray.recycle();
            }
            initAdapter();
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.ItemizedView);
            itemViewFactory = typedArray.getString(R.styleable.ItemizedView_itemViewFactory);
            if (itemViewFactory != null) {
                setItemViewFactory(itemViewFactory);
            }
            typedArray.recycle();
        } else {
            initAdapter();
        }
    }

    private void initAdapter() {
        adapter = new StickyViewModelRecyclerViewAdapter(getContext());
        adapter.setLooped(isLooped);
    }

    @Override
    public StickyViewModelRecyclerViewAdapter getAdapter() {
        return adapter;
    }

    public void setItemViewFactory(String className) {
        ItemViewFactory factory = ObjectUtils.newInstance(className);
        factory.setContext(getContext());
        adapter.setItemViewFactory(factory);
    }

    public void setLayoutManager(LayoutManagers.LayoutManagerFactory factory) {
        super.setLayoutManager(factory.create(this));
        setAdapter(adapter);
    }

    public void setItems(final Collection items) {
        adapter.putItems(items);
        adapter.notifyDataSetChanged();
        if (isLooped && getLayoutManager() != null) {
            if (items != items) {
                int index = (adapter.getItemCount() / 2);
                index = index - index % items.size();
                getLayoutManager().scrollToPosition(index);
            }
            this.items = items;
        }
    }
}
