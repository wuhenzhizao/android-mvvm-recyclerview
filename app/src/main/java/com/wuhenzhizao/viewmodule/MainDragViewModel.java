package com.wuhenzhizao.viewmodule;

import android.content.Intent;

import com.gomeos.mvvm.viewmodel.LifecycleViewModel;
import com.gomeos.mvvm.viewmodel.command.OnClickCommand;
import com.wuhenzhizao.view.ui.DragActivity;

/**
 * Created by wuhenzhizao on 2017/9/22.
 */

public class MainDragViewModel extends LifecycleViewModel {

    public OnClickCommand getDragClickCommand() {
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {
                Intent intent = new Intent(getContext(), DragActivity.class);
                startActivity(intent);
            }
        };
    }
}
