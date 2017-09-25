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
import com.wuhenzhizao.databinding.FragmentMainSwipeBinding;
import com.wuhenzhizao.viewmodule.MainSwipeViewModel;

/**
 * Created by wuhenzhizao on 2017/9/22.
 */

public class MainSwipeFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentMainSwipeBinding binding = DataBindingFactory.inflate(getContext(), R.layout.fragment_main_swipe);

        ViewModelFactory factory = MainModule.getInstance().getViewModelFactory();
        MainSwipeViewModel viewModel = factory.createViewModel("main_swipe_view_model", MainSwipeViewModel.class, this);
        binding.setVm(viewModel);
        addViewModel(viewModel);

        return binding.getRoot();
    }
}
