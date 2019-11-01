package com.summer.app.base;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.summer.app.R;
import com.summer.app.databinding.ActivityBaseBinding;
import com.summer.app.utils.ClassUtil;
import com.summer.app.view.statusbar.StatusBarUtil;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class TBaseActivity<VM extends AndroidViewModel, SV extends ViewDataBinding> extends AppCompatActivity {

    // ViewModel
    protected VM viewModel;
    // 布局view
    protected SV bindingView;

    private View errorView;
    private View loadingView;

    private ActivityBaseBinding mBaseBinding;
    private AnimationDrawable mAnimationDrawable;
    private CompositeDisposable mCompositeDisposable;


    protected <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
//        super.setContentView(layoutResID);
        mBaseBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_base, null, false);
        bindingView = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, null, false);

        // content
        RelativeLayout.LayoutParams params =
                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        bindingView.getRoot().setLayoutParams(params);
        RelativeLayout mContainer = (RelativeLayout) mBaseBinding.getRoot().findViewById(R.id.container);
        mContainer.addView(bindingView.getRoot());
        getWindow().setContentView(mBaseBinding.getRoot());

        //设置透明状态栏，兼容4.4
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorTheme), 0);
        loadingView = ((ViewStub) findViewById(R.id.vs_loading)).inflate();
        ImageView img = loadingView.findViewById(R.id.img_progress);

        //加载动画
        mAnimationDrawable = (AnimationDrawable) img.getDrawable();
        //默认进入页面开启动画
        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }

        setToolBar(mBaseBinding.toolBar);
        bindingView.getRoot().setVisibility(View.GONE);
        initViewModel();
    }

    /**
     * 初始化ViewModel
     */
    private void initViewModel() {
        Class<VM> viewModelClass = ClassUtil.getViewModel(this);
        if (viewModelClass != null) {
            this.viewModel = ViewModelProviders.of(this).get(viewModelClass);
        }
    }

    /**
     *
     */
    protected void setToolBar(Toolbar toolBar) {
        setSupportActionBar(toolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.icon_back);
        }
        toolBar.setNavigationOnClickListener(v -> supportFinishAfterTransition());
    }

    //    @Override
    public void setTitle(CharSequence text) {
        mBaseBinding.toolBar.setTitle(text);
    }

    public void setNoTitle() {
        mBaseBinding.toolBar.setVisibility(View.GONE);
    }

    protected void showLoading() {
        if (loadingView != null && loadingView.getVisibility() != View.VISIBLE) {
            loadingView.setVisibility(View.VISIBLE);
        }
        //开始动画
        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }
        if (bindingView.getRoot().getVisibility() != View.GONE) {
            bindingView.getRoot().setVisibility(View.GONE);
        }
        if (errorView != null) {
            errorView.setVisibility(View.GONE);
        }
    }

    protected void showContentView() {
        if (loadingView != null && loadingView.getVisibility() != View.GONE) {
            loadingView.setVisibility(View.GONE);
        }
        // 停止动画
        if (mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }
        if (errorView != null) {
            errorView.setVisibility(View.GONE);
        }
        if (bindingView.getRoot().getVisibility() != View.VISIBLE) {
            bindingView.getRoot().setVisibility(View.VISIBLE);
        }
    }

    protected void showError() {
        if (loadingView != null && loadingView.getVisibility() != View.GONE) {
            loadingView.setVisibility(View.GONE);
        }
        // 停止动画
        if (mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }
        if (errorView == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.vs_error_refresh);
            errorView = viewStub.inflate();
            // 点击加载失败布局
            errorView.setOnClickListener(v -> {
                showLoading();
                onRefresh();
            });
        } else {
            errorView.setVisibility(View.VISIBLE);
        }
        if (bindingView.getRoot().getVisibility() != View.GONE) {
            bindingView.getRoot().setVisibility(View.GONE);
        }
    }

    /**
     * 失败后点击刷新
     */
    protected void onRefresh() {

    }

    public void addSubscription(Disposable s) {
        if (this.mCompositeDisposable == null) {
            this.mCompositeDisposable = new CompositeDisposable();
        }
        this.mCompositeDisposable.add(s);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.fontScale != 1) {
            getResources();
        }
    }

    /**
     * 禁止改变字体大小
     */
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config,res.getDisplayMetrics());
        return  res;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            // clear 和 dispose的区别是：  disposed = true;
            this.mCompositeDisposable.clear();
        }
    }
}
