package com.wuhenzhizao.model;

import com.gomeos.mvvm.model.UseCase;

/**
 * Created by wuhenzhizao on 2017/9/13.
 */

public class MainUseCase extends UseCase {

    @Override
    protected void onOpen() {

    }

    @Override
    protected void onClose() {

    }

    public String[] getProviceList() {
        return Address.provinces;
    }

    public String[][] getCityList() {
        return Address.citys;
    }
}
