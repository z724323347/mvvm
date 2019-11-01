package com.summer.app.mvvm.detail;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

import com.summer.app.R;
import com.summer.app.databinding.FragmentDetailBinding;
import com.summer.basic.base.BaseNoModelFragment;


/**
 * 项目名:    TODO-MVVM
 * 包名       com.summer.mvvm.detail
 * 文件名:    DetailFragment
 * 创建时间:  2019-03-28 on 17:27
 * 描述:     TODO
 *
 * @author summer
 */

public class DetailFragment extends BaseNoModelFragment<FragmentDetailBinding> {

    public static Fragment newInstance(String url) {
        Bundle args = new Bundle();
        args.putString("url", url);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int onCreate() {
        return R.layout.fragment_detail;
    }

    @Override
    protected void initView() {
        WebView webView = dataBinding.webView;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }

    @Override
    protected void initData() {
        String url = getArguments().getString("url");
        dataBinding.webView.loadUrl(url);
    }
}
