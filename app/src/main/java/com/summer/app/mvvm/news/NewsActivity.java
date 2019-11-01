package com.summer.app.mvvm.news;

import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.summer.app.R;
import com.summer.app.databinding.ActivityNewsBinding;
import com.summer.basic.base.BaseActivity;


public class NewsActivity extends BaseActivity<NewsViewModel, ActivityNewsBinding> {

    private NewsAdapter adapter;

    @Override
    protected int onCreate() {
        return R.layout.activity_news;
    }

    @Override
    protected NewsViewModel initViewModel() {
        return ViewModelProviders.of(this).get(NewsViewModel.class);
    }

    @Override
    protected void initView() {
        RecyclerView rvNews = dataBinding.rvNews;
        LinearLayoutManager manager = new LinearLayoutManager(this);
        adapter = new NewsAdapter();
        rvNews.setLayoutManager(manager);
        rvNews.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        dataBinding.setModel(this);
        //数据请求成功通知
        viewModel.getNews().observe(this, new Observer<NewsBean>() {
            @Override
            public void onChanged(NewsBean newsBean) {
                adapter.setNewData(newsBean.getStories());
            }
        });
    }

    @Override
    protected void showError(Object obj) {

    }

    /**
     * 按钮点击事件
     */
    public void requestData(View view) {
        viewModel.requestData();
    }

}
