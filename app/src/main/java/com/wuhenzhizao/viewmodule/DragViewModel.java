package com.wuhenzhizao.viewmodule;

import android.content.res.Resources;
import android.os.Bundle;

import com.gomeos.mvvm.viewmodel.LifecycleViewModel;
import com.wuhenzhizao.R;
import com.wuhenzhizao.callback.ItemDragCallBack;
import com.wuhenzhizao.viewmodule.viewbean.DragViewBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wuhenzhizao on 2017/9/13.
 */

public class DragViewModel extends LifecycleViewModel {
    private List<DragViewBean> itemList;

    public List<DragViewBean> getItemList() {
        return itemList;
    }

    public ItemDragCallBack getDragCallBack(){
        return new ItemDragCallBack() {
            @Override
            public void onDrag(int fromPositon, int toPosition) {
                Collections.swap(itemList, fromPositon, toPosition);
            }
        };
    }

    @Override
    protected void onCreate(Bundle bundle) {
        itemList = new LinkedList<>();
        Resources resources = getContext().getResources();
        List<String> nameList = Arrays.asList(resources.getStringArray(R.array.drag_names));
        for (int i = 0; i < nameList.size(); i++) {
            DragViewBean viewBean = new DragViewBean();
            viewBean.setName(nameList.get(i));
            viewBean.setImage(resources.getIdentifier("drag_icon_" + (i + 1), "mipmap", getContext().getPackageName()));
            itemList.add(viewBean);
        }
        notifyChange();
    }
}
