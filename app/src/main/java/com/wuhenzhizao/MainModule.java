package com.wuhenzhizao;

import com.gomeos.mvvm.Module;
import com.gomeos.mvvm.model.UseCaseManager;
import com.wuhenzhizao.model.MainUseCase;

/**
 * Created by wuhenzhizao on 2017/9/13.
 */

public class MainModule extends Module {

    private static MainModule instance;

    public static MainModule getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (MainModule.class) {
            if (instance == null) {
                instance = new MainModule();
            }
        }
        return instance;
    }

    @Override
    protected void onStart(UseCaseManager userCaseManager) {
        getUserCaseManager().register(MainUseCase.class);
    }
}
