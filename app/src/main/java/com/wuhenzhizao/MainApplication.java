package com.wuhenzhizao;

import android.support.multidex.MultiDexApplication;

import com.gomeos.mvvm.ModuleManager;

/**
 * Created by wuhenzhizao on 2017/9/13.
 */

public class MainApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        ModuleManager.getInstance().init(this);
        ModuleManager.getInstance().installModule(MainModule.getInstance());
    }
}
