package com.summer.app;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.summer.app.databinding.ActivityAppBinding;
import com.summer.app.vm.AppViewModel;


public class AppActivity extends AppCompatActivity {

    ActivityAppBinding mBinding;
    AppViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_app);
        mViewModel = ViewModelProviders.of(this).get(AppViewModel.class);
        mBinding.setViewModel(mViewModel);
        mBinding.setLifecycleOwner(this);
        mViewModel.setButtonText("\n AppActivity");
    }
}
