package com.wuhenzhizao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by chenbaocheng on 16/5/5.
 */
public abstract class BaseRecyclerAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final List<Object> items;

    public BaseRecyclerAdapter(Context context) {
        this.context = context;
        this.items = new ArrayList<>();
    }

    public int getCount() {
        return items.size();
    }

    public List<Object> getItems(){
        return items;
    }

    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.hashCode()+position;
    }

    protected abstract void onDataChange();

    public void addItem(Object item) {
        this.items.add(item);
        onDataChange();
    }

    public void removeItem(int position) {
        this.items.remove(position);
        onDataChange();
    }

    public void addItems(Collection<?> items) {
        this.items.addAll(items);
        onDataChange();
    }

    public void putItems(Collection<?> items) {
        this.items.clear();
        this.items.addAll(items);
        onDataChange();
    }
    public void addItems(int position, Collection<?> items) {
        this.items.addAll(position, items);
        onDataChange();
    }

    public void insertItem(int index, Object item) {
        this.items.add(index, item);
        onDataChange();
    }

    public void removeItems(int start) {

        for (int i = items.size() - 1; i >= start; i--) {
            items.remove(i);
        }
    }

    public void removeItem(Object item) {
        items.remove(item);
    }

    public int indexOf(Object item) {
        return items.indexOf(item);
    }

    public void clear() {
        this.items.clear();
        onDataChange();
    }

    protected Context getContext() {
        return this.context;
    }
}

