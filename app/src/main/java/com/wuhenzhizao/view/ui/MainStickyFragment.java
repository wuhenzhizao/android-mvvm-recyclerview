package com.wuhenzhizao.view.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gomeos.mvvm.view.DataBindingFactory;
import com.gomeos.mvvm.view.ui.BaseFragment;
import com.gomeos.mvvm.viewmodel.ViewModelFactory;
import com.wuhenzhizao.MainModule;
import com.wuhenzhizao.R;
import com.wuhenzhizao.databinding.FragmentMainStickyBinding;
import com.wuhenzhizao.viewmodule.MainStickyViewModel;

/**
 * Created by wuhenzhizao on 2017/9/22.
 */

public class MainStickyFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentMainStickyBinding binding = DataBindingFactory.inflate(getContext(), R.layout.fragment_main_sticky);

        ViewModelFactory factory = MainModule.getInstance().getViewModelFactory();
        MainStickyViewModel viewModel = factory.createViewModel("main_sticky_view_model", MainStickyViewModel.class, this);
        binding.setVm(viewModel);
        addViewModel(viewModel);

        return binding.getRoot();
    }
}
