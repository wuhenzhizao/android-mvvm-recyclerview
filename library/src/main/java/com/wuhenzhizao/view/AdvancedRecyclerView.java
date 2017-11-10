package com.wuhenzhizao.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.gomeos.mvvm.view.LayoutManagers;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.impl.RefreshContentWrapper;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.wuhenzhizao.adapter.R;
import com.wuhenzhizao.api.OnLoadMoreListener;
import com.wuhenzhizao.api.OnPullRefreshListener;
import com.wuhenzhizao.api.OnRefreshOrLoadMoreListener;
import com.wuhenzhizao.view.proxy.RefreshRecyclerViewProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by wuhenzhizao on 2017/9/20.
 */
public class AdvancedRecyclerView extends SmartRefreshLayout implements DataBindingInterface {
    private BaseRecyclerView recyclerView;

    private String refreshHeaderClass = CommonHeader.class.getName();
    private String refreshFooterClass = CommonFooter.class.getName();
    private int mode;

    public static final int MODE_NONE = 0;
    public static final int MODE_NORMAL = 1;     // DefaultRecyclerView
    public static final int MODE_STICKY = 2;     // StickyHeaderRecyclerView
    public static final int MODE_SWIPE = 3;      // SwipeMenuRecyclerView
    public static final int MODE_DRAG = 4;       // DragRecyclerView

    public AdvancedRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttributes(context, attrs);
        initChildView(context, attrs, 0);
    }

    public AdvancedRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributes(context, attrs);
        initChildView(context, attrs, defStyleAttr);
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.AdvancedRecyclerView);
        if (ta != null) {
            if (ta.hasValue(R.styleable.AdvancedRecyclerView_refreshHeaderClass)) {
                refreshHeaderClass = ta.getString(R.styleable.AdvancedRecyclerView_refreshHeaderClass);
            }
            if (ta.hasValue(R.styleable.AdvancedRecyclerView_refreshFooterClass)) {
                refreshFooterClass = ta.getString(R.styleable.AdvancedRecyclerView_refreshFooterClass);
            }
            mode = ta.getInt(R.styleable.AdvancedRecyclerView_contentMode, MODE_NORMAL);
            ta.recycle();
        }
    }

    private void initChildView(Context context, AttributeSet attrs, int defStyleAttr) {
        if (mode != MODE_NONE) {
            initHeader(context, attrs);
            initFooter(context, attrs);
            initContent(context, attrs, defStyleAttr);
        }
    }

    private void initHeader(Context context, AttributeSet attrs) {
        try {
            Class cls = Class.forName(refreshHeaderClass);
            Constructor constructor = cls.getDeclaredConstructor(Context.class, AttributeSet.class);
            Object refreshHeader = constructor.newInstance(context, attrs);
            setRefreshHeader((RefreshHeader) refreshHeader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void initFooter(Context context, AttributeSet attrs) {
        try {
            Class cls = Class.forName(refreshFooterClass);
            Constructor constructor = cls.getDeclaredConstructor(Context.class, AttributeSet.class);
            Object refreshFooter = constructor.newInstance(context, attrs);
            setRefreshFooter((RefreshFooter) refreshFooter);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void initContent(Context context, AttributeSet attrs, int defStyleAttr) {
        if (mode == MODE_NORMAL) {
            recyclerView = new DefaultRecyclerView(context, attrs, defStyleAttr);
        } else if (mode == MODE_STICKY) {
            recyclerView = new StickyHeaderRecyclerView(context, attrs, defStyleAttr);
        } else if (mode == MODE_SWIPE) {
            recyclerView = new SwipeMenuRecyclerView(context, attrs, defStyleAttr);
        } else if (mode == MODE_DRAG) {
            recyclerView = new DragRecyclerView(context, attrs, defStyleAttr);
        }

        ClassicsHeader refreshHeader = new ClassicsHeader(context, attrs, defStyleAttr);
        refreshHeader.setSpinnerStyle(SpinnerStyle.Scale);
        setRefreshHeader(refreshHeader);
        ClassicsFooter refreshFooter = new ClassicsFooter(context, attrs, defStyleAttr);
        refreshFooter.setSpinnerStyle(SpinnerStyle.Scale);
        setRefreshFooter(refreshFooter);

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        recyclerView.setLayoutParams(params);
        addView(recyclerView);
        mRefreshContent = new RefreshContentWrapper(recyclerView);
    }

    public BaseRecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    public void setItemViewFactory(String className) {
        recyclerView.setItemViewFactory(className);
    }

    @Override
    public void setLayoutManager(LayoutManagers.LayoutManagerFactory factory) {
        recyclerView.setLayoutManager(factory);
    }

    @Override
    public void setItemDecoration(RecyclerView.ItemDecoration decoration) {
        recyclerView.addItemDecoration(decoration);
    }

    @Override
    public void setItems(List items) {
        recyclerView.setItems(items);
    }

    @BindingAdapter("proxy")
    public static void setProxy(AdvancedRecyclerView layout, RefreshRecyclerViewProxy proxy) {
        OnPullRefreshListener refreshListener = proxy.getPullRefreshListener();
        if (refreshListener != null) {
            layout.setOnRefreshListener(refreshListener);
        }
        OnLoadMoreListener loadMoreListener = proxy.getLoadMoreListener();
        if (loadMoreListener != null) {
            layout.setOnLoadmoreListener(loadMoreListener);
        }
        OnRefreshOrLoadMoreListener refreshOrLoadMoreListener = proxy.getRefreshOrLoadMoreListener();
        if (refreshOrLoadMoreListener != null) {
            layout.setOnRefreshLoadmoreListener(proxy.getRefreshOrLoadMoreListener());
        }
        OnMultiPurposeListener multiPurposeListener = proxy.getMultiChangedListener();
        if (multiPurposeListener != null) {
            layout.setOnMultiPurposeListener(proxy.getMultiChangedListener());
        }
        layout.setEnableRefresh(proxy.isEnableRefresh());
        layout.setEnableLoadmore(proxy.isEnableLoadMore());
        layout.setEnableAutoLoadmore(proxy.isEnableAutoLoadMore());
        layout.setEnableHeaderTranslationContent(proxy.isEnableHeaderTranslationContent());
        layout.setEnableFooterTranslationContent(proxy.isEnableFooterTranslationContent());
        layout.setEnableOverScrollBounce(proxy.isEnableOverScrollBounce());
        layout.setEnablePureScrollMode(proxy.isEnablePureScrollMode());
        layout.setEnableOverScrollDrag(proxy.isEnableOverScrollDrag());
        layout.setEnableScrollContentWhenLoaded(proxy.isEnableScrollContentWhenLoaded());
        layout.setEnableLoadmoreWhenContentNotFull(proxy.isEnableLoadMoreWhenContentNotFull());
        layout.setDisableContentWhenRefresh(proxy.isDisableContentWhenRefresh());
        layout.setDisableContentWhenLoading(proxy.isDisableContentWhenLoading());

        RecyclerView recyclerView = layout.getRecyclerView();
        if (recyclerView instanceof DragRecyclerView) {
            ((DragRecyclerView) recyclerView).setDragListener(proxy.getItemDragListener());
        } else if (recyclerView instanceof StickyHeaderRecyclerView) {
            ((StickyHeaderRecyclerView) recyclerView).setHeaderClickListener(proxy.getItemHeaderClickListener());
        }

        RecyclerView.ItemDecoration decoration = proxy.getItemDecoration();
        if (decoration != null) {
            layout.setItemDecoration(decoration);
        }

        proxy.attach(recyclerView);
        proxy.attachRefreshView(layout);
    }
}
