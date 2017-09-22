package com.wuhenzhizao.view.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.gomeos.mvvm.view.DataBindingFactory;
import com.gomeos.mvvm.view.ui.BaseActivity;
import com.wuhenzhizao.R;
import com.wuhenzhizao.databinding.ActivityMainBinding;
import com.wuhenzhizao.view.adapter.MainViewPagerAdapter;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingFactory.setContentView(this, R.layout.activity_main);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("AdvancedRecyclerView");

        binding.pagerMain.setAdapter(new MainViewPagerAdapter(this, getSupportFragmentManager()));
        binding.tabMain.setViewPager(binding.pagerMain);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_about_us) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.github.com/wuhenzhizao"));
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
