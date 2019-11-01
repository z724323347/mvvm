package com.summer.app.mvvm.news;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.summer.app.BR;
import com.summer.app.R;
import com.summer.app.databinding.ItemNesBinding;
import com.summer.basic.adapter.BaseDBRVAdapter;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm.main
 * 文件名:    NewsAdapter
 * 创建时间:  2019-03-27 on 16:34
 * 描述:     TODO
 *
 * @author summer
 */

public class NewsAdapter extends BaseDBRVAdapter<NewsBean.StoriesBean, ItemNesBinding> {

    public NewsAdapter() {
        super(R.layout.item_nes, BR.bean);
    }

    /**
     * 绑定Adapter的ImageView
     *
     * @param imageView
     * @param url       图片地址
     */
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
