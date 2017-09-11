package com.wuhenzhizao.util;

import android.content.Context;

import com.wuhenzhizao.viewmodel.BaseViewModel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * <p>
 * Created by wuhenzhizao on 15/12/26.
 */
public class ObjectUtils {

    public static <VB> BaseViewModel<VB> getViewModel(Class<? extends BaseViewModel<VB>> clas) {
        try {
            Constructor<? extends BaseViewModel<VB>> constructor = clas.getConstructor(Context.class);
            return constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        throw new NullPointerException("Create ViewModel Failed !");
    }
}
