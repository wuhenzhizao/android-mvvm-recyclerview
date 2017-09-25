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
import com.wuhenzhizao.databinding.FragmentMainIndexableBinding;
import com.wuhenzhizao.viewmodule.MainIndexableViewModel;

/**
 * Created by wuhenzhizao on 2017/9/22.
 */

public class MainIndexableFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentMainIndexableBinding binding = DataBindingFactory.inflate(getContext(), R.layout.fragment_main_indexable);

        ViewModelFactory factory = MainModule.getInstance().getViewModelFactory();
        MainIndexableViewModel viewModel = factory.createViewModel("main_indexable_view_model", MainIndexableViewModel.class, this);
        binding.setVm(viewModel);
        addViewModel(viewModel);

        return binding.getRoot();
    }
}
