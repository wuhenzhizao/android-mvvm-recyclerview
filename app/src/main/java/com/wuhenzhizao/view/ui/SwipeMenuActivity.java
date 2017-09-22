package com.wuhenzhizao.view.ui;

import android.os.Bundle;
import android.view.MenuItem;

import com.gomeos.mvvm.view.DataBindingFactory;
import com.gomeos.mvvm.view.ui.BaseActivity;
import com.gomeos.mvvm.viewmodel.ViewModelFactory;
import com.wuhenzhizao.MainModule;
import com.wuhenzhizao.R;
import com.wuhenzhizao.databinding.ActivitySwipeMenuBinding;
import com.wuhenzhizao.viewmodule.SwipeViewModel;

/**
 * Created by wuhenzhizao on 2017/9/13.
 */

public class SwipeMenuActivity extends BaseActivity {
    public static final int LEFT = 1;
    public static final int RIGHT = 0;
    public static final int RIGHT_REFRESH = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySwipeMenuBinding binding = DataBindingFactory.setContentView(this, R.layout.activity_swipe_menu);

        int mode = getIntent().getIntExtra("mode", RIGHT);

        setSupportActionBar(binding.toolbar);
        switch (mode) {
            case LEFT:
                getSupportActionBar().setTitle(getString(R.string.main_swipe_left));
                break;
            case RIGHT:
                getSupportActionBar().setTitle(getString(R.string.main_swipe_right));
                break;
            case RIGHT_REFRESH:
                getSupportActionBar().setTitle(getString(R.string.main_swipe_refresh));
                break;
        }
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewModelFactory factory = MainModule.getInstance().getViewModelFactory();
        SwipeViewModel viewModel = factory.createViewModel("swipe_view_model", SwipeViewModel.class, this);
        viewModel.setMode(mode);
        binding.setVm(viewModel);
        addViewModel(viewModel);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }
}
