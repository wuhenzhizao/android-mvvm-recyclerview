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
import com.wuhenzhizao.databinding.FragmentMainDragBinding;
import com.wuhenzhizao.viewmodule.MainDragViewModel;

/**
 * Created by wuhenzhizao on 2017/9/22.
 */

public class MainDragFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentMainDragBinding binding = DataBindingFactory.inflate(getContext(), R.layout.fragment_main_drag);

        ViewModelFactory factory = MainModule.getInstance().getViewModelFactory();
        MainDragViewModel viewModel = factory.createViewModel("main_drag_view_model", MainDragViewModel.class, this);
        binding.setVm(viewModel);
        addViewModel(viewModel);

        return binding.getRoot();
    }
}
