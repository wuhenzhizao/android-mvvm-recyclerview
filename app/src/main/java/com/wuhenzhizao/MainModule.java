package com.wuhenzhizao;

import com.gomeos.mvvm.FrameworkModule;
import com.gomeos.mvvm.model.UseCaseManager;
import com.wuhenzhizao.model.MainUseCase;

/**
 * Created by liufei on 2017/9/13.
 */

public class MainModule extends FrameworkModule {

    @Override
    protected void onStart(UseCaseManager userCaseManager) {
        getUserCaseManager().register(MainUseCase.class);


    }
}
