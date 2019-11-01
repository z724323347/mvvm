package com.summer.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.summer.app.databinding.ActivityMainBinding;
import com.summer.app.vm.MainViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;

    MainViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mBinding.setViewModel(mViewModel);
        mBinding.setLifecycleOwner(this);
        mViewModel.setTest("h......\n MVVM");
    }
}
