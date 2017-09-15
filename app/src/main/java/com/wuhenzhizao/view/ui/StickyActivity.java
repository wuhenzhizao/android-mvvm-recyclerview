package com.wuhenzhizao.view.ui;

import android.os.Bundle;
import android.view.MenuItem;

import com.gomeos.mvvm.view.DataBindingFactory;
import com.gomeos.mvvm.view.ui.BaseActivity;
import com.gomeos.mvvm.viewmodel.ViewModelFactory;
import com.wuhenzhizao.MainModule;
import com.wuhenzhizao.R;
import com.wuhenzhizao.databinding.ActivityStickyBinding;
import com.wuhenzhizao.viewmodule.StickyViewModel;

/**
 * Created by wuhenzhizao on 2017/9/13.
 */

public class StickyActivity extends BaseActivity {
    public static final int MODE_SINGLE = 0;
    public static final int MODE_MULTI = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityStickyBinding binding = DataBindingFactory.setContentView(this, R.layout.activity_sticky);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("StickyHeaderRecyclerView");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewModelFactory factory = MainModule.getInstance().getViewModelFactory();
        StickyViewModel viewModel = factory.createViewModel("sticky_header_view_model", StickyViewModel.class, this);
        viewModel.setMode(getIntent().getIntExtra("mode", MODE_SINGLE));
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
