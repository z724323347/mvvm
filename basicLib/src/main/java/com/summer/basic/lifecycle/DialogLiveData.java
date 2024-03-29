package com.summer.basic.lifecycle;

import androidx.lifecycle.MutableLiveData;

import com.summer.basic.bean.DialogBean;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.summer.basic.lifecycle
 * 文件名:    DialogLiveData
 * 创建时间:  2019-03-27 on 20:57
 * 描述:     TODO
 *
 * @author summer
 */

public final class DialogLiveData<T> extends MutableLiveData<T> {

    private DialogBean bean = new DialogBean();

    public void setValue(boolean isShow) {
        bean.setShow(isShow);
        bean.setMsg("");
        setValue((T) bean);
    }

    public void setValue(boolean isShow, String msg) {
        bean.setShow(isShow);
        bean.setMsg(msg);
        setValue((T) bean);
    }
}