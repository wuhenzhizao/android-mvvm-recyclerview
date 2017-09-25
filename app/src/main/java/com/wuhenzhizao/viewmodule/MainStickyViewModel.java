package com.wuhenzhizao.viewmodule;

import android.content.Intent;

import com.gomeos.mvvm.viewmodel.LifecycleViewModel;
import com.gomeos.mvvm.viewmodel.command.OnClickCommand;
import com.wuhenzhizao.view.ui.StickyActivity;

/**
 * Created by wuhenzhizao on 2017/9/22.
 */

public class MainStickyViewModel extends LifecycleViewModel {

    public OnClickCommand getSingleTypeClickCommand() {
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {
                Intent intent = new Intent(getContext(), StickyActivity.class);
                intent.putExtra("mode", StickyActivity.MODE_SINGLE);
                startActivity(intent);
            }
        };
    }

    public OnClickCommand getMultipleTypeClickCommand() {
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {
                Intent intent = new Intent(getContext(), StickyActivity.class);
                intent.putExtra("mode", StickyActivity.MODE_MULTI);
                startActivity(intent);
            }
        };
    }

    public OnClickCommand getRefreshTypeClickCommand() {
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {
                Intent intent = new Intent(getContext(), StickyActivity.class);
                intent.putExtra("mode", StickyActivity.MODE_SINGLE_REFRESH);
                startActivity(intent);
            }
        };
    }
}
