package com.wuhenzhizao.viewmodule;

import android.content.Intent;

import com.gomeos.mvvm.viewmodel.LifecycleViewModel;
import com.gomeos.mvvm.viewmodel.command.OnClickCommand;
import com.wuhenzhizao.view.ui.SwipeMenuActivity;

/**
 * Created by wuhenzhizao on 2017/9/22.
 */

public class MainSwipeViewModel extends LifecycleViewModel {

    public OnClickCommand getSwipeLeftClickCommand() {
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {
                Intent intent = new Intent(getContext(), SwipeMenuActivity.class);
                intent.putExtra("mode", SwipeMenuActivity.LEFT);
                startActivity(intent);
            }
        };
    }

    public OnClickCommand getSwipeRightClickCommand() {
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {
                Intent intent = new Intent(getContext(), SwipeMenuActivity.class);
                intent.putExtra("mode", SwipeMenuActivity.RIGHT);
                startActivity(intent);
            }
        };
    }

    public OnClickCommand getSwipeRefreshClickCommand() {
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {
                Intent intent = new Intent(getContext(), SwipeMenuActivity.class);
                intent.putExtra("mode", SwipeMenuActivity.RIGHT_REFRESH);
                startActivity(intent);
            }
        };
    }
}
