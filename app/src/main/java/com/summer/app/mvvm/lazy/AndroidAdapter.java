package com.summer.app.mvvm.lazy;

import com.summer.app.BR;
import com.summer.app.R;
import com.summer.app.databinding.ItemJueJinBinding;
import com.summer.basic.adapter.BaseDBRVAdapter;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.summer.mvvm.lazy
 * 文件名:    AndroidAdapter
 * 创建时间:  2019-03-29 on 10:44
 * 描述:     TODO
 *
 * @author summer
 */

public class AndroidAdapter extends BaseDBRVAdapter<JueJinBean.DBean.EntrylistBean, ItemJueJinBinding> {

    public AndroidAdapter() {
        super(R.layout.item_jue_jin, BR.bean);
    }
}
