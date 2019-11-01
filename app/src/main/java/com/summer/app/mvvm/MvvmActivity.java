package com.summer.app.mvvm;

import android.content.Intent;
import android.view.View;
import com.summer.app.R;
import com.summer.app.databinding.ActivityMvvmBinding;
import com.summer.app.mvvm.detail.DetailActivity;
import com.summer.app.mvvm.lazy.LazyActivity;
import com.summer.app.mvvm.linkage.LinkageActivity;
import com.summer.app.mvvm.news.NewsActivity;
import com.summer.basic.base.BaseNoModelActivity;

public class MvvmActivity extends BaseNoModelActivity<ActivityMvvmBinding> {
    @Override
    protected int onCreate() {
        return R.layout.activity_mvvm;
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        dataBinding.setModel(this);
    }

    /**
     * 按钮点击事件
     */
    public void item(View view, int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(context, NewsActivity.class));
                break;
            case 1:
                startActivity(new Intent(context, DetailActivity.class));
                break;
            case 2:
                startActivity(new Intent(context, LazyActivity.class));
                break;
            case 3:
                startActivity(new Intent(context, LinkageActivity.class));
                break;
            default:
                break;
        }
    }
}
