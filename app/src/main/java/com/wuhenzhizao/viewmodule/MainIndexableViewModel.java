package com.wuhenzhizao.viewmodule;

import com.gomeos.mvvm.viewmodel.LifecycleViewModel;
import com.gomeos.mvvm.viewmodel.command.OnClickCommand;

/**
 * Created by wuhenzhizao on 2017/9/22.
 */

public class MainIndexableViewModel extends LifecycleViewModel{

    public OnClickCommand getIndexableClickCommand(){
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {

            }
        };
    }

    public OnClickCommand getRefreshClickCommand(){
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {

            }
        };
    }
}
