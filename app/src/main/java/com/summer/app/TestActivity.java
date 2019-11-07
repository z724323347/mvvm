package com.summer.app;

import android.content.Intent;
import android.provider.Settings;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import com.summer.basic.base.BaseNoModelActivity;
import com.summer.app.databinding.ActivityTestBinding;

public class TestActivity extends BaseNoModelActivity<ActivityTestBinding> {
    @Override
    protected int onCreate() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {
        configToolbar();
    }

    @Override
    protected void initData() {
        dataBinding.setViewModel(this);
    }

    private void configToolbar() {
//        Toolbar toolbar = dataBinding.toolbar;
//        toolbar.setBackgroundResource(R.color.light_theme_background);
//        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setTitle("EventBus");
//            actionBar.setSubtitle("Demo activity 1");
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }
    }

    /**
     * 按钮点击事件
     */
    public void item(View view, int position) {
        switch (position) {
            case 0:
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setData(android.net.Uri.parse("package:" + view.getContext().getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                view.getContext().startActivity(intent);
                break;
//            case 1:
//                Toast.makeText(view.getContext(),"position _ $position" +position,Toast.LENGTH_SHORT).show();
//                break;
//            case 2:
//                Toast.makeText(view.getContext(),"position _ $position" +position,Toast.LENGTH_SHORT).show();
//                break;
//            case 3:
//                Toast.makeText(view.getContext(),"position _ $position" +position,Toast.LENGTH_SHORT).show();
//                break;
            default:
                break;
        }
    }
}
