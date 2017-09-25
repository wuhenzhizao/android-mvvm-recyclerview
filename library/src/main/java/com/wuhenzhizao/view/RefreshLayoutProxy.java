package com.wuhenzhizao.view;

import com.wuhenzhizao.api.OnItemDragListener;
import com.wuhenzhizao.api.OnItemHeaderClickListener;
import com.wuhenzhizao.api.OnLoadMoreListener;
import com.wuhenzhizao.api.OnMultiChangedListener;
import com.wuhenzhizao.api.OnPullRefreshListener;
import com.wuhenzhizao.api.OnRefreshOrLoadMoreListener;

/**
 * Created by wuhenzhizao on 2017/9/21.
 */

public class RefreshLayoutProxy {
    private OnItemDragListener itemDragListener;
    private OnItemHeaderClickListener itemHeaderClickListener;
    private OnPullRefreshListener pullRefreshListener;
    private OnLoadMoreListener loadMoreListener;
    private OnRefreshOrLoadMoreListener refreshOrLoadMoreListener;
    private OnMultiChangedListener multiChangedListener;
    private boolean enableRefresh = true;
    private boolean enableLoadMore = false;
    private boolean enableHeaderTranslationContent = true;    //是否启用内容视图拖动效果
    private boolean enableFooterTranslationContent = true;    //是否启用内容视图拖动效果
    private boolean enableOverScrollBounce = true;            //是否启用越界回弹
    private boolean enablePureScrollMode = false;             //是否开启纯滚动模式
    private boolean enableAutoLoadMore = true;                //是否在列表滚动到底部时自动加载更多
    private boolean enableScrollContentWhenLoaded = true;     //是否在加载更多完成之后滚动内容显示新数据
    private boolean enableLoadMoreWhenContentNotFull = false; //在内容不满一页的时候，是否可以上拉加载更多
    private boolean disableContentWhenRefresh = false;        //是否开启在刷新时候禁止操作内容视图
    private boolean disableContentWhenLoading = false;        //是否开启在刷新时候禁止操作内容视图

    public OnItemDragListener getItemDragListener() {
        return itemDragListener;
    }

    public void setItemDragListener(OnItemDragListener itemDragListener) {
        this.itemDragListener = itemDragListener;
    }

    public OnItemHeaderClickListener getItemHeaderClickListener() {
        return itemHeaderClickListener;
    }

    public void setItemHeaderClickListener(OnItemHeaderClickListener itemHeaderClickListener) {
        this.itemHeaderClickListener = itemHeaderClickListener;
    }

    public OnPullRefreshListener getPullRefreshListener() {
        return pullRefreshListener;
    }

    public void setPullRefreshListener(OnPullRefreshListener pullRefreshListener) {
        this.pullRefreshListener = pullRefreshListener;
    }

    public OnLoadMoreListener getLoadMoreListener() {
        return loadMoreListener;
    }

    public void setLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }

    public OnRefreshOrLoadMoreListener getRefreshOrLoadMoreListener() {
        return refreshOrLoadMoreListener;
    }

    public void setRefreshOrLoadMoreListener(OnRefreshOrLoadMoreListener refreshOrLoadMoreListener) {
        this.refreshOrLoadMoreListener = refreshOrLoadMoreListener;
    }

    public OnMultiChangedListener getMultiChangedListener() {
        return multiChangedListener;
    }

    public void setMultiChangedListener(OnMultiChangedListener multiChangedListener) {
        this.multiChangedListener = multiChangedListener;
    }

    public boolean isEnableRefresh() {
        return enableRefresh;
    }

    public void setEnableRefresh(boolean enableRefresh) {
        this.enableRefresh = enableRefresh;
    }

    public boolean isEnableLoadMore() {
        return enableLoadMore;
    }

    public void setEnableLoadMore(boolean enableLoadMore) {
        this.enableLoadMore = enableLoadMore;
    }

    public boolean isEnableHeaderTranslationContent() {
        return enableHeaderTranslationContent;
    }

    public void setEnableHeaderTranslationContent(boolean enableHeaderTranslationContent) {
        this.enableHeaderTranslationContent = enableHeaderTranslationContent;
    }

    public boolean isEnableFooterTranslationContent() {
        return enableFooterTranslationContent;
    }

    public void setEnableFooterTranslationContent(boolean enableFooterTranslationContent) {
        this.enableFooterTranslationContent = enableFooterTranslationContent;
    }

    public boolean isEnableOverScrollBounce() {
        return enableOverScrollBounce;
    }

    public void setEnableOverScrollBounce(boolean enableOverScrollBounce) {
        this.enableOverScrollBounce = enableOverScrollBounce;
    }

    public boolean isEnablePureScrollMode() {
        return enablePureScrollMode;
    }

    public void setEnablePureScrollMode(boolean enablePureScrollMode) {
        this.enablePureScrollMode = enablePureScrollMode;
    }

    public boolean isEnableAutoLoadMore() {
        return enableAutoLoadMore;
    }

    public void setEnableAutoLoadMore(boolean enableAutoLoadMore) {
        this.enableAutoLoadMore = enableAutoLoadMore;
    }

    public boolean isEnableScrollContentWhenLoaded() {
        return enableScrollContentWhenLoaded;
    }

    public void setEnableScrollContentWhenLoaded(boolean enableScrollContentWhenLoaded) {
        this.enableScrollContentWhenLoaded = enableScrollContentWhenLoaded;
    }

    public boolean isEnableLoadMoreWhenContentNotFull() {
        return enableLoadMoreWhenContentNotFull;
    }

    public void setEnableLoadMoreWhenContentNotFull(boolean enableLoadMoreWhenContentNotFull) {
        this.enableLoadMoreWhenContentNotFull = enableLoadMoreWhenContentNotFull;
    }

    public boolean isDisableContentWhenRefresh() {
        return disableContentWhenRefresh;
    }

    public void setDisableContentWhenRefresh(boolean disableContentWhenRefresh) {
        this.disableContentWhenRefresh = disableContentWhenRefresh;
    }

    public boolean isDisableContentWhenLoading() {
        return disableContentWhenLoading;
    }

    public void setDisableContentWhenLoading(boolean disableContentWhenLoading) {
        this.disableContentWhenLoading = disableContentWhenLoading;
    }
}
