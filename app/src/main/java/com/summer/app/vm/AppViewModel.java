package com.summer.app.vm;

import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.summer.app.bus.ReturnResult;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class AppViewModel extends ViewModel {

    private MutableLiveData<String> text = new MutableLiveData<>();

    public MutableLiveData<String> getButtonText() {
        return text;
    }

    public void setButtonText(String text) {
        this.text.setValue(text);
    }



    /**
     * 按钮点击事件
     */
    public void item(View view, int position) {
        switch (position) {
            case 0:
                Toast.makeText(view.getContext(),"position _ $position" +position,Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(view.getContext(),"position _ $position" +position,Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(view.getContext(),"position _ $position" +position,Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(view.getContext(),"position _ $position" +position,Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ReturnResult result) {
        //接收以及处理数据
        this.setButtonText("..." + result.getStatus());
    };


}
