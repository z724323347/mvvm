package com.summer.app.mvvm.linkage;

import androidx.lifecycle.MutableLiveData;

import com.summer.basic.lifecycle.BaseViewModel;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.summer.mvvm.linkage
 * 文件名:    LinkageViewModel
 * 创建时间:  2019-03-29 on 20:28
 * 描述:     TODO
 *
 * @author summer
 */

public class LinkageViewModel extends BaseViewModel {

    private MutableLiveData<Integer> progress = new MutableLiveData<>();

    public MutableLiveData<Integer> getProgress() {
        return progress;
    }
}
