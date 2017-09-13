package com.wuhenzhizao.view.ui;

import android.os.Bundle;

import com.gomeos.mvvm.view.DataBindingFactory;
import com.gomeos.mvvm.view.ui.BaseActivity;
import com.gomeos.mvvm.viewmodel.ViewModelFactory;
import com.wuhenzhizao.MainModule;
import com.wuhenzhizao.R;
import com.wuhenzhizao.databinding.ActivityMainBinding;
import com.wuhenzhizao.viewmodule.MainViewModel;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingFactory.setContentView(this, R.layout.activity_main);

        ViewModelFactory factory = MainModule.getInstance().getViewModelFactory();
        MainViewModel viewModel = factory.createViewModel("main_view_model", MainViewModel.class, this);
        binding.setVm(viewModel);
        addViewModel(viewModel);
    }
}
