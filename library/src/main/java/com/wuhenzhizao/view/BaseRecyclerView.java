package com.wuhenzhizao.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.gomeos.mvvm.utils.ObjectUtils;
import com.gomeos.mvvm.view.LayoutManagers;
import com.wuhenzhizao.adapter.R;
import com.wuhenzhizao.adapter.ViewModelRecyclerViewAdapter;
import com.wuhenzhizao.factory.AbsViewFactory;

import java.util.List;

/**
 * Created by chenbaocheng on 16/8/14.
 */
public abstract class BaseRecyclerView<RVA extends ViewModelRecyclerViewAdapter> extends RecyclerView implements DataBindingInterface {
    protected RVA adapter;
    protected String itemViewFactory;
    protected boolean isLooped = false;
    protected List items;
    protected ItemDecoration decoration;

    public BaseRecyclerView(Context context) {
        this(context, null);
    }

    public BaseRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setOverScrollMode(OVER_SCROLL_NEVER);
        initAttributes(context, attrs);
        initSettings();
        setHasFixedSize(true);
    }

    protected final void initBasicAttributes(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DataBindingRecyclerView);
        if (typedArray != null) {
            isLooped = typedArray.getBoolean(R.styleable.DataBindingRecyclerView_looped, false);
            typedArray.recycle();
        }
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.ItemizedView);
        itemViewFactory = typedArray.getString(R.styleable.ItemizedView_itemViewFactory);
        if (itemViewFactory != null) {
            setItemViewFactory(itemViewFactory);
        }
        typedArray.recycle();
    }

    protected void initAttributes(Context context, AttributeSet attrs) {
        if (attrs != null) {
            initBasicAttributes(context, attrs);
        }
    }

    protected abstract void initSettings();

    @Override
    public RVA getAdapter() {
        return adapter;
    }

    @Override
    public void setItemViewFactory(String className) {
        AbsViewFactory factory = ObjectUtils.newInstance(className);
        factory.setContext(getContext());
        adapter.setItemViewFactory(factory);
    }

    @Override
    public void setLayoutManager(LayoutManagers.LayoutManagerFactory factory) {
        super.setLayoutManager(factory.create(this));
        setAdapter(adapter);
    }

    @Override
    public void setItemDecoration(ItemDecoration decoration) {
        if (this.decoration == null){
            this.decoration = decoration;
            addItemDecoration(decoration);
        }
    }

    public void setProxy(RecyclerViewProxy proxy) {
        proxy.attach(this);
        OnScrollListener scrollListener = proxy.getScrollListener();
        if (scrollListener != null) {
            addOnScrollListener(proxy.getScrollListener());
        }
    }

    public void setItems(final List items) {
        adapter.putItems(items);
        adapter.notifyDataSetChanged();
        if (isLooped && getLayoutManager() != null) {
            if (BaseRecyclerView.this.items != items) {
                int index = (adapter.getItemCount() / 2);
                index = index - index % items.size();
                getLayoutManager().scrollToPosition(index);
            }
            this.items = items;
        }
    }
}
