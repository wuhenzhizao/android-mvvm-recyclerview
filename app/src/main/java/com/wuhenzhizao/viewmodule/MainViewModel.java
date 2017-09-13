package com.wuhenzhizao.viewmodule;

import android.content.Intent;
import android.os.Bundle;

import com.gomeos.mvvm.viewmodel.LifecycleViewModel;
import com.gomeos.mvvm.viewmodel.command.OnClickCommand;
import com.wuhenzhizao.view.ui.DragActivity;

/**
 * Created by liufei on 2017/9/13.
 */

public class MainViewModel extends LifecycleViewModel {

    @Override
    protected void onCreate(Bundle bundle) {

    }

    public OnClickCommand getSingleStickyClickCommand() {
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {

            }
        };
    }

    public OnClickCommand getMultiStickyClickCommand() {
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {

            }
        };
    }

    public OnClickCommand getLeftSwipeClickCommand() {
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {

            }
        };
    }

    public OnClickCommand getRightSwipeClickCommand() {
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {

            }
        };
    }

    public OnClickCommand getDragClickCommand() {
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {
                startActivity(new Intent(getContext(), DragActivity.class));
            }
        };
    }
}
